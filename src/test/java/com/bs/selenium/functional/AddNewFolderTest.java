package com.bs.selenium.functional;



import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.Folder;
import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class AddNewFolderTest extends TestBase {
	@BeforeMethod
	  public void mayBeLogout() {
	    if (app.getUserHelper().isNotLoggedIn()) {
	      return;
	    }
	    app.getUserHelper().logout();
	  }
	
	@Test
	public void testAddNewFolderforProjectOk() throws Exception {
		//Prepare data
		Folder foldername = new Folder().setName("FirstAuto");
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		
		//Add new folder to Project
		app.getUserHelper().loginAs(user);
		app.getUserHelper().createFolder(foldername);
		//Check existing of folder
		app.getNavigationHelper().openMainPage();
		Assert.assertTrue(app.getUserHelper().isFolderCreated(foldername));
		
	}
}
