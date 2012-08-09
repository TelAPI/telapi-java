package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

public class Application extends BaseTelapiObjectWithMethods{
	@JsonProperty("friendly_name")
	private String friendlyName;
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


