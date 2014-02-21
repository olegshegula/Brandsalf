package com.bs.selenium.functional;

import org.testng.Assert;
import org.testng.annotations.*;

import com.bs.selenium.model.User;

public class EditProfileTest extends com.bs.selenium.pages.TestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testEnterAllFieldsCorrect() throws Exception {

		// Prepare the new data for profile
		User edituser = new User().setUservideo("http://www.youtube.com/watch?v=tswOmw6vqhI")
				.setUsername("Юыху1").setLogin("oleg").setPhone("0675627660")
				.setEmail("oleg.shegula@gmail.com").setPassword("123qweasd")
				.setPassword2("123qweasd");

		// Edit user profile
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);		
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().edituserprofile(edituser);
		app.getUserHelper().logout();
		
		//Check
		 User correctuser = new User().setLogin("oleg").setPassword("123qweasd");
		    app.getUserHelper().loginAs(correctuser);
		    Assert.assertTrue(app.getUserHelper().isLoggedInAs(correctuser));

	}
}
