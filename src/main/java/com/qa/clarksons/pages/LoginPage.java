package com.qa.clarksons.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import com.qa.clarkson.constants.Constants;
import com.qa.clarksons.util.ElementsUtil;

public class LoginPage {
	private WebDriver driver;
	private ElementsUtil eleUtil;
	private static final Logger log = LogManager.getLogger(SignUpPage.class);


	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementsUtil(driver);
	}

	public String getLoginPageTitle() {
		String title = eleUtil.waitForTitleContains(Constants.LOGIN_PAGE_TITLE, Constants.DEFAULT_TIME_OUT);
		log.info("login page title==>" + title);
		return title;
	}

}
