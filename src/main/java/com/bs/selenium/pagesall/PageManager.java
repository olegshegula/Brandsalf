package com.bs.selenium.pagesall;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageManager {

	private WebDriver driver;

	public LoginPage loginPage;
	public InternalPage internalPage;
	public UserProfilePage userProfilePage;
	public UserManagementPage userManagementPage;
	public LoadPage loadPage;
	public UserCabinetPage usercabinetPage;
	public MyFilesSearchResultPage myfilessearchPage;

	public PageManager(WebDriver driver) {
		this.driver = driver;
		loginPage = initElements(new LoginPage(this));
		internalPage = initElements(new InternalPage(this));
		userProfilePage = initElements(new UserProfilePage(this));
		userManagementPage = initElements(new UserManagementPage(this));
		loadPage = initElements(new LoadPage(this));
		usercabinetPage = initElements(new UserCabinetPage(this));
		myfilessearchPage = initElements(new MyFilesSearchResultPage(this));
	}

	private <T extends Page> T initElements(T page) {
		// PageFactory.initElements(driver, page);
		// PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10),
		// page);
		PageFactory.initElements(
				new DisplayedElementLocatorFactory(driver, 30), page);
		return page;
	}

	public WebDriver getWebDriver() {
		return driver;
	}

}
