package com.bs.selenium.applogic2;

import org.openqa.selenium.WebDriver;

import com.bs.selenium.applogic.ApplicationManager;
import com.bs.selenium.applogic.FilmHelper;
import com.bs.selenium.applogic.NavigationHelper;
import com.bs.selenium.applogic.UserHelper;
import com.bs.selenium.util.Browser;
import com.bs.selenium.util.PropertyLoader;
import com.bs.selenium.webdriver.WebDriverFactory;

public class ApplicationManager2 implements ApplicationManager {

	private UserHelper userHelper;
	private FilmHelper filmHelper;
	private NavigationHelper navHelper;
	private ClickLinkHelper2 clicklinkHelper;
	
	private WebDriver driver;
	private String baseUrl;

	public ApplicationManager2() {
		baseUrl = PropertyLoader.loadProperty("site.url");
		String gridHubUrl = PropertyLoader.loadProperty("grid2.hub");

		Browser browser = new Browser();
		browser.setName(PropertyLoader.loadProperty("browser.name"));
		browser.setVersion(PropertyLoader.loadProperty("browser.version"));
		browser.setPlatform(PropertyLoader.loadProperty("browser.platform"));

		String username = PropertyLoader.loadProperty("user.username");
		String password = PropertyLoader.loadProperty("user.password");

		driver = WebDriverFactory.getInstance(gridHubUrl, browser, username,
				password);
		driver.manage().deleteAllCookies();
		// driver.manage().window().maximize();
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		userHelper = new UserHelper2(this);
		filmHelper = new FilmHelper2(this);
		navHelper = new NavigationHelper2(this);
		clicklinkHelper = new ClickLinkHelper2(this);

		getNavigationHelper().openMainPage();
	}

	@Override
	public ClickLinkHelper2 getClickLinkHelper() {
		return clicklinkHelper;
	}
	
	@Override
	public UserHelper getUserHelper() {
		return userHelper;
	}

	@Override
	public FilmHelper getFilmHelper() {
		return filmHelper;
	}

	@Override
	public NavigationHelper getNavigationHelper() {
		return navHelper;
	}

	protected WebDriver getWebDriver() {
		return driver;
	}

	protected String getBaseUrl() {
		return baseUrl;
	}

	@Override
	public void stop() {
		if (driver != null) {
			driver.quit();
		}
	}
}
