package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.PhoneNumberType;
import com.telapi.api.json.JsonBooleanParser;

public class IncomingPhoneNumber extends BaseTelapiObjectWithMethods{
	@JsonProperty("friendly_name")
	private String friendlyName;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private PhoneNumberType type;
	@JsonProperty("voice_application_sid")
	private String voiceApplicationSid;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("voice_caller_id_lookup")
	private Boolean voiceCallerIdLookup;
	@JsonProperty("sms_application_sid")
	private String smsApplicationSid;
	private PhoneNumberCapabilities capabilities;
	
	
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public PhoneNumberType getType() {
		return type;
	}
	public void setType(PhoneNumberType type) {
		this.type = type;
	}
	public String getVoiceApplicationSid() {
		return voiceApplicationSid;
	}
	public void setVoiceApplicationSid(String voiceApplicationSid) {
		this.voiceApplicationSid = voiceApplicationSid;
	}
	public Boolean getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}
	public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}
	public String getSmsApplicationSid() {
		return smsApplicationSid;
	}
	public void setSmsApplicationSid(String smsApplicationSid) {
		this.smsApplicationSid = smsApplicationSid;
	}
	public PhoneNumberCapabilities getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(PhoneNumberCapabilities capabilities) {
		this.capabilities = capabilities;
	}

}

