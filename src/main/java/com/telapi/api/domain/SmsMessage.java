package com.telapi.api.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonDeserialize;

import com.telapi.api.domain.enums.SmsDirection;
import com.telapi.api.json.JsonDateParser;

public class SmsMessage extends BaseTelapiObject {
	@JsonDeserialize(using = JsonDateParser.class)
	@JsonProperty(value="date_sent")
	private Date dateSent;
	private String to;
	private String from;
	private String body;
	private String status;
	private SmsDirection direction;
	private BigDecimal price;

	public Date getDateSent() {
		return dateSent;
	}
	public void setDateSent(Date dateSent) {
		this.dateSent = dateSent;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public SmsDirection getDirection() {
		return direction;
	}
	public void setDirection(SmsDirection direction) {
		this.direction = direction;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
}
