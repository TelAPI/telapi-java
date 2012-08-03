package com.telapi.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.SmsDirection;
import com.telapi.api.domain.enums.SmsStatus;
import com.telapi.api.json.JsonDateParser;

public class SmsMessage {
	@JsonProperty(value="api_version")
	private String apiVersion;
	@JsonProperty(value="sid")
	private String sid;
	@JsonProperty(value="account_sid")
	private String accountSid;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_created")
	private Date dateCreated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_updated")
	private Date dateUpdated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_sent")
	private Date dateSent;
	private String to;
	private String from;
	private String body;
	private SmsStatus status;
	private SmsDirection direction;
	private BigDecimal price;
	private String uri;
	
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
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
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
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
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public SmsStatus getStatus() {
		return status;
	}
	public void setStatus(SmsStatus status) {
		this.status = status;
	}
	public SmsDirection getDirection() {
		return direction;
	}
	public void setDirection(SmsDirection direction) {
		this.direction = direction;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
}
