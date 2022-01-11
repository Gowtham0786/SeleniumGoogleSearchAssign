package com.amazon.test.AmazonTestSuite;

import org.testng.annotations.Test;

public class AmazonProductsSearch extends CommonComponents {

	@Test
	public void testScenario1() throws Exception {
		test = extent.createTest("AmazonProductsSearch", "");
		launchDriver();
		navigateToSignIn();
		signInWithValidCredentials();
		verifyLoginSuccessful();
		enterSearchString();
		listAllProductsAndChooseOneProduct();
		checkout();

	}
}
