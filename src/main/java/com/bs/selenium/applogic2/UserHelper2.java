package com.bs.selenium.applogic2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bs.selenium.applogic.UserHelper;
import com.bs.selenium.model.Folder;
import com.bs.selenium.model.User;
import com.bs.selenium.pagesall.Page;
import com.bs.selenium.pagesall.UserProfilePage;
import com.googlecode.fightinglayoutbugs.DetectInvalidImageUrls;
import com.googlecode.fightinglayoutbugs.DetectTextNearOrOverlappingHorizontalEdge;
import com.googlecode.fightinglayoutbugs.DetectTextWithTooLowContrast;
import com.googlecode.fightinglayoutbugs.FightingLayoutBugs;
import com.googlecode.fightinglayoutbugs.LayoutBug;
import com.googlecode.fightinglayoutbugs.LayoutBugDetector;
import com.googlecode.fightinglayoutbugs.WebPage;

public class UserHelper2 extends DriverBasedHelper implements UserHelper {

	private WebPage _driver;

	public UserHelper2(ApplicationManager2 manager) {
		super(manager.getWebDriver());
	}

	@Override
	public void loginAs(User user) {
		pages.loginPage.ensurePageLoaded().setUsernameField(user.getLogin())
				.setPasswordField(user.getPassword()).clickSubmitButton();

	}

	@Override
	public void logout() {
		pages.internalPage.ensurePageLoaded().clickLogoutLink();
	}

	@Override
	public boolean isLoggedIn() {
		return pages.internalPage.waitPageLoaded();
	}

	@Override
	public boolean isLoggedInAs(User user) {

		return isLoggedIn()
				&& getLoggedUser().getLogin().equals(user.getLogin());

	}

	@Override
	public boolean isNotLoggedIn() {
		return pages.loginPage.waitPageLoaded();
	}

	private User getLoggedUser() {
		UserProfilePage userProfile = pages.internalPage.ensurePageLoaded()
				.clickUserProfilePage().ensurePageLoaded();
		return new User().setLogin(userProfile.getUsername());

	}

	@Override
	public void edituserprofile(User edituser) {
		pages.userProfilePage.ensurePageLoaded()
				.setuservideoField(edituser.getUservideo())
				.setusernameField(edituser.getUsername())
				.setuserloginField(edituser.getLogin())
				.setuserphoneField(edituser.getPhone())
				.setEmailField(edituser.getEmail())
				.setPassword(edituser.getPassword())
				.setPassword2(edituser.getPassword2()).clickSubmitButton();

	}

	@Override
	public int getNumbersofLayoutBags() throws Exception {
		try {

			final LayoutBugDetector detector = new FightingLayoutBugs();
			WebPage webPage = new WebPage(driver);
			detector.setScreenshotDir(new File("pic"));
			final Collection<LayoutBug> layoutBugs = detector
					.findLayoutBugsIn(webPage);
			System.out
					.println("Found " + layoutBugs.size() + " layout bug(s).");

			return layoutBugs.size();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return 0;

	}

	@Override
	public boolean hasNoLayoutBugs() throws Exception {
		if (getNumbersofLayoutBags() >= 1) {
			return false;
		}
		return true;
	}

	@Override
	public void createFolder(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickProjectLink()
				.ensurePageLoaded().setfoldernameField(foldername.getName())
				.clickAddButton();

	}

	@Override
	public boolean isFolderCreated(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickProjectLink();
		List<String> actualLinkList = new ArrayList<String>();
		List<String> expectedLinkList = Arrays.asList(foldername.getName());

		List<WebElement> linkList = driver.findElements(By.id("moveFileList"));
		for (WebElement element : linkList) {
			System.out.println(element.getText());
			actualLinkList.add(element.getText());
		}
		if(actualLinkList.contains(expectedLinkList)==true){
			return true;
		}
		return false;
	}
}

// assertTrue(layoutBugs.size() ==1);
// final LayoutBug layoutBug = layoutBugs.iterator().next();
// assertThat(layoutBug.getScreenshot(), HamcrestHelper.isNotNull);
// System.out.println(layoutBug);
// assertThat(layoutBug.getScreenshot().isFile());
// assertThat(layoutBug.getScreenshot().lastModified() > startTime);

/*
 * FightingLayoutBugs flb = new FightingLayoutBugs(); WebPage webPage = new
 * WebPage(driver); flb.setScreenshotDir(new File("pic")); final
 * Collection<LayoutBug> layoutBugs = flb.findLayoutBugsIn(webPage);
 * System.out.println("Found " + layoutBugs.size() + " layout bug(s)."); for
 * (LayoutBug bug : layoutBugs) { System.out.println(bug); }
 */

/*
 * private User getLoggedUser() { UserProfilePage userProfile =
 * pages.internalPage.ensurePageLoaded() .clickUserProfilePage()
 * .ensurePageLoaded(); return new User() .setLogin(userProfile.getUsername())
 * .setEmail(userProfile.getEmail()) .setRole(userProfile.getRole()); }
 */

