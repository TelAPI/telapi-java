package com.telapi.api.domain;

import java.math.BigDecimal;

import org.codehaus.jackson.annotate.JsonProperty;

public class Fraud {
	@JsonProperty("max_outbound_rate")
	private BigDecimal maxOutboundRate;
	private DestinationFraudControlGroup destinations;
	
	public BigDecimal getMaxOutboundRate() {
		return maxOutboundRate;
	}
	public void setMaxOutboundRate(BigDecimal maxOutboundRate) {
		this.maxOutboundRate = maxOutboundRate;
	}
	public DestinationFraudControlGroup getDestinations() {
		return destinations;
	}
	public void setDestinations(DestinationFraudControlGroup destinations) {
		this.destinations = destinations;
	}
	
}