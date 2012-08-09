package com.telapi.api.domain.list;

import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.telapi.api.domain.Notification;
import com.telapi.api.domain.TelapiList;

public class NotificationList extends TelapiList<Notification>{

	@Override
	@JsonProperty("notifications")
	protected void mapElements(List<Notification> elements) {
		setElements(elements);
	}

}
