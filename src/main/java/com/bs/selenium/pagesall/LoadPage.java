package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadPage extends AnyPage {

	public LoadPage(PageManager pages) {
		super(pages);

	}

	@FindBy(id = "cat_add")
	private WebElement foldernameField;
	@FindBy(xpath = "//button[@name='yt1']")
	private WebElement add_button;
	@FindBy(id = "nextStepUploadFile")
	private WebElement nextStepUploadFileBtn;
	@FindBy(id = "Contract_sum_want")
	private WebElement SummaInputField;
	@FindBy(id = "files")
	private WebElement fileInput;
	@FindBy(xpath = "//*[@id='accordion2']//button[@type='submit']")
	private WebElement submit;

	public LoadPage uploadFile(String text) {
		fileInput.sendKeys(text);
		return this;

	}

	public void clickCreate() {
		submit.click();

	}

	public LoadPage setSummaInputField(String text) {
		SummaInputField.sendKeys(text);
		return this;
	}

	public LoadPage NextButton() {
		nextStepUploadFileBtn.click();
		return this;
	}

	public LoadPage setfoldernameField(String text) {
		foldernameField.clear();
		foldernameField.sendKeys(text);
		return this;
	}

	public LoadPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By.xpath("//*[@id='navLi1']")));
		return this;
	}

	public void clickAddButton() {
		add_button.click();

	}

}
