package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonDateParser;

/**
 * A base resource object containing properties present in all of the other
 * resource objects.
 * 
 */
public class BaseTelapiObject {
	
	private String sid;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_created")
	private Date dateCreated;
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_updated")
	private Date dateUpdated;
	@JsonProperty(value="account_sid")
	private String accountSid;
	@JsonProperty("api_version")
	private String apiVersion;
	private String uri;
	
	/**
	 * 
	 * @return A unique identifier assigned to each resource.
	 */
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	
	/**
	 * 
	 * @return The date the resource was created.
	 */
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	
	/**
	 * 
	 * @return The date the resource was last updated.
	 */
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	
	/**
	 * 
	 * @return An alphanumeric string identifying the account this resource occurred in.
	 */
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	
	/**
	 * 
	 * @return The API version being used when the resource was created.
	 */
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
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
	
	
	
}
