package com.telapi.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonDateParser;

/**
 * An account resource provides information about a single TelAPI account.
 *
 */
public class Account {

	private String sid;

	@JsonProperty(value = "friendly_name")
	private String friendlyName;

	private String status;

	@JsonProperty(value = "account_balance")
	private BigDecimal accountBalance;

	@JsonProperty(value = "date_created")
	@JsonDeserialize(using = JsonDateParser.class)
	private Date dateCreated;

	@JsonProperty(value = "date_updated")
	@JsonDeserialize(using = JsonDateParser.class)
	private Date dateUpdated;

	private String uri;

	private String maxOutboundLimit;

	private String type;

	@JsonProperty(value = "timezone")
	private String timeZone;

	@JsonProperty(value = "subresource_uris")
	private SubresourceUris subresourceUris;

	/**
	 * 
	 * @return An alphanumeric string identifying the account.
	 */
	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	/**
	 * 
	 * @return This is an alias that can be created for TelAPI accounts. By
	 *         default, it is the email used to create the account but a custom
	 *         name can be used as long as it is shorter than 64 characters.
	 */
	public String getFriendlyName() {
		return friendlyName;
	}

	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}

	/**
	 * 
	 * @return This is the status of the TelAPI account being requested. The
	 *         state of the status can be either active, suspended, or closed.
	 */
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * 
	 * @return The current balance of an account.
	 */
	public BigDecimal getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(BigDecimal accountBalance) {
		this.accountBalance = accountBalance;
	}

	/**
	 * 
	 * @return Date of account creation. Dates are returned in UTC format.
	 */
	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	/**
	 * 
	 * @return Date of most recent account update. Dates are returned in UTC
	 *         format.
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}

	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}

	/**
	 * 
	 * @return The path appended to the base TelAPI URL, https://api.telapi.com,
	 *         where the resource is located.
	 */
	public String getUri() {
		return uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	/**
	 * 
	 * @return
	 */
	public String getMaxOutboundLimit() {
		return maxOutboundLimit;
	}

	public void setMaxOutboundLimit(String maxOutboundLimit) {
		this.maxOutboundLimit = maxOutboundLimit;
	}

	/**
	 * 
	 * @return The type of account being requested. If the account is not yet
	 *         funded Type is Trial. Otherwise, Type for upgraded accounts is
	 *         Full.
	 */
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 * 
	 * @return The name of an accounts timezone.
	 */
	public String getTimeZone() {
		return timeZone;
	}

	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}

	/**
	 * 
	 * @return List of an accounts various subresources and their URI path.
	 *         Examples of subresources are things like calls that occurred
	 *         through the account, sms messages, purchased phone numbers, etc.
	 */
	public SubresourceUris getSubresourceUris() {
		return subresourceUris;
	}

	public void setSubresourceUris(SubresourceUris subresourceUris) {
		this.subresourceUris = subresourceUris;
	}

}
