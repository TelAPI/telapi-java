package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Provides CNAM caller ID information.
 *
 */
public class CnamDip extends BaseTelapiObject{
	@JsonProperty("phone_number")
	private String phoneNumber;
	private String body;
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
	 * @return The result of our CNAM look up. Usually a name or organization associated with this phone.
	 */
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
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
