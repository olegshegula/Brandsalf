package com.bs.selenium.applogic2;

import com.bs.selenium.applogic.ClickLinkHelper;

public class ClickLinkHelper2 extends DriverBasedHelper implements ClickLinkHelper {
	

	public ClickLinkHelper2(ApplicationManager2 manager) {
		super(manager.getWebDriver());
		
	}

	@Override
	public void clickOnFileCategory() {
		pages.internalPage.clickCategorytLink();
		
	}

	@Override
	public void clickOnContent() {
		pages.internalPage.clickContentLink();
		
	}

}
