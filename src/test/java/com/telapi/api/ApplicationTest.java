package com.telapi.api;

import org.junit.Assert;
import org.junit.Test;

import com.telapi.api.domain.Application;
import com.telapi.api.domain.enums.HttpMethod;
import com.telapi.api.domain.list.ApplicationList;
import com.telapi.api.restproxies.ApplicationProxy;

public class ApplicationTest extends BaseTelapiTest<ApplicationProxy>{

	public ApplicationTest() {
		super(ApplicationProxy.class);
	}
	
	@Test
	public void testCreateApplication() {
		Application app = proxy.createApplication(conf.getSid(), "my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null).getEntity();
		
		Assert.assertEquals("heartbeat.com", app.getHeartbeatUrl());
		Assert.assertEquals("my_app", app.getFriendlyName());
	}
	
	@Test
	public void testListApplications() {
		Application app = proxy.createApplication(conf.getSid(), "my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null).getEntity();
		
		ApplicationList list = proxy.listApplications(conf.getSid(), null, null, null).getEntity();
		
		boolean found = false;
		for(Application lApp : list) {
			if (lApp.getSid().equals(app.getSid())) {
				found = true;
				break;
			}
		}
		Assert.assertTrue(found);
	}
	
	@Test
	public void testViewApplication() {
		Application app = proxy.createApplication(conf.getSid(), "my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null).getEntity();
		
		Application vApp = proxy.viewApplication(conf.getSid(), app.getSid()).getEntity();
		
		Assert.assertEquals(app.getSid(), vApp.getSid());
		Assert.assertEquals("heartbeat.com", vApp.getHeartbeatUrl());
		Assert.assertEquals("my_app", vApp.getFriendlyName());
	}
	
	@Test
	public void testUpdateApplication() {
		Application app = proxy.createApplication(conf.getSid(), "my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null).getEntity();
		
		Assert.assertEquals("heartbeat.com", app.getHeartbeatUrl());
		Assert.assertEquals(HttpMethod.GET, app.getHeartbeatMethod());
		
		Application uApp = proxy.updateApplication(conf.getSid(), app.getSid(), 
				null, "voice.com", null, null, null, null, null, null, null, null, "nobeat.com", HttpMethod.POST, null, null).getEntity();
		
		Application vApp = proxy.viewApplication(conf.getSid(), uApp.getSid()).getEntity();
		
		Assert.assertEquals(vApp.getSid(), app.getSid());
		Assert.assertEquals("nobeat.com", vApp.getHeartbeatUrl());
		Assert.assertEquals(HttpMethod.POST, vApp.getHeartbeatMethod());
	}
	
	@Test
	public void testDeleteApplication() {
		Application app = proxy.createApplication(conf.getSid(), "my_app", "www.google.com", HttpMethod.GET, null, 
				null, null, null, null, null, null, "heartbeat.com", HttpMethod.GET, null, null).getEntity();
		
		proxy.deleteApplication(conf.getSid(), app.getSid()).getEntity();
		
		ApplicationList list = proxy.listApplications(conf.getSid(), null, null, null).getEntity();

		for(Application lApp : list) {
			if (lApp.getSid().equals(app.getSid())) {
				Assert.fail("Application wasn't deleted.");
			}
		}
	}
}
