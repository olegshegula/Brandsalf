package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoadPage extends AnyPage{

	public LoadPage(PageManager pages) {
		super(pages);
		
	}

	 @FindBy(id = "cat_add")
	  private WebElement foldernameField;
	 @FindBy(xpath = "//button[@name='yt1']")
	  private WebElement add_button;
	
	 public LoadPage setfoldernameField(String text) {
		 foldernameField.clear();
		 foldernameField.sendKeys(text);
		return this;
		}
	
	public LoadPage ensurePageLoaded() {
	    super.ensurePageLoaded();
	    wait.until(presenceOfElementLocated(By.xpath("//input[@id='cat_add']")));
	    return this;
	  }

	public void clickAddButton() {
		add_button.click();
		
	}
	
	
}
