package com.bs.selenium.functional;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.bs.selenium.model.User;
import com.bs.selenium.pages.TestBase;

public class PullDownMenuTest extends TestBase {
	@BeforeMethod
	public void mayBeLogout() {
		if (app.getUserHelper().isNotLoggedIn()) {
			return;
		}
		app.getUserHelper().logout();
	}

	@Test
	public void testPullDownContent() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);

		Assert.assertTrue(app.getUserHelper().isPullDownMenuContentCorrect(
				"Мої пропозиції", "Мої контракти", "Мої файли", "Проекти",
				"Шаблони"));

	}

	@Test
	public void testPullDownFileCateogory() throws Exception {
		User user = new User().setLogin("oleg").setPassword("123qweasd");
		app.getUserHelper().loginAs(user);

		app.getClickLinkHelper().clickOnFileCategory();
		Assert.assertTrue(app.getUserHelper().isPullDownMenuCategoryFileCorrect(
				"Бізнес пропозиції", "Контракти", "Проекти", "Пропозиції",
				"Шаблони"));

	}
}
