package com.telapi.api.requests;

import com.telapi.api.domain.enums.HttpMethod;

public class CallRequest {
	
	private String accountSid = null; 
	private String to = null; 
	private String from = null;
	private String url = null;
	private HttpMethod method = null;
	private String fallbackUrl = null;
	private HttpMethod fallbackMethod = null;
	private String statusCallback = null;
	private HttpMethod StatusCallbackMethod = null;
	private String heartbeatUrl = null;
	private HttpMethod heartbeatMethod = null;
	private String forwardedFrom = null;
	private String sendDigits = null;
	private Long timeout = null;
	private Boolean hideCallerId = null;
	private Boolean record = null;
	private String recordCallback = null;
	private HttpMethod recordCallbackMethod = null;
	private Boolean transcribe = null;
	private String transcribeCallback = null;
	private HttpMethod transcribeCallbackMethod = null;
	
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getForwardedFrom() {
		return forwardedFrom;
	}
	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}
	public HttpMethod getMethod() {
		return method;
	}
	public void setMethod(HttpMethod method) {
		this.method = method;
	}
	public String getFallbackUrl() {
		return fallbackUrl;
	}
	public void setFallbackUrl(String fallbackUrl) {
		this.fallbackUrl = fallbackUrl;
	}
	public HttpMethod getFallbackMethod() {
		return fallbackMethod;
	}
	public void setFallbackMethod(HttpMethod fallbackMethod) {
		this.fallbackMethod = fallbackMethod;
	}
	public String getStatusCallback() {
		return statusCallback;
	}
	public void setStatusCallback(String statusCallback) {
		this.statusCallback = statusCallback;
	}
	public HttpMethod getStatusCallbackMethod() {
		return StatusCallbackMethod;
	}
	public void setStatusCallbackMethod(HttpMethod statusCallbackMethod) {
		StatusCallbackMethod = statusCallbackMethod;
	}
	public String getSendDigits() {
		return sendDigits;
	}
	public void setSendDigits(String sendDigits) {
		this.sendDigits = sendDigits;
	}
	public Long getTimeout() {
		return timeout;
	}
	public void setTimeout(Long timeout) {
		this.timeout = timeout;
	}
	public Boolean getHideCallerId() {
		return hideCallerId;
	}
	public void setHideCallerId(Boolean hideCallerId) {
		this.hideCallerId = hideCallerId;
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
	public Boolean getRecord() {
		return record;
	}
	public void setRecord(Boolean record) {
		this.record = record;
	}
	public String getRecordCallback() {
		return recordCallback;
	}
	public void setRecordCallback(String recordCallback) {
		this.recordCallback = recordCallback;
	}
	public HttpMethod getRecordCallbackMethod() {
		return recordCallbackMethod;
	}
	public void setRecordCallbackMethod(HttpMethod recordCallbackMethod) {
		this.recordCallbackMethod = recordCallbackMethod;
	}
	public Boolean getTranscribe() {
		return transcribe;
	}
	public void setTranscribe(Boolean transcribe) {
		this.transcribe = transcribe;
	}
	public String getTranscribeCallback() {
		return transcribeCallback;
	}
	public void setTranscribeCallback(String transcribeCallback) {
		this.transcribeCallback = transcribeCallback;
	}
	public HttpMethod getTranscribeCallbackMethod() {
		return transcribeCallbackMethod;
	}
	public void setTranscribeCallbackMethod(HttpMethod transcribeCallbackMethod) {
		this.transcribeCallbackMethod = transcribeCallbackMethod;
	}
	

}
