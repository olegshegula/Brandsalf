package com.bs.selenium.functional;

import org.testng.Assert;
import org.testng.annotations.*;

import com.bs.selenium.model.Files;
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
		User edituser = new User()
				.setUservideo("http://www.youtube.com/watch?v=tswOmw6vqhI")
				.setUsername("Юыху").setLogin("oleg").setPhone("0675627660")
				.setEmail("oleg.shegula@gmail.com").setPassword("123qweasd")
				.setPassword2("123qweasd");

		// Edit user profile
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().edituserprofile(edituser);
		app.getNavigationHelper().openMainPage();
		app.getUserHelper().logout();

		// Check
		User correctuser = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(correctuser);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(correctuser));

	}
	
	@Test
	public void testEnterAllFieldsCorrectWithoutPasswords() throws Exception {

		// Prepare the new data for profile
		User edituser = new User()
				.setUservideo("http://www.youtube.com/watch?v=tswOmw6vqhI")
				.setUsername("Юыху").setLogin("oleg").setPhone("0675627660")
				.setEmail("oleg.shegula@gmail.com");

		// Edit user profile
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().edituserprofile(edituser);
		app.getNavigationHelper().openMainPage();
		app.getUserHelper().logout();

		// Check
		User correctuser = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(correctuser);
		Assert.assertTrue(app.getUserHelper().isLoggedInAs(correctuser));

	}


	@Test
	public void testLoadAvatarPngPositiv() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		Files path = new Files().setPath("c:\\3png.png");

		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().avatarUpload(path);
		// Assert.assertFalse(app.getUserHelper().isavatarUpload());
	}

	@Test
	public void testLoadAvatarJpgPositiv() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		Files path = new Files().setPath("c:\\2jpg.jpg");

		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().avatarUpload(path);
		// Assert.assertFalse(app.getUserHelper().isavatarUpload());
	}

	@Test
	public void testLoadAvatarJpegPositiv() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		Files path = new Files().setPath("c:\\4jpeg.jpg");

		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().avatarUpload(path);
		// Assert.assertFalse(app.getUserHelper().isavatarUpload());
	}

	@Test
	public void testLoadAvatarGifPositive() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		Files path = new Files().setPath("c:\\1gif.gif");

		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().avatarUpload(path);
		// Assert.assertFalse(app.getUserHelper().isavatarUpload());

	}

	@Test
	public void testLoadAvatarNegative() throws Exception {

		User user = new User().setLogin("oleg").setPassword("123qweasd");
		Files path = new Files().setPath("c:\\test.docx");

		app.getUserHelper().loginAs(user);
		app.getNavigationHelper().gotoUserProfilePage();
		app.getUserHelper().avatarUpload(path);

	}
}
