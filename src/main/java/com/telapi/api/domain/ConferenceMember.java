package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;
import com.telapi.api.json.JsonDurationParser;

public class ConferenceMember {

	private String id;
	@JsonDeserialize(using = JsonBooleanParser.class)
	private Boolean muted;
	@JsonDeserialize(using = JsonBooleanParser.class)
	private Boolean deaf;
	@JsonProperty("caller_name")
	private String callerName;
	@JsonProperty("caller_number")
	private String callerNumber;
	@JsonDeserialize(using = JsonDurationParser.class)
	private Long duration;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Boolean getMuted() {
		return muted;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setMuted(Boolean muted) {
		this.muted = muted;
	}
	public Boolean getDeaf() {
		return deaf;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setDeaf(Boolean deaf) {
		this.deaf = deaf;
	}
	public String getCallerName() {
		return callerName;
	}
	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}
	public String getCallerNumber() {
		return callerNumber;
	}
	public void setCallerNumber(String callerNumber) {
		this.callerNumber = callerNumber;
	}
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	
}