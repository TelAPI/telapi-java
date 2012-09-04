package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.enums.LogLevel;
import com.telapi.api.json.JsonDateParser;

/**
 * Notifications that TelAPI sends to users regarding their account and TelAPI
 * phone numbers activity.
 * 
 */
public class Notification extends BaseTelapiObject {
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
	
	/**
	 * @return An alphanumeric string used for identification of the call that the notification occurred during. Since notifications don't have to necessarily occur during calls, this property could be empty.
	 */
	public String getCallSid() {
		return callSid;
	}
	public void setCallSid(String callSid) {
		this.callSid = callSid;
	}
	/**
	 * @return Specifies the notification log level: INFO, WARNING or ERROR.
	 */
	public LogLevel getLog() {
		return log;
	}
	public void setLog(LogLevel log) {
		this.log = log;
	}
	/**
	 * @return Identifies the specific error type. For more information on error codes see the Error Dictionary.
	 */
	public String getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	/**
	 * @return URL leading to our error dictionary for more information on the error.
	 */
	public String getMoreInfo() {
		return moreInfo;
	}
	public void setMoreInfo(String moreInfo) {
		this.moreInfo = moreInfo;
	}
	/**
	 * @return Text of the notification message.
	 */
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	/**
	 * @return The date the TelAPI account received the actual notification. May be a bit different from DateCreated due to buffering.
	 */
	public Date getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(Date messageDate) {
		this.messageDate = messageDate;
	}
	/**
	 * @return The HTTP body returned by your server when the notification occurred.
	 */
	public String getResponseBody() {
		return responseBody;
	}
	public void setResponseBody(String responseBody) {
		this.responseBody = responseBody;
	}
	/**
	 * @return The method used to request RequestUrl when the notification was generated.
	 */
	public HttpMethod getRequestMethod() {
		return requestMethod;
	}
	public void setRequestMethod(HttpMethod requestMethod) {
		this.requestMethod = requestMethod;
	}
	/**
	 * @return The URL being requested when notification was generated.
	 */
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	/**
	 * @return The variables sent with the HTTP request that generated the notification.
	 */
	public String getRequestVariables() {
		return requestVariables;
	}
	public void setRequestVariables(String requestVariables) {
		this.requestVariables = requestVariables;
	}
	/**
	 * @return HTTP headers returned by your server when the notification occurred.
	 */
	public String getResponseHeaders() {
		return responseHeaders;
	}
	public void setResponseHeaders(String responseHeaders) {
		this.responseHeaders = responseHeaders;
	}
}

