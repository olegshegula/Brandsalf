package com.bs.selenium.functional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.Folder;
import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class AddNewFolderTest extends TestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testAddNewFolderforProjectOk() throws Exception {
		// Prepare data
		Folder foldername = new Folder().setName("AutoTest");
		User user = new User().setLogin("oleg").setPassword("123qweasd");

		// Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolderForProject(foldername);
		// Check existing of folder
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/1");
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));

	}

	@Test
	public void testAddNewFolderforProjectNegative() throws Exception {
		// Prepare data
		Folder foldername = new Folder()
				.setName("AutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTestAutoTest");
		User user = new User().setLogin("oleg").setPassword("123qweasd");

		// Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolderForProject(foldername);
		// Check existing of folder
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/1");
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));

	}

	@Test
	public void testAddNewFolderforTemplateOk() throws Exception {
		// Prepare data
		Folder foldername = new Folder().setName("AutoTestTemplate");
		User user = new User().setLogin("oleg").setPassword("123qweasd");

		// Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolderForTemplate(foldername);
		// Check existing of folder
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/2");
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));

	}

	@Test
	public void testAddNewFolderforOffersOk() throws Exception {
		// Prepare data
		Folder foldername = new Folder().setName("AutoTestOffers");
		User user = new User().setLogin("oleg").setPassword("123qweasd");

		// Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolderForOffers(foldername);
		// Check existing of folder
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/52280");
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));

	}

	@Test
	public void testAddNewFolderforBusinessPropositionsOk() throws Exception {
		// Prepare data
		Folder foldername = new Folder().setName("AutoForlderBusiness");
		User user = new User().setLogin("oleg").setPassword("123qweasd");

		// Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolderForProposition(foldername);
		// Check existing of folder
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/148417");
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));

	}
}
