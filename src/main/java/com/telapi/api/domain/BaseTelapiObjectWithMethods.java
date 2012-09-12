package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.json.JsonBooleanParser;

public class BaseTelapiObjectWithMethods extends BaseTelapiObject {
	
	@JsonProperty("voice_url")
	private String voiceUrl;
	@JsonProperty("voice_method")
	private HttpMethod voiceMethod;
	@JsonProperty("voice_fallback_url")
	private String voiceFallbackUrl;
	@JsonProperty("voice_fallback_method")
	private HttpMethod voiceFallbackMethod;
	@JsonProperty("voice_caller_id_lookup")
	@JsonDeserialize(using=JsonBooleanParser.class)
	private Boolean voiceCallerIdLookup;
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
	
	/**
	 * @return The URL returning InboundXML incoming phone numbers should execute when receiving an sms.
	 */
	public String getSmsUrl() {
		return smsUrl;
	}
	public void setSmsUrl(String smsUrl) {
		this.smsUrl = smsUrl;
	}
	/**
	 * @return The HTTP method used when making requests to the SmsUrl. Either GET or POST.
	 */
	public HttpMethod getSmsMethod() {
		return smsMethod;
	}
	public void setSmsMethod(HttpMethod smsMethod) {
		this.smsMethod = smsMethod;
	}
	/**
	 * @return The URL returning InboundXML incoming calls should execute when connected.
	 */
	public String getVoiceUrl() {
		return voiceUrl;
	}
	public void setVoiceUrl(String voiceUrl) {
		this.voiceUrl = voiceUrl;
	}
	/**
	 * @return Specifies the HTTP method (GET or POST) used to request the VoiceUrl once incoming call connects.
	 */
	public HttpMethod getVoiceMethod() {
		return voiceMethod;
	}
	public void setVoiceMethod(HttpMethod voiceMethod) {
		this.voiceMethod = voiceMethod;
	}
	/**
	 * @return URL used if any errors occur during execution of InboundXML on a call or at initial request of the VoiceUrl.
	 */
	public String getVoiceFallbackUrl() {
		return voiceFallbackUrl;
	}
	public void setVoiceFallbackUrl(String voiceFallbackUrl) {
		this.voiceFallbackUrl = voiceFallbackUrl;
	}
	/**
	 * @return Specifies the HTTP method (GET or POST) used to request the VoiceFallBackUrl if it is needed.
	 */
	public HttpMethod getVoiceFallbackMethod() {
		return voiceFallbackMethod;
	}
	public void setVoiceFallbackMethod(HttpMethod voiceFallbackMethod) {
		this.voiceFallbackMethod = voiceFallbackMethod;
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
	/**
	 * @return URL that can be used to monitor the phone number.
	 */
	public String getHeartbeatUrl() {
		return heartbeatUrl;
	}
	public void setHeartbeatUrl(String heartbeatUrl) {
		this.heartbeatUrl = heartbeatUrl;
	}
	/**
	 * @return The HTTP method TelApi will use when requesting the HeartbeatURL. Either GET or POST.
	 */
	public HttpMethod getHeartbeatMethod() {
		return heartbeatMethod;
	}
	public void setHeartbeatMethod(HttpMethod heartbeatMethod) {
		this.heartbeatMethod = heartbeatMethod;
	}
	/**
	 * @return
	 */
	public String getStatusCallback() {
		return statusCallback;
	}
	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}
	/**
	 * @return
	 */
	public HttpMethod getStatusCallbackMethod() {
		return statusCallbackMethod;
	}
	public void setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
		this.statusCallbackMethod = statusCallbackMethod;
	}
	/**
	 * @return URL used if any errors occur during execution of InboundXML from an sms or at initial request of the SmsUrl.
	 */
	public String getSmsFallbackUrl() {
		return smsFallbackUrl;
	}
	public void setSmsFallbackUrl(String smsFallbackUrl) {
		this.smsFallbackUrl = smsFallbackUrl;
	}
	/**
	 * @return Specifies the HTTP method (GET or POST) used to request the SmsFallbackUrl.
	 */
	public HttpMethod getSmsFallbackMethod() {
		return smsFallbackMethod;
	}
	public void setSmsFallbackMethod(HttpMethod smsFallbackMethod) {
		this.smsFallbackMethod = smsFallbackMethod;
	}
	/**
	 * @return 
	 */
	public String getSmsStatusCallbackUrl() {
		return smsStatusCallbackUrl;
	}
	public void setSmsStatusCallbackUrl(String smsStatusCallbackUrl) {
		this.smsStatusCallbackUrl = smsStatusCallbackUrl;
	}
	/**
	 * @return
	 */
	public HttpMethod getSmsStatusCallbackMethod() {
		return smsStatusCallbackMethod;
	}
	public void setSmsStatusCallbackMethod(HttpMethod smsStatusCallbackMethod) {
		this.smsStatusCallbackMethod = smsStatusCallbackMethod;
	}
	/**
	 * @return URL that can be requested to receive notification when and how incoming call has ended.
	 */
	public String getHangupCallback() {
		return hangupCallback;
	}
	public void setHangupCallback(String hangupCallback) {
		this.hangupCallback = hangupCallback;
	}
	/**
	 * @return Specifies the HTTP method (GET or POST) used to request the HangupCallback URL.
	 */
	public HttpMethod getHangupCallbackMethod() {
		return hangupCallbackMethod;
	}
	public void setHangupCallbackMethod(HttpMethod hangupCallbackMethod) {
		this.hangupCallbackMethod = hangupCallbackMethod;
	}
	
	
}
