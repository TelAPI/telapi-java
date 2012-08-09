package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.PhoneNumberType;
import com.telapi.api.json.JsonBooleanParser;

public class AvailablePhoneNumber {
	@JsonProperty("friendly_name")
	private String friendlyName;
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String lata;
	@JsonProperty("rate_center")
	private String rateCenter;
	private String latitude;
	private String longitude;
	private String region;
	@JsonProperty("postal_code")
	private String postalCode;
	@JsonProperty("iso_country")
	private String isoCountry;
	@JsonProperty("country_code")
	private String countryCode;
	private String npa;
	private String exchange;
	private String city;
	private PhoneNumberType type;
	@JsonProperty("setup_cost")
	private BigDecimal setupCost;
	@JsonProperty("monthly_cost")
	private BigDecimal monthlyCost;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("voice_enabled")
	private Boolean voiceEnabled;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("sms_enabled")
	private Boolean smsEnabled;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("supports_forwarded_from")
	private Boolean supportsForwardedFrom;
	
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLata() {
		return lata;
	}
	public void setLata(String lata) {
		this.lata = lata;
	}
	public String getRateCenter() {
		return rateCenter;
	}
	public void setRateCenter(String rateCenter) {
		this.rateCenter = rateCenter;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getIsoCountry() {
		return isoCountry;
	}
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getNpa() {
		return npa;
	}
	public void setNpa(String npa) {
		this.npa = npa;
	}
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public PhoneNumberType getType() {
		return type;
	}
	public void setType(PhoneNumberType type) {
		this.type = type;
	}
	public BigDecimal getSetupCost() {
		return setupCost;
	}
	public void setSetupCost(BigDecimal setupCost) {
		this.setupCost = setupCost;
	}
	public BigDecimal getMonthlyCost() {
		return monthlyCost;
	}
	public void setMonthlyCost(BigDecimal monthlyCost) {
		this.monthlyCost = monthlyCost;
	}
	public Boolean getVoiceEnabled() {
		return voiceEnabled;
	}
	public void setVoiceEnabled(Boolean voiceEnabled) {
		this.voiceEnabled = voiceEnabled;
	}
	public Boolean getSmsEnabled() {
		return smsEnabled;
	}
	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}
	public Boolean getSupportsForwardedFrom() {
		return supportsForwardedFrom;
	}
	public void setSupportsForwardedFrom(Boolean supportsForwardedFrom) {
		this.supportsForwardedFrom = supportsForwardedFrom;
	}

}