package com.telapi.api.domain;

import java.util.List;

public class DestinationFraudControlGroup {
	
	private List<Destination> blocked;
	private List<Destination> authorized;
	private List<Destination> whitelisted;
	
	public List<Destination> getBlocked() {
		return blocked;
	}
	public void setBlocked(List<Destination> blocked) {
		this.blocked = blocked;
	}
	public List<Destination> getAuthorized() {
		return authorized;
	}
	public void setAuthorized(List<Destination> authorized) {
		this.authorized = authorized;
	}
	public List<Destination> getWhitelisted() {
		return whitelisted;
	}
	public void setWhitelisted(List<Destination> whitelisted) {
		this.whitelisted = whitelisted;
	}

}
