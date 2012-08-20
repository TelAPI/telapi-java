package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;
import com.telapi.api.json.JsonDateParser;

public class Destination {
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("country_prefix")
	private String countryPrefix;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("mobile_breakout")
	private Boolean mobileBreakout;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("landline_breakout")
	private Boolean landlineBreakout;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("sms_enabled")
	private Boolean smsEnabled;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty("date_created")
	private Date dateCreated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty("date_updated")
	private Date dateUpdated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty("expiration_date")
	private Date expirationDate;
	
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("is_lock")
	private Boolean isLock;
	
	
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getCountryPrefix() {
		return countryPrefix;
	}
	public void setCountryPrefix(String countryPrefix) {
		this.countryPrefix = countryPrefix;
	}
	public Boolean getMobileBreakout() {
		return mobileBreakout;
	}
	public void setMobileBreakout(Boolean mobileBreakout) {
		this.mobileBreakout = mobileBreakout;
	}
	public Boolean getLandlineBreakout() {
		return landlineBreakout;
	}
	public void setLandlineBreakout(Boolean landlineBreakout) {
		this.landlineBreakout = landlineBreakout;
	}
	public Boolean getSmsEnabled() {
		return smsEnabled;
	}
	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
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
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	public Boolean getIsLock() {
		return isLock;
	}
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}
	
	
	
}
