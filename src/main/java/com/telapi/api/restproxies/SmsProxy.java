package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.SmsMessage;
import com.telapi.api.domain.list.SmsMessageList;

public interface SmsProxy {
	    @GET
	    @Path("Accounts/{AccountSid}/SMS/Messages/{SMSMessageSid}.json")
	    @Produces("application/json")
	    ClientResponse<SmsMessage> getSmsMessage(@PathParam("AccountSid") String accountSid, @PathParam("SMSMessageSid") String smsMessageSid);
	    
	    @GET
	    @Path("Accounts/{AccountSid}/SMS/Messages.json")
	    @Produces("application/json")
	    ClientResponse<SmsMessageList> getSmsMessageList(
	    		@PathParam("AccountSid") String accountSid,
	    		@QueryParam(value="To") String to,
	    		@QueryParam(value="From") String from,
	    		@QueryParam(value="DateSent>") String dateSentGte,
	    		@QueryParam(value="DateSent<") String dateSentLt,
	    		@QueryParam(value="Page") Long page,
	    		@QueryParam(value="PageSize") Long pageSize
	    		);
	    
	    @POST
	    @Path("Accounts/{AccountSid}/SMS/Messages.json")
	    @Produces("application/json")
	    ClientResponse<SmsMessage> sendSmsMessage(
	    		@PathParam("AccountSid") String accountSid,
	    		@QueryParam(value="To") String to,
	    		@QueryParam(value="From") String from,
	    		@QueryParam(value="Body") String body,
	    		@QueryParam(value="StatusCallback") String statusCallback
	    		);
	    
}

