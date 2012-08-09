package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonDurationParser;

public class Recording extends BaseTelapiObjectWithSid {
	@JsonProperty("call_sid")
	private String callSid;
	@JsonDeserialize(using = JsonDurationParser.class)
	private Long duration;
	@JsonProperty("recording_url")
	private String recordingUrl;
	
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public String getRecordingUrl() {
		return recordingUrl;
	}
	public void setRecordingUrl(String recordingUrl) {
		this.recordingUrl = recordingUrl;
	}
	
}