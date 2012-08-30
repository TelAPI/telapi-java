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
	@JsonProperty(value="p_asserted_identity")
	private String pAssertedIdentity;
	@JsonProperty(value="sip_privacy")
	private String sipPrivacy;	
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty(value="privacy_hide_number")
	private Boolean privacyHideNumber;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty(value="caller_id_blocked")
	private Boolean callerIdBlocked;
	@JsonProperty("caller_name")
	private String callerName;
	@JsonProperty(value="subresource_uris")
	private CallSubresourceUris subresourceUris;
	
	public String getParentCallSid() {
		return parentCallSid;
	}
	public void setParentCallSid(String parentCallSid) {
		this.parentCallSid = parentCallSid;
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
	public String getPhoneNumberSid() {
		return phoneNumberSid;
	}
	public void setPhoneNumberSid(String phoneNumberSid) {
		this.phoneNumberSid = phoneNumberSid;
	}
	public CallStatus getStatus() {
		return status;
	}
	public void setStatus(CallStatus status) {
		this.status = status;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public Long getDuration() {
		return duration;
	}
	@JsonDeserialize(using = JsonDurationParser.class)
	public void setDuration(Long duration) {
		this.duration = duration;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public SmsDirection getDirection() {
		return direction;
	}
	public void setDirection(SmsDirection direction) {
		this.direction = direction;
	}
	public AnsweredBy getAnsweredBy() {
		return answeredBy;
	}
	public void setAnsweredBy(AnsweredBy answeredBy) {
		this.answeredBy = answeredBy;
	}
	public String getForwardedFrom() {
		return forwardedFrom;
	}
	public void setForwardedFrom(String forwardedFrom) {
		this.forwardedFrom = forwardedFrom;
	}
	public String getpAssertedIdentity() {
		return pAssertedIdentity;
	}
	public void setpAssertedIdentity(String pAssertedIdentity) {
		this.pAssertedIdentity = pAssertedIdentity;
	}
	public String getSipPrivacy() {
		return sipPrivacy;
	}
	public void setSipPrivacy(String sipPrivacy) {
		this.sipPrivacy = sipPrivacy;
	}
	public Boolean getPrivacyHideNumber() {
		return privacyHideNumber;
	}
	public void setPrivacyHideNumber(Boolean privacyHideNumber) {
		this.privacyHideNumber = privacyHideNumber;
	}
	public Boolean getCallerIdBlocked() {
		return callerIdBlocked;
	}
	public void setCallerIdBlocked(Boolean callerIdBlocked) {
		this.callerIdBlocked = callerIdBlocked;
	}
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