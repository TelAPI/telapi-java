package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.enums.HttpMethod;

public class BaseTelapiObjectWithMethods extends BaseTelapiObjectWithSid {
	
	@JsonProperty("voice_url")
	private String voiceUrl;
	@JsonProperty("voice_method")
	private HttpMethod voiceMethod;
	@JsonProperty("voice_fallback_url")
	private String voiceFallbackUrl;
	@JsonProperty("voice_fallback_method")
	private HttpMethod voiceFallbackMethod;
	@JsonProperty("heartbeat_url")
	private String heartbeatUrl;
	@JsonProperty("heartbeat_method")
	private HttpMethod heartbeatMethod;
	@JsonProperty("status_callback")
	private String statusCallback;
	@JsonProperty("status_callback_method")
	private HttpMethod statusCallbackMethod;
	@JsonProperty("sms_url")
	private String smsUrl;
	@JsonProperty("sms_method")
	private HttpMethod smsMethod;
	@JsonProperty("sms_fallback_url")
	private String smsFallbackUrl;
	@JsonProperty("sms_fallback_method")
	private HttpMethod smsFallbackMethod;
	@JsonProperty("sms_status_callback")
	private String smsStatusCallbackUrl;
	@JsonProperty("sms_status_callback_method")
	private HttpMethod smsStatusCallbackMethod;
	
	@JsonProperty("hangup_callback")
	private String hangupCallback;
	@JsonProperty("hangup_callback_method")
	private HttpMethod hangupCallbackMethod;
	
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
	public String getSmsStatusCallbackUrl() {
		return smsStatusCallbackUrl;
	}
	public void setSmsStatusCallbackUrl(String smsStatusCallbackUrl) {
		this.smsStatusCallbackUrl = smsStatusCallbackUrl;
	}
	public HttpMethod getSmsStatusCallbackMethod() {
		return smsStatusCallbackMethod;
	}
	public void setSmsStatusCallbackMethod(HttpMethod smsStatusCallbackMethod) {
		this.smsStatusCallbackMethod = smsStatusCallbackMethod;
	}
	public String getHangupCallback() {
		return hangupCallback;
	}
	public void setHangupCallback(String hangupCallback) {
		this.hangupCallback = hangupCallback;
	}
	public HttpMethod getHangupCallbackMethod() {
		return hangupCallbackMethod;
	}
	public void setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
		this.hangupCallbackMethod = hangupCallbackMethod;
	}
	
	
}
