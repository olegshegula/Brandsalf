package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserProfilePage extends InternalPage {

	public UserProfilePage(PageManager pages) {
		super(pages);
	}

	@FindBy(id = "Users_video")
	private WebElement uservideoField;

	@FindBy(id = "Users_fio")
	private WebElement usernameField;

	@FindBy(id = "Users_username")
	private WebElement userloginField;

	@FindBy(id = "Users_phone")
	private WebElement userphoneField;

	@FindBy(id = "Users_mail")
	private WebElement emailField;

	@FindBy(id = "Users_password")
	private WebElement passwordField;

	@FindBy(id = "Users_password2")
	private WebElement password2Field;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitButton;

	@FindBy(id = "Users_icon")
	private WebElement fileInput;

	public UserProfilePage uploadFile(String text) {
		fileInput.sendKeys(text);
		return this;
		
	}
	
	public String getUsername() {
		return userloginField.getAttribute("value");
	}

	public String getEmail() {
		return emailField.getAttribute("value");
	}

	// /////////////////////////////////////////////

	public UserProfilePage setuservideoField(String text) {
		uservideoField.clear();
		uservideoField.sendKeys(text);
		return this;
	}

	public UserProfilePage setusernameField(String text) {
		usernameField.clear();
		usernameField.sendKeys(text);
		return this;
	}

	public UserProfilePage setuserloginField(String text) {
		userloginField.clear();
		userloginField.sendKeys(text);
		return this;
	}

	public UserProfilePage setuserphoneField(String text) {
		userphoneField.clear();
		userphoneField.sendKeys(text);
		return this;
	}

	public UserProfilePage setEmailField(String text) {
		emailField.clear();
		emailField.sendKeys(text);
		return this;
	}

	public UserProfilePage setPassword(String text) {
		passwordField.clear();
		passwordField.sendKeys(text);
		return this;
	}

	public UserProfilePage setPassword2(String text) {
		password2Field.clear();
		password2Field.sendKeys(text);
		return this;
	}

	public UserCabinetPage clickSubmitButton() {
		submitButton.click();
		return pages.usercabinetPage;
	}

	public UserProfilePage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By
				.xpath("//h4[text()='Редагування профілю']")));
		return this;
	}

}
