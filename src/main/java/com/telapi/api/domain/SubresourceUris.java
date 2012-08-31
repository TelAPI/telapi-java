package com.telapi.api.domain;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * List of an accounts various subresources and their URI path. Examples of
 * subresources are things like calls that occurred through the account, sms
 * messages, purchased phone numbers, etc.
 * 
 */
public class SubresourceUris {
	@JsonProperty(value="available_phone_numbers")
	private String availablePhoneNumbers;
	private String calls;
	private String conferences;
	@JsonProperty(value="incoming_phone_numbers")
	private String incomingPhoneNumbers;
	private String notifications;
	private String recordings;
	@JsonProperty(value="sms_messages")
	private String smsMessages;
	private String transcriptions;
	private String transactions;
	private String applications;
	private String fraud;
	private String cnam;
	private String carrier;
	
	public String getAvailablePhoneNumbers() {
		return availablePhoneNumbers;
	}
	public void setAvailablePhoneNumbers(String availablePhoneNumbers) {
		this.availablePhoneNumbers = availablePhoneNumbers;
	}
	public String getCalls() {
		return calls;
	}
	public void setCalls(String calls) {
		this.calls = calls;
	}
	public String getConferences() {
		return conferences;
	}
	public void setConferences(String conferences) {
		this.conferences = conferences;
	}
	public String getIncomingPhoneNumbers() {
		return incomingPhoneNumbers;
	}
	public void setIncomingPhoneNumbers(String incomingPhoneNumbers) {
		this.incomingPhoneNumbers = incomingPhoneNumbers;
	}
	public String getNotifications() {
		return notifications;
	}
	public void setNotifications(String notifications) {
		this.notifications = notifications;
	}
	public String getRecordings() {
		return recordings;
	}
	public void setRecordings(String recordings) {
		this.recordings = recordings;
	}
	public String getSmsMessages() {
		return smsMessages;
	}
	public void setSmsMessages(String smsMessages) {
		this.smsMessages = smsMessages;
	}
	public String getTranscriptions() {
		return transcriptions;
	}
	public void setTranscriptions(String transcriptions) {
		this.transcriptions = transcriptions;
	}
	public String getTransactions() {
		return transactions;
	}
	public void setTransactions(String transactions) {
		this.transactions = transactions;
	}
	public String getApplications() {
		return applications;
	}
	public void setApplications(String applications) {
		this.applications = applications;
	}
	public String getFraud() {
		return fraud;
	}
	public void setFraud(String fraud) {
		this.fraud = fraud;
	}
	public String getCnam() {
		return cnam;
	}
	public void setCnam(String cnam) {
		this.cnam = cnam;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}

}
