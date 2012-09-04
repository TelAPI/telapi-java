package com.telapi.api.restproxies;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.IncomingPhoneNumber;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.list.IncomingPhoneNumberList;

public interface IncomingPhoneNumberProxy {

	@GET
    @Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
    @Produces("application/json")
    ClientResponse<IncomingPhoneNumber> viewIncomingPhoneNumber(
    		@PathParam("AccountSid") String accountSid, 
    		@PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid
    		);
	
	@GET
	@Path("Accounts/{AccountSid}/IncomingPhoneNumbers.json")
	@Produces("application/json")
	ClientResponse<IncomingPhoneNumberList> listIncomingPhoneNumbers(
			@PathParam("AccountSid") String accountSid, 
			@QueryParam("PhoneNumber") String phoneNumber,
    		@QueryParam("FriendlyName") String friendlyName,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@POST
	@Path("Accounts/{AccountSid}/IncomingPhoneNumbers.json")
	@Produces("application/json")
	ClientResponse<IncomingPhoneNumber> addIncomingPhoneNumber(
			@PathParam("AccountSid") String accountSid, 
			@QueryParam("PhoneNumber") String phoneNumber,
			@QueryParam("AreaCode") String areaCode
			);
	
	@DELETE
	@Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
	@Produces("application/json")
	ClientResponse<IncomingPhoneNumber> deleteIncomingPhoneNumber(
			@PathParam("AccountSid") String accountSid,
			@PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid
			);
	
	@POST
	@Path("Accounts/{AccountSid}/IncomingPhoneNumbers/{IncomingPhoneNumberSid}.json")
	@Produces("application/json")
	ClientResponse<IncomingPhoneNumber> updateIncomingPhoneNumber(
			@PathParam("AccountSid") String accountSid,
			@PathParam("IncomingPhoneNumberSid") String incomingPhoneNumberSid,
			
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
			@QueryParam("HangupCallback") String hangupCallback,
			@QueryParam("HangupCallbackMethod") HttpMethod hangupCallbackMethod,
			@QueryParam("HeartbeatUrl") String heartbeatUrl,
			@QueryParam("HeartbeatMethod") HttpMethod heartbeatMethod
			);
	
	
	

}
