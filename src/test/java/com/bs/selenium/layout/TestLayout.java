package com.bs.selenium.layout;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class TestLayout extends TestBase {

	@Test
	public void testLoginPageOk() throws Exception {
		app.getNavigationHelper().openMainPage();
		assertTrue(app.getUserHelper().hasNoLayoutBugs());

	}

	@Test
	public void testLoginPageNegative() throws Exception {
		User user = new User().setLogin("").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().hasNoLayoutBugs());

	}

	@Test
	public void testInternalPagePositive() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().hasNoLayoutBugs());
	}

}
