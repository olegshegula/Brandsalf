package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserCabinetPage extends InternalPage{

	public UserCabinetPage(PageManager pages) {
		super(pages);
		
	}
	@FindBy(xpath = "//section/img")
	private WebElement avatarpic;
	@FindBy(id = "")
	private WebElement avatarpicside;
	
	@FindBy(xpath = "//div/h5/b")
	private WebElement usernameField;
	
	@FindBy(xpath = "//li[1]/b")
	private WebElement userphoneField;
	
	@FindBy(xpath = "//li[2]/b")
	private WebElement emailField;
	
	
	public String getEmail() {
		return emailField.getText();
	}
	public String getFIO() {
		return usernameField.getText();
	}
	
	public String getPhone() {
		return userphoneField.getText();
	}
	
	
	public String getAvatarpath() {
		System.out.println(avatarpic.getAttribute("value"));
		return avatarpic.getAttribute("value");
	}
	
	
	public UserCabinetPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By
				.xpath("//h4[text()='Особистий кабінет']")));
		return this;
	}
}
