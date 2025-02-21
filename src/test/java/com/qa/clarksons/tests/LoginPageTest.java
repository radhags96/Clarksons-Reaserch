package com.qa.clarksons.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.clarkson.constants.Constants;
import com.qa.clarkson.constants.Errors;
import com.qa.clarksons.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE, Errors.ELEMENT_NOT_FOUND_ERROR);
	}

}
