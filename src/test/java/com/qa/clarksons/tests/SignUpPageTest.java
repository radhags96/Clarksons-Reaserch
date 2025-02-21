package com.qa.clarksons.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.clarkson.constants.Constants;
import com.qa.clarkson.constants.Errors;
import com.qa.clarksons.base.BaseTest;

public class SignUpPageTest extends BaseTest {

	@Test
	public void signUpPageUrlTest() {
		
		String actURL = signUpPage.getSignUpPageUrl();
		Assert.assertEquals(actURL, Constants.SIGNUP_PAGE_URL_FRACTION, Errors.URL_NOT_FOUND_ERROR);
	}
	
	@Test(dependsOnMethods = "signUpPageUrlTest")
	public void signUpwithInvalidDetailsTest() {
		signUpPage.signUpInvalidDetails();
		Assert.assertTrue(true);
	}

	@Test(dependsOnMethods = "signUpPageUrlTest")
	public void signUpwithValidDetailsTest() {
		signUpPage.signUpDetails();
		loginPage.getLoginPage();
		Assert.assertTrue(true);
	}
}
