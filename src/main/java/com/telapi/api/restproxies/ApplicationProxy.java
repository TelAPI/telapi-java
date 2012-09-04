package com.telapi.api.restproxies;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Application;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.list.ApplicationList;

public interface ApplicationProxy {

	@GET
    @Path("Accounts/{AccountSid}/Applications/{ApplicationSid}.json")
    @Produces("application/json")
    ClientResponse<Application> viewApplication(
    		@PathParam("AccountSid") String accountSid, 
    		@PathParam("ApplicationSid") String applicationSid
    		);
	
	@GET
	@Path("Accounts/{AccountSid}/Applications.json")
	@Produces("application/json")
	ClientResponse<ApplicationList> listApplications(
			@PathParam("AccountSid") String accountSid,
    		@QueryParam(value="FriendlyName") String friendlyName,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	
	
	@POST
	@Path("Accounts/{AccountSid}/Applications.json")
	@Produces("application/json")
	ClientResponse<Application> createApplication(
			@PathParam("AccountSid") String accountSid,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("VoiceUrl") String voiceUrl,
			@QueryParam("VoiceMethod") HttpMethod voiceMethod,
			@QueryParam("VoiceFallbackUrl") String voiceFallbackUrl,
			@QueryParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
			@QueryParam("VoiceCallerIdLookup") Boolean voiceCallerIdLookup,
			@QueryParam("SmsUrl") String smsUrl,
			@QueryParam("SmsMethod") HttpMethod smsMethod,
			@QueryParam("SmsFallbackUrl") String smsFallbackUrl,
			@QueryParam("SmsFallbackMethod") HttpMethod smsFallbackMethod,
			@QueryParam("HeartbeatUrl") String heartbeatUrl,
			@QueryParam("HeartbeatMethod") HttpMethod heartbeatMethod,
			@QueryParam("HangupCallback") String hangupCallback,
			@QueryParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod
	);
	
	
	@POST
	@Path("Accounts/{AccountSid}/Applications/{ApplicationSid}.json")
	@Produces("application/json")
	ClientResponse<Application> updateApplication(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ApplicationSid") String applicationSid,
			@QueryParam("FriendlyName") String friendlyName,
			@QueryParam("VoiceUrl") String voiceUrl,
			@QueryParam("VoiceMethod") HttpMethod voiceMethod,
			@QueryParam("VoiceFallbackUrl") String voiceFallbackUrl,
			@QueryParam("VoiceFallbackMethod") HttpMethod voiceFallbackMethod,
			@QueryParam("VoiceCallerIdLookup") Boolean voiceCallerIdLookup,
			@QueryParam("SmsUrl") String smsUrl,
			@QueryParam("SmsMethod") HttpMethod smsMethod,
			@QueryParam("SmsFallbackUrl") String smsFallbackUrl,
			@QueryParam("SmsFallbackMethod") HttpMethod smsFallbackMethod,
			@QueryParam("HeartbeatUrl") String heartbeatUrl,
			@QueryParam("HeartbeatMethod") HttpMethod heartbeatMethod,
			@QueryParam("HangupCallback") String hangupCallback,
			@QueryParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod
	);
	
	@DELETE
	@Path("Accounts/{AccountSid}/Applications/{ApplicationSid}.json")
	@Produces("application/json")
	ClientResponse<Application> deleteApplication(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ApplicationSid") String applicationSid
	);
	

}
