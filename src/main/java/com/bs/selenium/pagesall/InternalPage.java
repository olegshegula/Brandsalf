package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InternalPage extends AnyPage {

	public InternalPage(PageManager pages) {
		super(pages);
	}
	
  public InternalPage ensurePageLoaded() {
    super.ensurePageLoaded();
    wait.until(presenceOfElementLocated(By.id("bs-example-navbar-collapse-1")));
    return this;
  }
  
  @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")
  private WebElement userProfileLink;

  //@FindBy(xpath = "//b[@class='caret']")
  //private WebElement userManagementLink;
  
  @FindBy(xpath = "//a[text()='Профіль']")
  private WebElement profilemenu;
  
  @FindBy(xpath = "//a[text()='Вихід']")
  private WebElement profilemenuexit;

  @FindBy(xpath = ".//*[@id='bs-example-navbar-collapse-1']/ul[2]/li[2]/a")
  private WebElement logoutLink;
  
  public UserProfilePage clickUserProfilePage() {
    userProfileLink.click();
    profilemenu.click();
    return pages.userProfilePage;
  }
/*
  public UserManagementPage clickUserManagementLink() {
    userManagementLink.click();
    driver.findElement(By.xpath("//a[text()='Профіль']"));
    return pages.userManagementPage;
  }
*/  
  public LoginPage clickLogoutLink() {
    logoutLink.click();
    profilemenuexit.click();    
   // wait.until(alertIsPresent()).accept();
    return pages.loginPage;
  }
}
