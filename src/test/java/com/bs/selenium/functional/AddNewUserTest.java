package com.bs.selenium.functional;

import org.testng.annotations.*;

import com.bs.selenium.model.User;

import static org.junit.Assert.*;

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
