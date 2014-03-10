package com.bs.selenium.functional;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.Files;
import com.bs.selenium.model.Money;
import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class LoadNewFileTest extends TestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testAddNewContractOK() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);
		
		
		Files filename = new Files().setName("NewContract.xlsx");
		Files path = new Files().setPath("c:\\testfile.docx");
		Money desire = new Money().setAmount("50");

		
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openRelativeUrl("user/create/3");
		app.getUserHelper().LoadDocument(desire, filename, path);
		
	}
}
