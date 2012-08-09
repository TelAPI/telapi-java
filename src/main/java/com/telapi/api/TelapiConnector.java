package com.telapi.api;

import java.net.URI;
import java.util.Date;

import javax.ws.rs.core.UriBuilder;

import org.jboss.resteasy.client.ClientResponse;
import org.jboss.resteasy.client.ProxyFactory;
import org.jboss.resteasy.client.core.executors.ApacheHttpClient4Executor;

import com.telapi.api.configuration.DefaultTelapiConfiguration;
import com.telapi.api.configuration.TelapiConfiguration;
import com.telapi.api.domain.Account;
import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.list.AccountsList;
import com.telapi.api.domain.list.SmsMessageList;
import com.telapi.api.exceptions.TelapiException;
import com.telapi.api.http.RestExecutor;
import com.telapi.api.restproxies.AccountsProxy;
import com.telapi.api.restproxies.SmsProxy;

public class TelapiConnector {

	private ApacheHttpClient4Executor executor;
	private TelapiConfiguration conf;
	private String fullBaseUrl;
	
	private AccountsProxy accountsProxy;
	private SmsProxy smsProxy;	
	
	public TelapiConnector(TelapiConfiguration conf) {
		this.conf = conf;
		executor = RestExecutor.createExecutor(conf);
		URI baseUrl = UriBuilder.fromUri(conf.getBaseUrl()).path(DefaultTelapiConfiguration.API_VERSION).build();
		fullBaseUrl = baseUrl.toString();
		
		accountsProxy = createProxy(AccountsProxy.class);
		smsProxy = createProxy(SmsProxy.class);
	}
	
	private <T> T createProxy(Class<T> clazz) {
		return ProxyFactory.create(clazz, fullBaseUrl, executor);
	}
	
	private <T> T returnThrows(ClientResponse<T> response) throws TelapiException{
		int status = response.getStatus();
		if (status > 399) {
			TelapiException exception = response.getEntity(TelapiException.class);
			throw exception;
		}
		return response.getEntity();
	}
	
	private String getDateString(Date date) {
		if (date == null) return null;
		return DefaultTelapiConfiguration.queryDateFormat.format(date);
	}

	//ACCOUNT
	
	public Account getAccount(String sid) throws TelapiException {
		ClientResponse<Account> acc = accountsProxy.getAccount(sid);
		return returnThrows(acc);
	}
	
	public Account getAccount() throws TelapiException {
		return getAccount(conf.getSid());
	}
	
	public AccountsList getAccounts() throws TelapiException {
		ClientResponse<AccountsList> accounts = accountsProxy.getAccounts();
		return returnThrows(accounts);
	}
	
	
	//SMSMESSAGE
	
	public SmsMessage getSmsMessage(String sid, String smsMessageSid) throws TelapiException {
		ClientResponse<SmsMessage> sms = smsProxy.getSmsMessage(sid, smsMessageSid);
		return returnThrows(sms);
	}
	
	public SmsMessage getSmsMessage(String smsMessageSid) throws TelapiException {
		return getSmsMessage(conf.getSid(), smsMessageSid);
	}
	
	public SmsMessageList getSmsMessageList(String sid, String to, String from,
			Date dateSentGte, Date dateSentLt, Long page, Long pageSize) throws TelapiException {
		
		ClientResponse<SmsMessageList> smsList = smsProxy.getSmsMessageList(
				sid, to, from, getDateString(dateSentGte), getDateString(dateSentLt), page, pageSize);
		return returnThrows(smsList);
	}

	public SmsMessageList getSmsMessageList(String to, String from,
			Date dateSentGte, Date dateSentLt, Long page, Long pageSize) throws TelapiException {
		return getSmsMessageList(conf.getSid(), to, from, dateSentGte, dateSentLt, page,
				pageSize);
	}
	
	public SmsMessage sendSmsMessage(String sid, String to, String from,
			String body, String statusCallback) throws TelapiException {
		ClientResponse<SmsMessage> smsMessage = smsProxy.sendSmsMessage(sid, to, from, body, statusCallback);
		return returnThrows(smsMessage);
	}
	public SmsMessage sendSmsMessage(String to, String from,
			String body, String statusCallback) throws TelapiException {
		return sendSmsMessage(conf.getSid(), to, from, body, statusCallback);
	}

}
