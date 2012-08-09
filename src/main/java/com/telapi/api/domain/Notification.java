package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.LogLevel;
import com.telapi.api.json.JsonDateParser;

public class Notification extends BaseTelapiObjectWithSid {
	@JsonProperty("call_sid")
	private String callSid;
	private LogLevel log;
	@JsonProperty("error_code")
	private String errorCode;
	@JsonProperty("more_info")
	private String moreInfo;
	@JsonProperty("message_text")
	private String messageText;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty("message_date")
	private Date messageDate;
	@JsonProperty("response_body")
	private String responseBody;
	@JsonProperty("request_method")
	private HttpMethod requestMethod;
	@JsonProperty("request_url")
	private String requestUrl;
	@JsonProperty("request_variables")
	private String requestVariables;
	@JsonProperty("response_headers")
	private String responseHeaders;
	
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	public LogLevel getLog() {
		return log;
	}
	public void setLog(LogLevel log) {
		this.log = log;
	}
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	public HttpMethod getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(HttpMethod requestMethod) {
		this.requestMethod = requestMethod;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	public String getRequestVariables() {
		return requestVariables;
	}
	public void setRequestVariables(String requestVariables) {
		this.requestVariables = requestVariables;
	}
	public String getResponseHeaders() {
		return responseHeaders;
	}
	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
}

