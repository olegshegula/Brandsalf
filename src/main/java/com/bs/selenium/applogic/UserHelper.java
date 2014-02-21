package com.bs.selenium.applogic;

import com.bs.selenium.model.User;

public interface UserHelper {

	void loginAs(User user);
	void logout();
	boolean isLoggedIn();
	boolean isLoggedInAs(User user);
	boolean isNotLoggedIn();
	void edituserprofile(User user);	
	int getNumbersofLayoutBags() throws Exception;	
	boolean hasNoLayoutBugs() throws Exception;
}