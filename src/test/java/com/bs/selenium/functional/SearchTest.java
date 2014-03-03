package com.bs.selenium.functional;

import org.testng.annotations.BeforeMethod;

import com.bs.selenium.pages.TestBase;

public class SearchTest extends TestBase {
	 @BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	  
}
