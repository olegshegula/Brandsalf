package com.bs.selenium.applogic;

import com.bs.selenium.model.Folder;
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
	void createFolderForProject(Folder foldername);
	boolean isFolderCreated(Folder foldername);
	void createFolderForTemplate(Folder foldername);
	void createFolderForOffers(Folder foldername);
	boolean isToggled();
	void avatarUpload();
}
