package com.bs.selenium.functional;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class ClickToggleButtonTest extends TestBase {

	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testToggleButton() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		Assert.assertTrue(app.getUserHelper().isToggled());
	}
}
