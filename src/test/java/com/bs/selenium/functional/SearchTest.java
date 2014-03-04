package com.bs.selenium.functional;

import org.junit.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.Files;
import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class SearchTest extends TestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testSearchForMyFilesPageOK() {

		Files filename = new Files().setName("png.png");
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);

		app.getNavigationHelper().gotoMyFilesSearchResultPage();
		app.getUserHelper().search(filename);
		Assert.assertTrue(app.getUserHelper().isSearchFound(filename));
	}

}
