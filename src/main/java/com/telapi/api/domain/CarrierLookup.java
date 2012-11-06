package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.CarrierLookupStatus;
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
	private BigDecimal price;
	
	@JsonProperty("is_ported")
	private Boolean isPorted;
	@JsonProperty("is_roaming")
	private Boolean isRoaming;
	private CarrierLookupStatus stat;
	private String imsi;
	private String orn;
	private String pon;
	private String ron;
	private String mccmnc;
	private String onp;
	private String ocn;
	private String ocp;
	private String rnp;
	private String rcn;
	private String rcp;
	private String pnp;
	private String pcn;
	
	
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
	 * @return Cost of the look up.
	 */
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	/**
	 * @return Specifies if the phone number is ported. May be true or false.
	 */
	public Boolean getIsPorted() {
		return isPorted;
	}
	public void setIsPorted(Boolean isPorted) {
		this.isPorted = isPorted;
	}
	
	/**
	 * @return Specifies in real time if the phone number is currently roaming. May be true or false.
	 */
	public Boolean getIsRoaming() {
		return isRoaming;
	}
	public void setIsRoaming(Boolean isRoaming) {
		this.isRoaming = isRoaming;
	}
	
	/**
	 * @return Status telling whether the lookup was a success. May be DELIVRD, UNDELIV, UNKNOWN, or REJECTED.
	 */
	public CarrierLookupStatus getStat() {
		return stat;
	}
	public void setStat(CarrierLookupStatus stat) {
		this.stat = stat;
	}
	
	/**
	 * @return International Mobile Subscriber Identity. This is the phones network SIM card identifier.
	 */
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		this.imsi = imsi;
	}
	
	/**
	 * @return Name of the Original Network.
	 */
	public String getOrn() {
		return orn;
	}
	public void setOrn(String orn) {
		this.orn = orn;
	}
	
	/**
	 * @return Name of the Ported Network. Only displayed if the phone number is ported.
	 */
	public String getPon() {
		return pon;
	}
	public void setPon(String pon) {
		this.pon = pon;
	}
	
	/**
	 * @return Name of the Roaming Network. Only displayed if the phone number is roaming.
	 */
	public String getRon() {
		return ron;
	}
	public void setRon(String ron) {
		this.ron = ron;
	}
	
	/**
	 * @return Mobile Country Code, Mobile Network Code.
	 */
	public String getMccmnc() {
		return mccmnc;
	}
	public void setMccmnc(String mccmnc) {
		this.mccmnc = mccmnc;
	}
	
	/**
	 * @return Original Network Prefix.
	 */
	public String getOnp() {
		return onp;
	}
	public void setOnp(String onp) {
		this.onp = onp;
	}
	
	/**
	 * @return Original Country Name.
	 */
	public String getOcn() {
		return ocn;
	}
	public void setOcn(String ocn) {
		this.ocn = ocn;
	}
	
	/**
	 * @return Original Country Prefix.
	 */
	public String getOcp() {
		return ocp;
	}
	public void setOcp(String ocp) {
		this.ocp = ocp;
	}
	
	/**
	 * @return Roaming Network Prefix. Only displayed if the phone number is roaming.
	 */
	public String getRnp() {
		return rnp;
	}
	public void setRnp(String rnp) {
		this.rnp = rnp;
	}
	
	/**
	 * @return Roaming Country Name. Only displayed if the phone number is roaming.
	 */
	public String getRcn() {
		return rcn;
	}
	public void setRcn(String rcn) {
		this.rcn = rcn;
	}
	
	/**
	 * @return Roaming Country Prefix. Only displayed if the phone number is roaming.
	 */
	public String getRcp() {
		return rcp;
	}
	public void setRcp(String rcp) {
		this.rcp = rcp;
	}
	
	/**
	 * @return Ported Network Prefix. Only displayed if the phone number is ported.
	 */
	public String getPnp() {
		return pnp;
	}
	public void setPnp(String pnp) {
		this.pnp = pnp;
	}
	
	/**
	 * @return Ported Country Name. Only displayed if the phone number is ported.
	 */
	public String getPcn() {
		return pcn;
	}
	public void setPcn(String pcn) {
		this.pcn = pcn;
	}
	
	
}
