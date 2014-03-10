package com.bs.selenium.functional;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class UserCabinetTest extends TestBase{
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testCheckUserInfoInTheCabinet() {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		
		app.getUserHelper().getLoggedUserInfo();
		app.getUserHelper().getUserCabinetInfo();
		
	}
}
