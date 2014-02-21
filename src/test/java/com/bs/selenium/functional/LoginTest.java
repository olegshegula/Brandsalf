package com.bs.selenium.functional;

import org.testng.annotations.*;

import com.bs.selenium.model.User;
import org.testng.Assert;

//import static org.junit.Assert.*;

public class LoginTest extends com.bs.selenium.pages.TestBase {

  @BeforeMethod
  public void mayBeLogout() {
    if (app.getUserHelper().isNotLoggedIn()) {
      return;
    }
    app.getUserHelper().logout();
  }
  
  @Test
  public void testLoginOK() throws Exception {
    User user = new User().setLogin("oleg").setPassword("123qweasd");
    app.getUserHelper().loginAs(user);
    
    Assert.assertTrue(app.getUserHelper().isLoggedInAs(user));
        
  }

  @Test
  public void testLoginFailedWrongPasswd() throws Exception {
    User user = new User().setLogin("admin").setPassword("wrong");
    app.getUserHelper().loginAs(user);
    // assertFalse(app.getUserHelper().isLoggedIn());
    Assert.assertTrue(app.getUserHelper().isNotLoggedIn());
  }

  
  @Test
  public void testLoginFailedWrongLogin() throws Exception {
    User user = new User().setLogin("sdf3").setPassword("123qweasd");
    app.getUserHelper().loginAs(user);
    Assert.assertTrue(app.getUserHelper().isNotLoggedIn());
  }
  
  
  @Test
  public void testLoginFailedBlankLoginPasswd() throws Exception {
    User user = new User().setLogin("").setPassword("");
    app.getUserHelper().loginAs(user);
    Assert.assertTrue(app.getUserHelper().isNotLoggedIn());
  }
  
  @Test
  public void testLogOut() throws Exception {
    User user = new User().setLogin("oleg").setPassword("123qweasd");
    app.getUserHelper().loginAs(user);    
    app.getUserHelper().logout();
    Assert.assertTrue(app.getUserHelper().isNotLoggedIn());
  }
  
}
