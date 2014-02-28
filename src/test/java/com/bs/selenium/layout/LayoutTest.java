package com.bs.selenium.layout;

import static org.junit.Assert.*;

import org.testng.annotations.Test;

import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class LayoutTest extends TestBase {

	@Test
	public void testLoginPageOk() throws Exception {
		app.getNavigationHelper().openMainPage();
		assertTrue(app.getUserHelper().hasNoLayoutBugs());

	}

	@Test
	public void testLoginPageNegativeWithoutLogin() throws Exception {
		User user = new User().setLogin("").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().hasNoLayoutBugs());

	}

	@Test
	public void testLoginPageNegativeWithoutPasswd() throws Exception {
		User user = new User().setLogin("oleg").setPassword("");
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().hasNoLayoutBugs());

	}

	@Test
	public void testInternalPagePositive() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		assertTrue(app.getUserHelper().hasNoLayoutBugs());
	}

	@Test
	public void testUserProfilePageOK() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		assertTrue(app.getUserHelper().hasNoLayoutBugs());
	}

	@Test
	public void testUserCabinetPageOK() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserCabinetPage();

		assertTrue(app.getUserHelper().hasNoLayoutBugs());
	}

	@Test
	public void testCreateNewFolderPageOK() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().openRelativeUrl("user/create/1");

		assertTrue(app.getUserHelper().hasNoLayoutBugs());
	}
	
	}
