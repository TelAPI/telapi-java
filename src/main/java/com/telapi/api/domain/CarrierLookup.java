package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;

/**
 * Carrier lookup information.
 */
public class CarrierLookup extends BaseTelapiObject{
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String carrier;
	@JsonDeserialize(using = JsonBooleanParser.class)
	@JsonProperty("is_mobile")
	private Boolean isMobile;
	private String country;
	@JsonProperty("cic_code")
	private String cicCode;
	private BigDecimal price;
	
	/**
	 * @return The phone number the look up was performed on.
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	/**
	 * @return The carrier of the phone number we are looking up.
	 */
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	
	/**
	 * @return Specifies if the phone number is mobile. can be true or false.
	 */
	public Boolean getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}
	
	/**
	 * @return Code used to identify the phone numbers geographic origin. Found at the beginning of the number.
	 */
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	/**
	 * @return Carrier Identification Code. A four digit code used to route and switch calls.
	 */
	public String getCicCode() {
		return cicCode;
	}
	public void setCicCode(String cicCode) {
		this.cicCode = cicCode;
	}
	
	/**
	 * @return Cost of the look up.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
