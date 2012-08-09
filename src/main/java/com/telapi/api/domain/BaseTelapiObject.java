package com.telapi.api.domain;

import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonDateParser;

public class BaseTelapiObject {

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
	public String getAccountSid() {
		return accountSid;
	}
	public void setAccountSid(String accountSid) {
		this.accountSid = accountSid;
	}
	public String getApiVersion() {
		return apiVersion;
	}
	public void setApiVersion(String apiVersion) {
		this.apiVersion = apiVersion;
	}
	public String getUri() {
		return uri;
	}
	public void setUri(String uri) {
		this.uri = uri;
	}
	
	
	
}
