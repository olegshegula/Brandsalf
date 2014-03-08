package com.bs.selenium.applogic2;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bs.selenium.applogic.UserHelper;
import com.bs.selenium.model.Constants;
import com.bs.selenium.model.Files;
import com.bs.selenium.model.Folder;
import com.bs.selenium.model.User;
import com.bs.selenium.pagesall.UserProfilePage;
import com.googlecode.fightinglayoutbugs.FightingLayoutBugs;
import com.googlecode.fightinglayoutbugs.LayoutBug;
import com.googlecode.fightinglayoutbugs.LayoutBugDetector;
import com.googlecode.fightinglayoutbugs.WebPage;

public class UserHelper2 extends DriverBasedHelper implements UserHelper {

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
			WebPage webPage = new WebPage(pages.getWebDriver());
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
	public void createFolderForProject(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickProjectLink()
				.ensurePageLoaded().setfoldernameField(foldername.getName())
				.clickAddButton();

	}

	@Override
	public boolean isFolderCreated(Folder foldername) {

		List<String> actualLinkList = new ArrayList<String>();

		List<String> expectedList = Arrays.asList(foldername.getName());

		List<WebElement> linkList = pages.getWebDriver().findElements(
				By.xpath("//div[@id='moveFileList']/a"));

		for (WebElement element : linkList) {
			actualLinkList.add(element.getText());
			System.out.println(element.getText());
		}

		return actualLinkList.containsAll(expectedList);

	}

	@Override
	public void createFolderForTemplate(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickTemplatetLink()
				.ensurePageLoaded().setfoldernameField(foldername.getName())
				.clickAddButton();
	}

	@Override
	public void createFolderForOffers(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickOffersLink()
				.ensurePageLoaded().setfoldernameField(foldername.getName())
				.clickAddButton();
	}

	@Override
	public boolean isToggled() {
		return pages.internalPage.ensurePageLoaded().clickToggleButton()
				.isElementDisplayed();
	}

	@Override
	public void avatarUpload(Files path) {
		pages.userProfilePage.ensurePageLoaded().uploadFile(path.getPath())
				.clickSubmitButton();

	}

	@Override
	public void createFolderForProposition(Folder foldername) {
		pages.internalPage.ensurePageLoaded().clickBussinessPropLink()
				.ensurePageLoaded().setfoldernameField(foldername.getName())
				.clickAddButton();

	}

	@Override
	public boolean isavatarUpload() {

		return pages.usercabinetPage.ensurePageLoaded().getAvatarpath()
				.isEmpty();
	}

	@Override
	public boolean isPullDownMenuContentCorrect(String s1, String s2,
			String s3, String s4, String s5) {

		pages.internalPage.ensurePageLoaded();

		List<String> actualLinkList = new ArrayList<String>();

		List<String> expectedList = Arrays.asList(s1, s2, s3, s4, s5);

		List<WebElement> linkList = pages.getWebDriver().findElements(
				By.xpath(Constants.ContentByXpath));

		for (WebElement element : linkList) {
			actualLinkList.add(element.getText());
			System.out.println(element.getText());
		}

		return actualLinkList.containsAll(expectedList);
	}

	@Override
	public boolean isPullDownMenuCategoryFileCorrect(String s1, String s2,
			String s3, String s4, String s5) {
		pages.internalPage.ensurePageLoaded();

		List<String> actualLinkList = new ArrayList<String>();

		List<String> expectedList = Arrays.asList(s1, s2, s3, s4, s5);

		List<WebElement> linkList = pages.getWebDriver().findElements(
				By.xpath(Constants.CategoryFileByXpath));

		for (WebElement element : linkList) {
			actualLinkList.add(element.getText());
			System.out.println(element.getText());
		}

		return actualLinkList.containsAll(expectedList);
	}

	@Override
	public void search(Files filename) {
		pages.internalPage.ensurePageLoaded().clickSearchLink()
				.setSearchField(filename.getName()).clickSearchOKBtn();

	}

	@Override
	public boolean isSearchFound(Files filename) {
		return pages.myfilessearchPage.ensurePageLoaded()
				.getsearchResultTable().contains(filename.getName());
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

