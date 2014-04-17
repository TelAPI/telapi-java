package com.telapi.api;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.Notification;
import com.telapi.api.domain.enums.LogLevel;
import com.telapi.api.domain.list.NotificationList;
import com.telapi.api.exceptions.TelapiException;

public class NotificationTest extends BaseTelapiTest  {


	@Test
	public void testListNotifications() throws TelapiException{
		connector.listNotifications(LogLevel.INFO, 0L, 10L);
	}
	
	@Test
	public void testListCallNotifications() throws TelapiException {
		NotificationList list = connector.listNotifications(LogLevel.INFO, 0L, 10L);
		Notification n = null;
		Call c = connector.listCalls(null, null, null, null, null, 0L, 1L, null).iterator().next();
		Iterator<Notification> it = list.iterator();
		while ((n = it.next()).getCallSid() == null);
		NotificationList cList = connector.listCallNotifications(c.getSid(), LogLevel.INFO, 0L, 10L);
		
		boolean found = false;
		for(Notification n2 : cList) {
			if (n2.getSid().equals(n.getSid())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found);
	}
	
	@Test
	public void testViewNotification() throws TelapiException {
		NotificationList list = connector.listNotifications(LogLevel.INFO, null, null);
		Notification n = list.iterator().next();
		Notification vNot = connector.viewNotification(n.getSid());
		Assert.assertEquals(vNot.getSid(), n.getSid());
	}

}
