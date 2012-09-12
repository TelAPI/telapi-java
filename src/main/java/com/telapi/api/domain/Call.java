package com.telapi.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.AnsweredBy;
import com.telapi.api.domain.enums.CallStatus;
import com.telapi.api.domain.enums.SmsDirection;
import com.telapi.api.json.JsonBooleanParser;
import com.telapi.api.json.JsonDateParser;
import com.telapi.api.json.JsonDurationParser;

/**
 * A call resource provides information about an individual call that has
 * occurred through TelAPI. Both inbound and outbound voice communication
 * through TelAPI are categorized as calls.
 * 
 */
public class Call extends BaseTelapiObject{

	//delete these two when the time comes
	@SuppressWarnings("unused")
	@JsonProperty("date_updated>")
	private String dateUpdatedTemp;
	@SuppressWarnings("unused")
	@JsonProperty("api_version>")
	private String apiVersionTemp;
	
	@JsonProperty(value="parent_call_sid")
	private String parentCallSid;
	private String to;
	private String from;
	@JsonProperty(value="phone_number_sid")
	private String phoneNumberSid;
	private CallStatus status;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="start_time")
	private Date startTime;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="end_time")
	private Date endTime;
	@JsonDeserialize(using = JsonDurationParser.class)
	private Long duration;
	private BigDecimal price;
	private SmsDirection direction;
	@JsonProperty(value="answered_by")
	private AnsweredBy answeredBy;
	@JsonProperty(value="forwarded_from")
	private String forwardedFrom;
	@JsonProperty(value="sip_privacy")
	private String sipPrivacy;	
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty(value="privacy_hide_number")
	private Boolean privacyHideNumber;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty(value="caller_id_blocked")
	private Boolean callerIdBlocked;
	@JsonProperty(value="subresource_uris")
	private CallSubresourceUris subresourceUris;
	@JsonProperty("caller_name")
	private String callerName;
	
	/**
	 * 
	 * @return If the call was created during a different call using InboundXML, this is the sid of that initiating call.
	 */
	public String getParentCallSid() {
		return parentCallSid;
	}
	public void setParentCallSid(String parentCallSid) {
		this.parentCallSid = parentCallSid;
	}
	
	/**
	 * 
	 * @return The number that was called.
	 */
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	
	/**
	 * 
	 * @return The number that initiated the call.
	 */
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	
	/**
	 * 
	 * @return The sid of the TelAPI number calling, or being called. If no TelAPI phone number is involved in the call, this property is empty.
	 */
	public String getPhoneNumberSid() {
		return phoneNumberSid;
	}
	public void setPhoneNumberSid(String phoneNumberSid) {
		this.phoneNumberSid = phoneNumberSid;
	}
	
	/**
	 * 
	 * @return The status of the call: queued, ringing, in-progress, completed, failed, busy, no-answer.
	 */
	public CallStatus getStatus() {
		return status;
	}
	public void setStatus(CallStatus status) {
		this.status = status;
	}
	
	/**
	 * 
	 * @return The date the call started.
	 */
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	/**
	 * 
	 * @return The date the call ended.
	 */
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	
	/**
	 * 
	 * @return The length of the call in seconds.
	 */
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	
	/**
	 * 
	 * @return The cost of the call, if availible.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * 
	 * @return The direction of the call from the perspective of TelAPI. Inbound for calls to TelAPI, outbound-api for calls from the TelAPI via REST request or outbound-dial for calls from TelAPI via InboundXML.
	 */
	public SmsDirection getDirection() {
		return direction;
	}
	public void setDirection(SmsDirection direction) {
		this.direction = direction;
	}
	
	/**
	 * 
	 * @return If the initiated call has answering machine detection, this specifies whether the machine answered. Can be human or machine.
	 */
	public AnsweredBy getAnsweredBy() {
		return answeredBy;
	}
	public void setAnsweredBy(AnsweredBy answeredBy) {
		this.answeredBy = answeredBy;
	}
	
	/**
	 * 
	 * @return The number that forwared the call, if any.
	 */
	public String getForwardedFrom() {
		return forwardedFrom;
	}
	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getSipPrivacy() {
		return sipPrivacy;
	}
	public void setSipPrivacy(String sipPrivacy) {
		this.sipPrivacy = sipPrivacy;
	}
	
	/**
	 * 
	 * @return
	 */
	public Boolean getPrivacyHideNumber() {
		return privacyHideNumber;
	}
	public void setPrivacyHideNumber(Boolean privacyHideNumber) {
		this.privacyHideNumber = privacyHideNumber;
	}
	
	/**
	 * 
	 * @return Specifies whether the caller ID of the inbound phone number was blocked.
	 */
	public Boolean getCallerIdBlocked() {
		return callerIdBlocked;
	}
	public void setCallerIdBlocked(Boolean callerIdBlocked) {
		this.callerIdBlocked = callerIdBlocked;
	}
	
	/**
	 * 
	 * @return List of a calls various subresources and their URI path. Examples of call subresources are notifications, recordings, etc.
	 */
	public CallSubresourceUris getCallSubresourceUris() {
		return subresourceUris;
	}
	public void setCallSubresourceUris(CallSubresourceUris subresourceUris) {
		this.subresourceUris = subresourceUris;
	}
	public String getCallerName() {
		return callerName;
	}
	public void setCallerName(String callerName) {
		this.callerName = callerName;
	}

	
	
}