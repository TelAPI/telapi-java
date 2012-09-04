package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;

/**
 * TelAPI offers the ability to preset all voice and sms urls for a given
 * application name. This application can then be assigned to multiple numbers
 * so you don't have to update all of their urls manually.
 */
public class Application extends BaseTelapiObjectWithMethods{
	@JsonProperty("friendly_name")
	private String friendlyName;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("voice_caller_id_lookup")
	private Boolean voiceCallerIdLookup;

	
	/**
	 * @return String defining this resource.
	 */
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	
	/**
	 * @return Look up the callers caller ID name from a CNAM database (additional charges apply). Either true or false.
	 */
	public Boolean getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}
	public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}

	
}


