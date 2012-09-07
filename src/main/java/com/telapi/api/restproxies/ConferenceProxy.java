package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Conference;
import com.telapi.api.domain.list.ConferenceList;

public interface ConferenceProxy {

	@GET
    @Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}.json")
    @Produces("application/json")
    ClientResponse<Conference> viewConference(
    		@PathParam("AccountSid") String accountSid, 
    		@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId,
    		@QueryParam("Muted") Boolean muted,
    		@QueryParam("Deafed") Boolean deafed
    		);
	
	@GET
	@Path("Accounts/{AccountSid}/Conferences.json")
	@Produces("application/json")
	ClientResponse<ConferenceList> listConferences(
			@PathParam("AccountSid") String accountSid,
    		@QueryParam("MemberID") String memberId,
    		@QueryParam("Muted") Boolean muted,
    		@QueryParam("Deafed") Boolean deafed,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Mute.json")
	@Produces("application/json")
	ClientResponse<Conference> muteMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/UnMute.json")
	@Produces("application/json")
	ClientResponse<Conference> unMuteMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
	
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Deaf.json")
	@Produces("application/json")
	ClientResponse<Conference> deafMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/UnDeaf.json")
	@Produces("application/json")
	ClientResponse<Conference> unDeafMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Hangup.json")
	@Produces("application/json")
	ClientResponse<Conference> hangupMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Kick.json")
	@Produces("application/json")
	ClientResponse<Conference> kickMember(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId
	);
	
//	@POST
//	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Say.json")
//	@Produces("application/json")
//	ClientResponse<StatusResponse> speakText(
//			@PathParam("AccountSid") String accountSid,
//			@PathParam("ConferenceSid") String conferenceSid,
//    		@QueryParam("MemberID") String memberId,
//    		@QueryParam("Text") String text
//	);
	
	@POST
	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/Play.json")
	@Produces("application/json")
	ClientResponse<Conference> playAudio(
			@PathParam("AccountSid") String accountSid,
			@PathParam("ConferenceSid") String conferenceSid,
    		@QueryParam("MemberID") String memberId,
    		@QueryParam("Url") String url
	);
	
	
//	@POST
//	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/RecordStart.json")
//	@Produces("application/json")
//	ClientResponse<StatusResponse> startRecording(
//			@PathParam("AccountSid") String accountSid,
//			@PathParam("ConferenceSid") String conferenceSid
//	);
//	
//	@POST
//	@Path("Accounts/{AccountSid}/Conferences/{ConferenceSid}/RecordStop.json")
//	@Produces("application/json")
//	ClientResponse<StatusResponse> stopRecording(
//			@PathParam("AccountSid") String accountSid,
//			@PathParam("ConferenceSid") String conferenceSid
//	);
	
	
	
}
