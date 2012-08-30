package com.telapi.api;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

import com.telapi.api.domain.Call;
import com.telapi.api.domain.Notification;
import com.telapi.api.domain.enums.LogLevel;
import com.telapi.api.domain.list.NotificationList;
import com.telapi.api.restproxies.CallProxy;
import com.telapi.api.restproxies.NotificationProxy;

public class NotificationTest extends BaseTelapiTest<NotificationProxy> {

	private CallProxy callProxy;
	
	public NotificationTest() {
		super(NotificationProxy.class);
	}
	
	@Before
	public void before(){
		callProxy = conn.createProxy(CallProxy.class);
	}

	@Test
	public void testListNotifications(){
		proxy.listNotifications(conf.getSid(), LogLevel.INFO, 0L, 10L).getEntity();
	}
	
	@Test
	public void testListCallNotifications(){
		NotificationList list = proxy.listNotifications(conf.getSid(), LogLevel.INFO, null, null).getEntity();
		Notification n = null;
		Call c = callProxy.listCalls(conf.getSid(), null, null, null, null, null, 0L, 1L).getEntity().iterator().next();
		Iterator<Notification> it = list.iterator();
		while ((n = it.next()).getCallSid() == null);
		NotificationList cList = proxy.listCallNotifications(conf.getSid(), c.getSid(), LogLevel.INFO, null, null).getEntity();
		
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
	public void testViewNotification() {
		NotificationList list = proxy.listNotifications(conf.getSid(), LogLevel.INFO, null, null).getEntity();
		Notification n = list.iterator().next();
		Notification vNot = proxy.viewNotification(conf.getSid(), n.getSid()).getEntity();
		Assert.assertEquals(vNot.getSid(), n.getSid());
	}

}