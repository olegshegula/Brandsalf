package com.bs.selenium.pages;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import com.bs.selenium.applogic.ApplicationManager;
import com.bs.selenium.applogic2.ApplicationManager2;
import com.bs.selenium.model.User;

public class TestBase {

	
	public static User ADMIN = new User().setLogin("admin").setPassword("111111");
	protected ApplicationManager app;

	@BeforeClass
	public void init() {
		app = new ApplicationManager2();
	}

	@AfterSuite
	public void stop() {
		app.stop();
	}

}
