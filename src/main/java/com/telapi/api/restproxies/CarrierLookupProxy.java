package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.CarrierLookup;
import com.telapi.api.domain.CnamDip;

public interface CarrierLookupProxy {

	@GET
    @Path("Accounts/{AccountSid}/Carrier.json")
    @Produces("application/json")
    ClientResponse<CarrierLookup> carrierLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") String phoneNumber
    		);
	
	@GET
    @Path("Accounts/{AccountSid}/CNAM.json")
    @Produces("application/json")
    ClientResponse<CnamDip> cnamLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") String phoneNumber
    		);

}
