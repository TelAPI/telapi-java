package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.PhoneNumberType;
import com.telapi.api.json.JsonBooleanParser;

/**
 * TelAPI phone numbers associated with an account are represented with the IncomingPhoneNumber resource.
 */
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
	
	
	/**
	 * @return Domestic format version of the TelAPI phone number. (e.g. 1234567890 to (123)-456-7890)
	 */
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	/**
	 * @return The E.164 format number of each incoming number.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return The type of TelAPI number. (local, international, etc.)
	 */
	public PhoneNumberType getType() {
		return type;
	}
	public void setType(PhoneNumberType type) {
		this.type = type;
	}
	/**
	 * @return
	 */
	public String getVoiceApplicationSid() {
		return voiceApplicationSid;
	}
	public void setVoiceApplicationSid(String voiceApplicationSid) {
		this.voiceApplicationSid = voiceApplicationSid;
	}
	/**
	 * @return Look up the callers caller-ID name from the CNAM database (additional charges apply). Either true or false.
	 */
	public Boolean getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}
	public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}
	/**
	 * @return 
	 */
	public String getSmsApplicationSid() {
		return smsApplicationSid;
	}
	public void setSmsApplicationSid(String smsApplicationSid) {
		this.smsApplicationSid = smsApplicationSid;
	}
	/**
	 * @return The features available with this incoming phone number. The voice and sms properties are either True or False depending on what the number is capable of.
	 */
	public PhoneNumberCapabilities getCapabilities() {
		return capabilities;
	}
	public void setCapabilities(PhoneNumberCapabilities capabilities) {
		this.capabilities = capabilities;
	}

}

