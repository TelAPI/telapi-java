package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.list.AvailablePhoneNumberList;

public interface AvailablePhoneNumberProxy {

	@GET
	@Path("Accounts/{AccountSid}/AvailablePhoneNumbers/{IsoCountryCode}/Local.json")
	@Produces("application/json")
	ClientResponse<AvailablePhoneNumberList> listAvailablePhoneNumbers(
			@PathParam("AccountSid") String accountSid,
			@PathParam("IsoCountryCode") String isoCountryCode,
			@QueryParam("AreaCode") String areaCode,
			@QueryParam("Contains") String contains,
			@QueryParam("InRegion") String inRegion,
			@QueryParam("InPostalCode") String inPostalCode, 
			@QueryParam("Page") Long page, 
			@QueryParam("PageSize") Long pageSize
			);
}
