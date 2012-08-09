package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Recording;
import com.telapi.api.domain.list.RecordingList;

public interface RecordingProxy {

	@GET
    @Path("Accounts/{AccountSid}/Recordings/{RecordingSid}.json")
    @Produces("application/json")
    ClientResponse<Recording> viewRecording(
    		@PathParam("AccountSid") String accountSid, 
    		@PathParam("RecordingSid") String recordingSid);
    
    @GET
    @Path("Accounts/{AccountSid}/Recordings.json")
    @Produces("application/json")
    ClientResponse<RecordingList> listRecordings(
    		@PathParam("AccountSid") String accountSid,
    		@QueryParam(value="DateCreated>") String dateCreatedGte,
    		@QueryParam(value="DateCreated<") String dateCreatedLt,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
    		);
    
    @GET
    @Path("Accounts/{AccountSid}/Calls/{CallSid}/Recordings.json")
    @Produces("application/json")
    ClientResponse<RecordingList> listCallRecordings(
    		@PathParam("AccountSid") String accountSid,
    		@PathParam("CallSid") String callSid,
    		@QueryParam(value="DateCreated>") String dateCreatedGte,
    		@QueryParam(value="DateCreated<") String dateCreatedLt,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
    		);
}
