package com.telapi.api.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Resource properties about conference calls that occurred through a TelAPI
 * account can be requested using our REST API. To view a single conference
 * resource, simply request it by its ConferenceSid.
 */
public class Conference extends BaseTelapiObject{
	private String name;
	
	private String status;
	
	@JsonProperty("member_count")
	private Long memberCount;
	@JsonProperty("run_time")
	private Long runTime;
	private List<ConferenceMember> members;
	
	/**
	 * @return User generated name of the conference.
	 */
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public Long getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
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
	/**
	 * @return List of members involved in the conference.
	 */
	public List<ConferenceMember> getMembers() {
		return members;
	}
	public void setMembers(List<ConferenceMember> members) {
		this.members = members;
	}
	
}
