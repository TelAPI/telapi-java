package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.PhoneNumberType;
import com.telapi.api.json.JsonBooleanParser;

/**
 * 
 * If you want to add a new TelAPI number, you need to know what ones are
 * available. Our REST API provides a way to request a list of available numbers
 * along with all of their resource properties so you know the numbers you have
 * to choose from.
 * 
 * Note that individual AvailablePhoneNumber resources can not be requested.
 * Requests only return a list of available resources based on the filtering
 * parameters sent with the request.
 * 
 */
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
	@JsonProperty("unblock_support")
	private Boolean unblockSupport;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("voice_enabled")
	private Boolean voiceEnabled;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("sms_enabled")
	private Boolean smsEnabled;
	@JsonDeserialize(using=JsonBooleanParser.class)
	@JsonProperty("supports_forwarded_from")
	private Boolean supportsForwardedFrom;
	
	/**
	 * @return Domestic format version of the available phone number. (e.g. 1234567890 to (123)-456-7890)
	 */
	public String getFriendlyName() {
		return friendlyName;
	}
	public void setFriendlyName(String friendlyName) {
		this.friendlyName = friendlyName;
	}
	/**
	 * @return The E.164 format number of each available number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return Local Access and Transportation Area of the available number. The LATA is determined by geographical region.
	 */
	public String getLata() {
		return lata;
	}
	public void setLata(String lata) {
		this.lata = lata;
	}
	/**
	 * @return The available phone numbers rate center.
	 */
	public String getRateCenter() {
		return rateCenter;
	}
	public void setRateCenter(String rateCenter) {
		this.rateCenter = rateCenter;
	}
	/**
	 * @return The latitude of the available phone number.
	 */
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	/**
	 * @return The longitude of the available phone number.
	 */
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	/**
	 * @return The region of the available phone number. Usually a two letter abbreviation.
	 */
	public String getRegion() {
		return region;
	}
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return The postal code (also known as zip code) of the available number.
	 */
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	/**
	 * @return Two letter country code of the available phone number.
	 */
	public String getIsoCountry() {
		return isoCountry;
	}
	public void setIsoCountry(String isoCountry) {
		this.isoCountry = isoCountry;
	}
	/**
	 * @return Code used to identify the phone numbers geographic origin. Found at the beginning of the number.
	 */
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	/**
	 * @return Numbering Plan Area of the available number. This is more commonly known as the area code.
	 */
	public String getNpa() {
		return npa;
	}
	public void setNpa(String npa) {
		this.npa = npa;
	}
	/**
	 * @return Three digits following the NPA (area code) in the available number.
	 */
	public String getExchange() {
		return exchange;
	}
	public void setExchange(String exchange) {
		this.exchange = exchange;
	}
	/**
	 * @return The available phone numbers city.
	 */
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return Type of phone number. (e.g. local, international, etc.)
	 */
	public PhoneNumberType getType() {
		return type;
	}
	public void setType(PhoneNumberType type) {
		this.type = type;
	}
	/**
	 * @return Cost of phone number setup.
	 */
	public BigDecimal getSetupCost() {
		return setupCost;
	}
	public void setSetupCost(BigDecimal setupCost) {
		this.setupCost = setupCost;
	}
	/**
	 * @return Cost of phone number per month.
	 */
	public BigDecimal getMonthlyCost() {
		return monthlyCost;
	}
	public void setMonthlyCost(BigDecimal monthlyCost) {
		this.monthlyCost = monthlyCost;
	}
	/**
	 * @return Is Voice enabled for this phone number? Can be true or false.
	 */
	public Boolean getVoiceEnabled() {
		return voiceEnabled;
	}
	public void setVoiceEnabled(Boolean voiceEnabled) {
		this.voiceEnabled = voiceEnabled;
	}
	/**
	 * @return Is SMS enabled for this phone number? Can be true or false.
	 */
	public Boolean getSmsEnabled() {
		return smsEnabled;
	}
	public void setSmsEnabled(Boolean smsEnabled) {
		this.smsEnabled = smsEnabled;
	}
	/**
	 * @return Does phone number support forwarded from? Can be true or false.
	 */
	public Boolean getSupportsForwardedFrom() {
		return supportsForwardedFrom;
	}
	public void setSupportsForwardedFrom(Boolean supportsForwardedFrom) {
		this.supportsForwardedFrom = supportsForwardedFrom;
	}
	/**
	 * @return
	 */
	public Boolean getUnblockSupport() {
		return unblockSupport;
	}
	public void setUnblockSupport(Boolean unblockSupport) {
		this.unblockSupport = unblockSupport;
	}

}