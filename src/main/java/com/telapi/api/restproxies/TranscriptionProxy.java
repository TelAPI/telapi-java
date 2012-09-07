package com.telapi.api.restproxies;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import org.jboss.resteasy.client.ClientResponse;

import com.telapi.api.domain.Transcription;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.TranscriptionStatus;
import com.telapi.api.domain.enums.TranscriptionType;
import com.telapi.api.domain.list.TranscriptionList;

public interface TranscriptionProxy {

	@GET
	@Path("Accounts/{AccountSid}/Transcriptions/{TranscriptionSid}.json")
	@Produces("application/json")
	ClientResponse<Transcription> viewTranscription(
			@PathParam("AccountSid") String accountSid,
			@PathParam("TranscriptionSid") String transcriptionSid
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Transcriptions/{TranscriptionSid}.txt")
	@Produces("text/plain")
	ClientResponse<String> viewTranscriptionText(
			@PathParam("AccountSid") String accountSid,
			@PathParam("TranscriptionSid") String transcriptionSid
			);
	
	@GET
	@Path("Accounts/{AccountSid}/Transcriptions.json")
	@Produces("application/json")
	ClientResponse<TranscriptionList> listTranscriptions(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize,
    		@QueryParam(value="Status") TranscriptionStatus status
			);
	
	@GET
	@Path("Accounts/{AccountSid}/{RecordingSid}/Transcriptions.json")
	@Produces("application/json")
	ClientResponse<TranscriptionList> listRecordingTranscriptions(
			@PathParam("AccountSid") String accountSid,
			@PathParam("RecordingSid") String recordingSid,
			@QueryParam(value="Page") Long page,
    		@QueryParam(value="PageSize") Long pageSize,
    		@QueryParam(value="Status") TranscriptionStatus status
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Recordings/{RecordingSid}/Transcriptions.json")
	@Produces("application/json")
	ClientResponse<Transcription> transcribeRecording(
			@PathParam("AccountSid") String accountSid,
			@PathParam("RecordingSid") String recordingSid,
			@QueryParam(value="TranscribeCallback") String transcribeCallback,
    		@QueryParam(value="CallbackMehtod") HttpMethod callbackMethod,
    		@QueryParam(value="Quality") TranscriptionType quality
			);
	
	@POST
	@Path("Accounts/{AccountSid}/Transcriptions.json")
	@Produces("application/json")
	ClientResponse<Transcription> transcribeAudioUrl(
			@PathParam("AccountSid") String accountSid,
			@QueryParam(value="AudioUrl") String audioUrl,
			@QueryParam(value="TranscribeCallback") String transcribeCallback,
    		@QueryParam(value="CallbackMehtod") HttpMethod callbackMethod,
    		@QueryParam(value="Quality") TranscriptionType quality
			);
	
}
