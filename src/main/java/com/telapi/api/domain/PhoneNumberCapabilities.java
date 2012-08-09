package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;

public class PhoneNumberCapabilities {
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("voice")
	private Boolean voice;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("sms")
	private Boolean sms;
	
	public Boolean getVoice() {
		return voice;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setVoice(Boolean voice) {
		this.voice = voice;
	}
	public Boolean getSms() {
		return sms;
	}
	@JsonDeserialize(using = JsonBooleanParser.class)
	public void setSms(Boolean sms) {
		this.sms = sms;
	}
	
}
