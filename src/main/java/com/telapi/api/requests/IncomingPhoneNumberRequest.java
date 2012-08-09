package com.telapi.api.requests;

import com.telapi.api.domain.enums.HttpMethod;


public class IncomingPhoneNumberRequest {
	private String accountSid;
	private String incomingPhoneNumberSid;
	private String friendlyName;
	private String voiceUrl;
	private HttpMethod voiceMethod;
	private String voiceFallbackUrl;
	private HttpMethod voiceFallbackMethod;
	private Boolean voiceCallerIdLookup;
	private String smsUrl;
	private HttpMethod smsMethod;
	private String smsFallbackUrl;
	private HttpMethod smsFallbackMethod;
	private String statusCallback;
	private HttpMethod statusCallbackMethod;
	
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getIncomingPhoneNumberSid() {
		return incomingPhoneNumberSid;
	}
	public void setIncomingPhoneNumberSid(String incomingPhoneNumberSid) {
		this.incomingPhoneNumberSid = incomingPhoneNumberSid;
	}
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	public HttpMethod getVoiceMethod() {
		return voiceMethod;
	}
	public void setVoiceMethod(HttpMethod voiceMethod) {
		this.voiceMethod = voiceMethod;
	}
	public String getVoiceFallbackUrl() {
		return voiceFallbackUrl;
	}
	public void setVoiceFallbackUrl(String voiceFallbackUrl) {
		this.voiceFallbackUrl = voiceFallbackUrl;
	}
	public HttpMethod getVoiceFallbackMethod() {
		return voiceFallbackMethod;
	}
	public void setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
		this.voiceFallbackMethod = voiceFallbackMethod;
	}
	public Boolean getVoiceCallerIdLookup() {
		return voiceCallerIdLookup;
	}
	public void setVoiceCallerIdLookup(Boolean voiceCallerIdLookup) {
		this.voiceCallerIdLookup = voiceCallerIdLookup;
	}
	public String getSmsUrl() {
		return smsUrl;
	}
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}
	public HttpMethod getSmsMethod() {
		return smsMethod;
	}
	public void setSmsMethod(HttpMethod smsMethod) {
		this.smsMethod = smsMethod;
	}
	public String getSmsFallbackUrl() {
		return smsFallbackUrl;
	}
	public void setSmsFallbackUrl(String smsFallbackUrl) {
		this.smsFallbackUrl = smsFallbackUrl;
	}
	public HttpMethod getSmsFallbackMethod() {
		return smsFallbackMethod;
	}
	public void setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
		this.smsFallbackMethod = smsFallbackMethod;
	}
	public String getStatusCallback() {
		return statusCallback;
	}
	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}
	public HttpMethod getStatusCallbackMethod() {
		return statusCallbackMethod;
	}
	public void setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
		this.statusCallbackMethod = statusCallbackMethod;
	}
	
}
