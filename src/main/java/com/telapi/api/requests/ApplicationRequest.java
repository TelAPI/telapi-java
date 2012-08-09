package com.telapi.api.requests;

import com.telapi.api.domain.enums.HttpMethod;

public class ApplicationRequest {
	private String sid = null;
	private String accountSid = null;
	private String friendlyName = null;
	private String voiceUrl = null;
	private HttpMethod voiceMethod = null;
	private String voiceFallbackUrl = null;
	private HttpMethod voiceFallbackMethod = null;
	private Boolean voiceCallerIdLookup = null;
	private String smsUrl = null;
	private HttpMethod smsMethod = null;
	private String smsFallbackUrl = null;
	private HttpMethod smsFallbackMethod = null;
	private String heartbeatUrl = null;
	private HttpMethod heartbeatMethod = null;
	private String statusCallback = null;
	private HttpMethod statusCallbackMethod = null;
	
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
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
	public String getHeartbeatUrl() {
		return heartbeatUrl;
	}
	public void setHeartbeatUrl(String heartbeatUrl) {
		this.heartbeatUrl = heartbeatUrl;
	}
	public HttpMethod getHeartbeatMethod() {
		return heartbeatMethod;
	}
	public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
		this.heartbeatMethod = heartbeatMethod;
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
