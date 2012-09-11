package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Resource properties about conference calls that occurred through a TelAPI
 * account can be requested using our REST API. To view a single conference
 * resource, simply request it by its ConferenceSid.
 */
public class Conference extends BaseTelapiObject{
	@JsonProperty("friendly_name")
	private String friendlyName;
	
	private String status;
	
	@JsonProperty("participant_count")
	private Long participantCount;
	@JsonProperty("run_time")
	private Long runTime;
	
	@JsonProperty("subresource_uris")
	private ConferenceSubresourceUris subresourceUris;
	
	/**
	 * @return User generated name of the conference.
	 */
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	/**
	 * @return Conference status. Can be 'init', 'in-progress' or 'completed'.
	 */
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return The number of members that participated in the conference.
	 */
	public Long getParticipantCount() {
		return participantCount;
	}
	public void setParticipantCount(Long participantCount) {
		this.participantCount = participantCount;
	}
	/**
	 * @return Conference duration in seconds.
	 */
	public Long getRunTime() {
		return runTime;
	}
	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}
	
	public ConferenceSubresourceUris getSubresourceUris() {
		return subresourceUris;
	}
	public void setSubresourceUris(ConferenceSubresourceUris subresourceUris) {
		this.subresourceUris = subresourceUris;
	}
	
}
