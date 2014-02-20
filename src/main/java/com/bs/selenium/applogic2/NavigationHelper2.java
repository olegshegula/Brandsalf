package com.bs.selenium.applogic2;

import org.openqa.selenium.By;

import com.bs.selenium.applogic.NavigationHelper;

public class NavigationHelper2 extends DriverBasedHelper implements NavigationHelper {

  private String baseUrl;

  public NavigationHelper2(ApplicationManager2 manager) {
    super(manager.getWebDriver());
    this.baseUrl = manager.getBaseUrl();
  }
  
  @Override
  public void openMainPage() {
    driver.get(baseUrl);
  }

  @Override
  public void openRelativeUrl(String url) {
    driver.get(baseUrl + url);
  }
  
  @Override
  public void gotoUserProfilePage() {
    pages.internalPage.ensurePageLoaded().clickUserProfilePage();    
  }

  @Override
  public void gotoUserManagementPage() {
  //  pages.internalPage.ensurePageLoaded().clickUserManagementLink();         
    
  }

}
