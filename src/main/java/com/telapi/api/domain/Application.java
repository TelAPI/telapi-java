package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;

public class Application extends BaseTelapiObjectWithMethods{
	@JsonProperty("friendly_name")
	private String friendlyName;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("voice_caller_id_lookup")
	private Boolean voiceCallerIdLookup;

	
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	public Boolean getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}
	public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}

	
}


