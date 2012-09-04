package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Lists Fraud control resource information.
 */
public class Fraud {
	@JsonProperty("max_outbound_rate")
	private BigDecimal maxOutboundRate;
	private DestinationFraudControlGroup destinations;
	
	/**
	 * @return The price limit an outbound call may be. Calls which cost more will be rejected.
	 */
	public BigDecimal getMaxOutboundRate() {
		return maxOutboundRate;
	}
	public void setMaxOutboundRate(BigDecimal maxOutboundRate) {
		this.maxOutboundRate = maxOutboundRate;
	}
	
	/**
	 * @return Destination information.
	 */
	public DestinationFraudControlGroup getDestinations() {
		return destinations;
	}
	public void setDestinations(DestinationFraudControlGroup destinations) {
		this.destinations = destinations;
	}
	
}