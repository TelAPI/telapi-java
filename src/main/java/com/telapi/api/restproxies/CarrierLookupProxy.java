package com.telapi.api.restproxies;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.list.CarrierLookupList;
import com.telapi.api.domain.list.CnamDipList;

public interface CarrierLookupProxy {

	@GET
    @Path("Accounts/{AccountSid}/Carrier.json")
    @Produces("application/json")
    ClientResponse<CarrierLookupList> carrierLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") String phoneNumber
    		);
	
	@GET
    @Path("Accounts/{AccountSid}/Carrier.json")
    @Produces("application/json")
    ClientResponse<CarrierLookupList> carrierLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") List<String> phoneNumber
    		);
	
	@GET
    @Path("Accounts/{AccountSid}/CNAM.json")
    @Produces("application/json")
    ClientResponse<CnamDipList> cnamLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") String phoneNumber
    		);
	
	@GET
    @Path("Accounts/{AccountSid}/CNAM.json")
    @Produces("application/json")
    ClientResponse<CnamDipList> cnamLookup(
    		@PathParam("AccountSid") String accountSid, 
    		@QueryParam("PhoneNumber") List<String> phoneNumbers
    		);

}
