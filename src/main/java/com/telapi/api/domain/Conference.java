package com.telapi.api.domain;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class Conference extends BaseTelapiObject{
	private String name;
	
	@JsonProperty("member_count")
	private Long memberCount;
	@JsonProperty("run_time")
	private Long runTime;
	private List<ConferenceMember> members;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public Long getMemberCount() {
		return memberCount;
	}
	public void setMemberCount(Long memberCount) {
		this.memberCount = memberCount;
	}
	public Long getRunTime() {
		return runTime;
	}
	public void setRunTime(Long runTime) {
		this.runTime = runTime;
	}
	public List<ConferenceMember> getMembers() {
		return members;
	}
	public void setMembers(List<ConferenceMember> members) {
		this.members = members;
	}
	
}
