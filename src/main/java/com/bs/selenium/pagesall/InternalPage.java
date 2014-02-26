package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}

	public InternalPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By
				.id("bs-example-navbar-collapse-1")));
		return this;
	}

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")
	private WebElement userProfileLink;

	// @FindBy(xpath = "//b[@class='caret']")
	// private WebElement userManagementLink;

	@FindBy(xpath = "//a[text()='�������']")
	private WebElement profilemenu;

	@FindBy(xpath = "//a[text()='�����']")
	private WebElement profilemenuexit;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='�������']")
	private WebElement projectlink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='�������']")
	private WebElement templatelink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='����������']")
	private WebElement offerlink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='������ ����������']")
	private WebElement bpropositionslink;
	
	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")
	private WebElement logoutLink;

	@FindBy(id = "toggleTreeList")
	private WebElement toggleTreeListBtn;

	@FindBy(xpath = "//div[@id='moveFileList']")
	private WebElement moveFileList;

	public UserProfilePage clickUserProfilePage() {
		userProfileLink.click();
		profilemenu.click();
		return pages.userProfilePage;
	}

	public LoginPage clickLogoutLink() {
		logoutLink.click();
		profilemenuexit.click();
		// wait.until(alertIsPresent()).accept();
		return pages.loginPage;
	}

	public LoadPage clickProjectLink() {
		projectlink.click();
		return pages.loadPage;
	}

	public LoadPage clickTemplatetLink() {
		templatelink.click();
		return pages.loadPage;
	}

	public LoadPage clickOffersLink() {
		bpropositionslink.click();
		return pages.loadPage;
	}
	
	public LoadPage clickBussinessPropLink() {
		offerlink.click();
		return pages.loadPage;
	}

	public InternalPage clickToggleButton() {
		toggleTreeListBtn.click();
		return pages.internalPage;
	}

	public boolean isElementDisplayed() {

		try {
			moveFileList.isDisplayed();
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}

	}

}
