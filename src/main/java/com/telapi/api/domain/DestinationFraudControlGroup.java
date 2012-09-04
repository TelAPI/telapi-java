package com.telapi.api.domain;

import java.util.List;

/**
 * Contains Fraud control information about various Destinations.
 *
 */
public class DestinationFraudControlGroup {
	
	private List<Destination> blocked;
	private List<Destination> authorized;
	private List<Destination> whitelisted;
	
	/**
	 * @return A list of blocked Destinations.
	 */
	public List<Destination> getBlocked() {
		return blocked;
	}
	public void setBlocked(List<Destination> blocked) {
		this.blocked = blocked;
	}
	
	/**
	 * @return A list of authorized Destinations.
	 */
	public List<Destination> getAuthorized() {
		return authorized;
	}
	public void setAuthorized(List<Destination> authorized) {
		this.authorized = authorized;
	}
	
	/**
	 * @return A list of whitelisted Destinations.
	 */
	public List<Destination> getWhitelisted() {
		return whitelisted;
	}
	public void setWhitelisted(List<Destination> whitelisted) {
		this.whitelisted = whitelisted;
	}

}
