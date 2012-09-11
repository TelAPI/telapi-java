package com.telapi.api.restproxies;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Conference;
import com.telapi.api.domain.Participant;
import com.telapi.api.domain.list.ConferenceList;

public interface ConferenceProxy {

	@GET
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}.json")
    @Produces("application/json")
    ClientResponse<Conference> viewConference(
    		@PathParam("AccountSid") String accountSid, 
    		@PathParam("ConferenceSid") String conferenceSid
    		);
	
	@GET
	@Path("Accounts/{AccountSid}/Conferences.json")
	@Produces("application/json")
	ClientResponse<ConferenceList> listConferences(
			@PathParam("AccountSid") String accountSid,
    		@QueryParam("FriendlyName") String friendlyName,
    		@QueryParam("Status") String status,
    		@QueryParam("DateCreated>") String dateCreatedGte,
    		@QueryParam("DateCreated<") String dateCreatedLt,
    		@QueryParam("DateUpdated>") String dateUpdatedGte,
    		@QueryParam("DateUpdated<") String dateUpdatedLt,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Participant> viewParticipant(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
			@PathParam("CallSid") String callSid
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants.json")
	@Produces("application/json")
	ClientResponse<List<Participant>> listParticipants(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("Deaf") Boolean deaf,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Participant> muteDeafParticipant(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
			@PathParam("CallSid") String callSid,
			@QueryParam("Muted") Boolean muted,
			@QueryParam("Deaf") Boolean deaf
	);
	

	
	@DELETE
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Participant> hangupParticipant(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
			@PathParam("CallSid") String callSid
	);
	
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Participants/{CallSid}/Play.json")
	@Produces("application/json")
	ClientResponse<Participant> playAudioToParticipant(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
			@PathParam("CallSid") String callSid,
    		@QueryParam("AudioUrl") String audioUrl
	);
	
	
	
	
}
