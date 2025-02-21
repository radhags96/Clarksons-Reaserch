package com.qa.clarksons.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.clarkson.constants.Constants;
import com.qa.clarkson.constants.Errors;
import com.qa.clarksons.base.BaseTest;
import com.qa.clarksons.pages.SignUpPage;

public class SignUpPageTest extends BaseTest {

	@Test
	public void signUpPageUrlTest() {
		String actURL = signUpPage.getSignUpPageUrl();
		Assert.assertEquals(actURL, Constants.LOGIN_PAGE_URL_FRACTION, Errors.URL_NOT_FOUND_ERROR);
	}
	
	@Test(dependsOnMethods = "signUpPageUrlTest")
	public void signUpInvalidDetailsTest() {
		signUpPage.signUpInvalidDetails();
		Assert.assertTrue(true, Errors.INVALID_DETAILS_FOUND_ERROR);
	}

	@Test(dependsOnMethods = "signUpInvalidDetailsTest")
	public void getSignUpDetailsTest() {
		signUpPage.signUpDetails();
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, Constants.LOGIN_PAGE_TITLE, Errors.ELEMENT_NOT_FOUND_ERROR);
	}
}
