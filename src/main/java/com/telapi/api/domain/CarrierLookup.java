package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.json.JsonBooleanParser;

public class CarrierLookup extends BaseTelapiObjectWithSid{
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
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getCarrier() {
		return carrier;
	}
	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
	public Boolean getIsMobile() {
		return isMobile;
	}
	public void setIsMobile(Boolean isMobile) {
		this.isMobile = isMobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCicCode() {
		return cicCode;
	}
	public void setCicCode(String cicCode) {
		this.cicCode = cicCode;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
}
