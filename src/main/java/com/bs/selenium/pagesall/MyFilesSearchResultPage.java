package com.bs.selenium.pagesall;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyFilesSearchResultPage extends AnyPage {

	public MyFilesSearchResultPage(PageManager pages) {
		super(pages);

	}

	public MyFilesSearchResultPage ensurePageLoaded() {
		super.ensurePageLoaded();
		wait.until(presenceOfElementLocated(By
				.xpath("//table")));
		return this;
	}

	public List<String> getsearchResultTable() {
		List<String> actualLinkList = new ArrayList<String>();
		List<WebElement> linkList = pages.getWebDriver().findElements(
				By.xpath("//td[2]/a"));

		for (WebElement element : linkList) {
			actualLinkList.add(element.getText());
			System.out.println(element.getText());
		}

		return actualLinkList;

	}


}
