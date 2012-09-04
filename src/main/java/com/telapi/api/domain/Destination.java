package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;
import com.telapi.api.json.JsonDateParser;

/**
 * Contains Fraud Control information about a Destination.
 *
 */
public class Destination {
	@JsonProperty("country_name")
	private String countryName;
	@JsonProperty("country_code")
	private String countryCode;
	@JsonProperty("country_prefix")
	private String countryPrefix;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("mobile_enabled")
	private Boolean mobileEnabled;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("landline_enabled")
	private Boolean landlineEnabled;
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
	
	/**
	 * @return Full name of the destination being whitelisted, authorized or blocked.
	 */
	public String getCountryName() {
		return countryName;
	}
	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	/**
	 * @return Two letter country code being whitelisted, authorized or blocked.
	 */
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return Prefix of the destination being whitelisted, authorized or blocked.
	 */
	public String getCountryPrefix() {
		return countryPrefix;
	}
	public void setCountryPrefix(String countryPrefix) {
		this.countryPrefix = countryPrefix;
	}
	/**
	 * @return Mobile status for the destination. If false, all mobile call activity will be rejected or disabled.
	 */
	public Boolean getMobileEnabled() {
		return mobileEnabled;
	}
	public void setMobileEnabled(Boolean mobileEnabled) {
		this.mobileEnabled = mobileEnabled;
	}
	/**
	 * @return Landline status for the destination. If false, all landline call activity will be rejected or disabled.
	 */
	public Boolean getLandlineEnabled() {
		return landlineEnabled;
	}
	public void setLandlineEnabled(Boolean landlineEnabled) {
		this.landlineEnabled = landlineEnabled;
	}
	/**
	 * @return Status of the SMS for destination. Can be true or false. If false, SMS for same destination will be rejected.
	 */
	public Boolean getSmsEnabled() {
		return smsEnabled;
	}
	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}
	/**
	 * @return The date the fraud control resource was created.
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	/**
	 * @return The date the fraud control resource was last updated.
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	/**
	 * @return The date the fraud control resource will expire.
	 */
	public Date getExpirationDate() {
		return expirationDate;
	}
	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
	
	/**
	 * @return Specifies whether the destination has been permanently blacklisted by our system.
	 */
	public Boolean getIsLock() {
		return isLock;
	}
	public void setIsLock(Boolean isLock) {
		this.isLock = isLock;
	}
	
	
	
}
