package com.telapi.api.http;

import java.io.IOException;

import org.apache.http.HttpException;
import org.apache.http.HttpHost;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.auth.AuthScheme;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.AuthState;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.params.ConnRoutePNames;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.ExecutionContext;
import org.apache.http.protocol.HttpContext;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.telapi.api.configuration.TelapiConfiguration;

public class RestExecutor {
	
	public static ApacheHttpClient4Executor createExecutor(TelapiConfiguration conf){
		Credentials credentials = new UsernamePasswordCredentials(conf.getSid(), conf.getAuthToken());
		ApacheHttpClient4Executor executor = new ApacheHttpClient4Executor();
		DefaultHttpClient httpClient  = (DefaultHttpClient) executor.getHttpClient();
		
		if (conf.getProxyHost() != null && !conf.getProxyHost().trim().isEmpty()) {
			HttpHost proxy = new HttpHost(conf.getProxyHost(), Integer.parseInt(conf.getProxyPort()), conf.getProxyProtocol());
			httpClient.getParams().setParameter(ConnRoutePNames.DEFAULT_PROXY, proxy);
		}
		httpClient.addRequestInterceptor(new PreemptiveAuthInterceptor(), 0);
		httpClient.getCredentialsProvider().setCredentials(
                new AuthScope(AuthScope.ANY_HOST, AuthScope.ANY_PORT),
                credentials
        );
		
		BasicHttpContext localContext = new BasicHttpContext();
        BasicScheme basicAuth = new BasicScheme();
        localContext.setAttribute("preemptive-auth", basicAuth);
        executor.setHttpContext(localContext);
        return executor;
	}
	
	private RestExecutor(){
	}
	
	
	static class PreemptiveAuthInterceptor implements HttpRequestInterceptor {
	    public void process(final HttpRequest request, final HttpContext context) throws HttpException, IOException {
	        AuthState authState = (AuthState) context.getAttribute(ClientContext.TARGET_AUTH_STATE);
	        if (authState.getAuthScheme() == null) {
	            AuthScheme authScheme = (AuthScheme) context.getAttribute("preemptive-auth");
	            CredentialsProvider credsProvider = (CredentialsProvider) context.getAttribute(ClientContext.CREDS_PROVIDER);
	            HttpHost targetHost = (HttpHost) context.getAttribute(ExecutionContext.HTTP_TARGET_HOST);
	            if (authScheme != null) {
	                Credentials creds = credsProvider.getCredentials(new AuthScope(targetHost.getHostName(), targetHost.getPort()));
	                if (creds == null) {
	                    throw new HttpException("No credentials for preemptive authentication");
	                }
	                authState.setAuthScheme(authScheme);
	                authState.setCredentials(creds);
	            }
	        }
	    }

	}
}
