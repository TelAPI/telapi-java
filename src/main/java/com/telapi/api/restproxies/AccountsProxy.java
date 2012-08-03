package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Account;
import com.telapi.api.domain.list.AccountsList;

public interface AccountsProxy {
	    @GET
	    @Path("Accounts/{AccountSid}.json")
	    @Produces("application/json")
	    ClientResponse<Account> getAccount(@PathParam("AccountSid") String sid);
	    
	    @GET
	    @Path("Accounts.json")
	    @Produces("application/json")
	    ClientResponse<AccountsList> getAccounts();
}
