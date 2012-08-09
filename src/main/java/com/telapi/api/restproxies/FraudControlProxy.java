package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.list.FraudList;

public interface FraudControlProxy {
	
	@GET
	@Path("Accounts/{AccountSid}/Fraud.json")
	ClientResponse<FraudList> listFraudControlResources(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);

	
	@POST
	@Path("Accounts/{AccountSid}/Fraud/Authorize/{CountryCode}.json")
	ClientResponse<FraudList> authorizeDestination(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CountryCode") String countryCode,
			@QueryParam(value="MobileBreakout") Boolean mobileBreakout,
    		@QueryParam(value="LandlineBreakout") Boolean landlineBreakout,
    		@QueryParam(value="SmsEnabled") Boolean smsEnabled
			);
	
	
	
	@POST
	@Path("Accounts/{AccountSid}/Fraud/Block/{CountryCode}.json")
	ClientResponse<FraudList> blockDestination(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CountryCode") String countryCode,
			@QueryParam(value="MobileBreakout") Boolean mobileBreakout,
    		@QueryParam(value="LandlineBreakout") Boolean landlineBreakout,
    		@QueryParam(value="SmsEnabled") Boolean smsEnabled
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Fraud/Extend/{CountryCode}.json")
	ClientResponse<FraudList> extendDestinationAuth(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CountryCode") String countryCode,
			@QueryParam(value="MobileBreakout") Boolean mobileBreakout,
    		@QueryParam(value="LandlineBreakout") Boolean landlineBreakout,
    		@QueryParam(value="SmsEnabled") Boolean smsEnabled
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Fraud/Whitelist/{CountryCode}.json")
	ClientResponse<FraudList> whitelistDestination(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CountryCode") String countryCode,
			@QueryParam(value="MobileBreakout") Boolean mobileBreakout,
    		@QueryParam(value="LandlineBreakout") Boolean landlineBreakout,
    		@QueryParam(value="SmsEnabled") Boolean smsEnabled
			);
}
