package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.enums.AudioDirection;
import com.telapi.api.domain.enums.CallInterruptStatus;
import com.telapi.api.domain.enums.CallStatus;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.Legs;
import com.telapi.api.domain.list.CallList;
import com.telapi.api.domain.list.RecordingList;

public interface CallProxy {

	@GET
    @Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
    @Produces("application/json")
    ClientResponse<Call> viewCall(@PathParam("AccountSid") String accountSid, @PathParam("CallSid") String callSid);
	
	@GET
	@Path("Accounts/{AccountSid}/Calls.json")
	@Produces("application/json")
	ClientResponse<CallList> listCalls(
			@PathParam("AccountSid") String accountSid,
    		@QueryParam(value="To") String to,
    		@QueryParam(value="From") String from,
    		@QueryParam(value="Status") CallStatus status,
    		@QueryParam(value="StartTime>") String startTimeGte,
    		@QueryParam(value="StartTime<") String startTimeLt,
    		@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls.json")
	@Produces("application/json")
	ClientResponse<Call> makeCall(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value = "To") String to,
			@QueryParam(value = "From") String from,
			@QueryParam(value = "Url") String url,
			@QueryParam(value = "Method") HttpMethod method,
			@QueryParam(value = "FallbackUrl") String fallbackUrl,
			@QueryParam(value = "FallbackMethod") HttpMethod fallbackMethod,
			@QueryParam(value = "StatusCallback") String statusCallback,
			@QueryParam(value = "StatusCallbackMethod") HttpMethod StatusCallbackMethod,
			@QueryParam(value = "HeartbeatUrl") String heartbeatUrl,
			@QueryParam(value = "HeartbeatMethod") HttpMethod heartbeatMethod,
			@QueryParam(value = "ForwardedFrom") String forwardedFrom,
			@QueryParam(value = "SendDigits") String sendDigits,
			@QueryParam(value = "Timeout") Long timeout,
			@QueryParam(value = "HideCallerId") Boolean hideCallerId,
			@QueryParam(value = "Record") Boolean record,
			@QueryParam(value = "RecordCallback") String recordCallback,
			@QueryParam(value = "RecordCallbackMethod") HttpMethod recordCallbackMethod,
			@QueryParam(value = "Transcribe") Boolean transcribe,
			@QueryParam(value = "TranscribeCallback") String transcribeCallback,
			@QueryParam(value = "TranscribeCallbackMethod") HttpMethod transcribeCallbackMethod
	);
	
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Call> interruptLiveCall(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam(value = "Url") String url,
			@QueryParam(value = "Method") HttpMethod method,
			@QueryParam(value = "Status") CallInterruptStatus status
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Call> hangupCall(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam(value = "Status") CallInterruptStatus status
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}.json")
	@Produces("application/json")
	ClientResponse<Call> sendDigits(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam("PlayDtmf") String playDtfm,
			@QueryParam("PlayDtmfLeg") Legs dtmfLeg
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}/Play.json")
	@Produces("application/json")
	ClientResponse<Call> playAudio(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam("AudioUrl") String audioUrl,
			@QueryParam("Length") Long length,
			@QueryParam("Legs") Legs legs,
			@QueryParam("Loop") Boolean loop,
			@QueryParam("Mix") Boolean mix
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}/Effect.json")
	@Produces("application/json")
	ClientResponse<Call> voiceEffects(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam("AudioDirection") AudioDirection audioDirection,
			@QueryParam("Pitch") Double pitch,
			@QueryParam("PitchSemiTones") Long pitchSemiTones,
			@QueryParam("PitchOctaves") Long pitchOctaves,
			@QueryParam("Rate") Double rate
	);
	
	@POST
	@Path("Accounts/{AccountSid}/Calls/{CallSid}/Recordings.json")
	@Produces("application/json")
	ClientResponse<RecordingList> recordCall(
			@PathParam("AccountSid") String accountSid,
			@PathParam("CallSid") String callSid,
			@QueryParam("Record") Boolean record,
			@QueryParam("TimeLimit") Long timeLimit,
			@QueryParam("CallbackUrl") String callbackUrl
	);
}
