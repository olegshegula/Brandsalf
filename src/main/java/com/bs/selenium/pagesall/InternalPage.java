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

	@FindBy(xpath = "//a[text()='Профіль']")
	private WebElement profilemenu;

	@FindBy(xpath = "//a[text()='Вихід']")
	private WebElement profilemenuexit;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='Проекти']")
	private WebElement projectlink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='Шаблони']")
	private WebElement templatelink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='Пропозиції']")
	private WebElement offerlink;

	@FindBy(xpath = "//div[@id='moveFileList']/a[text()='Бізнес пропозиції']")
	private WebElement bpropositionslink;

	@FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")
	private WebElement logoutLink;

	@FindBy(id = "toggleTreeList")
	private WebElement toggleTreeListBtn;

	@FindBy(xpath = "//div[@id='moveFileList']")
	private WebElement moveFileList;

	@FindBy(xpath = "//*[@id='linkToCabinet']/a[text()='Особистий кабінет']")
	private WebElement usercabinetlink;

	@FindBy(xpath = "//a[@href='#collapseThree']")
	private WebElement contentlink;

	@FindBy(xpath = "//a[@href='#collapseTwo']")
	private WebElement categorylink;

	@FindBy(xpath = "//*[@id='search']/a")
	private WebElement searchlink;

	@FindBy(xpath = "//*[@id='formSearch']//input[@type='text']")
	private WebElement searchinput;

	@FindBy(xpath = ".//*[@id='formSearch']//button[@type='submit']")
	private WebElement searchOKBtn;
	
	@FindBy(xpath = "//a[text()='Мої файли']")
	private WebElement clickMyFilePageTab;
	
	public void clickMyFilePageTab(){
		clickMyFilePageTab.click();
		
	}
	
	public void clickContentLink() {
		contentlink.click();

	}

	public MyFilesSearchResultPage clickSearchOKBtn() {
		searchOKBtn.click();
		return pages.myfilessearchPage;

	}

	public void clickCategorytLink() {
		categorylink.click();

	}

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
		offerlink.click();
		return pages.loadPage;
	}

	public LoadPage clickBussinessPropLink() {
		bpropositionslink.click();
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

	public UserCabinetPage clickUserCabinetPage() {
		usercabinetlink.click();
		return pages.usercabinetPage;
	}

	public InternalPage clickSearchLink() {
		searchlink.click();
		return pages.internalPage;

	}

	public InternalPage setSearchField(String text) {

		searchinput.sendKeys(text);
		return this;
	}

}
