package com.bs.selenium.functional;

import org.testng.annotations.*;



public class AddNewUserTest extends com.bs.selenium.pages.TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testCreateNewUser() throws Exception {
   
  } 
  
}
