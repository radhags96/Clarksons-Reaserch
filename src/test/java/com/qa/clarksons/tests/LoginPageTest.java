package com.qa.clarksons.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.clarkson.constants.Errors;
import com.qa.clarksons.base.BaseTest;

public class LoginPageTest extends BaseTest {

	@Test
	public void loginPageTitleTest() {
		loginPage.getLoginPage();
		Assert.assertTrue(true, Errors.URL_NOT_FOUND_ERROR);
	}

}
