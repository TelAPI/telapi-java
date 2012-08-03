package com.telapi.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonDateParser;


public class Account {

	private String sid;
	
	@JsonProperty(value="friendly_name")
	private String friendlyName;

	private String status;
	
	@JsonProperty(value="account_balance")
	private BigDecimal accountBalance;
	
	@JsonProperty(value="date_created")
	@JsonDeserialize(using = JsonDateParser.class)
	private Date dateCreated;
	
	@JsonProperty(value="date_updated")
	@JsonDeserialize(using = JsonDateParser.class)
	private Date dateUpdated;
	
	private String uri;
	
	private String maxOutboundLimit;
	
	private String type;
	
	@JsonProperty(value="timezone")
	private String timeZone;
	
	@JsonProperty(value="subresource_uris")
	private SubresourceUris subresourceUris;

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
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

	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public String getMaxOutboundLimit() {
		return maxOutboundLimit;
	}

	public void setMaxOutboundLimit(String maxOutboundLimit) {
		this.maxOutboundLimit = maxOutboundLimit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	public SubresourceUris getSubresourceUris() {
		return subresourceUris;
	}

	public void setSubresourceUris(SubresourceUris subresourceUris) {
		this.subresourceUris = subresourceUris;
	}

	
}
