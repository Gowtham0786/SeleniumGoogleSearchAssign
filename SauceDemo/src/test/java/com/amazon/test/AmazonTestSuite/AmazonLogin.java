package com.amazon.test.AmazonTestSuite;

import org.testng.annotations.Test;

public class AmazonLogin extends CommonComponents {
  
	
@Test
  public void testScenario1() throws Exception {
	test = extent.createTest("AmazonLogin", "");
	launchDriver();
	navigateToSignIn();
	signInWithValidCredentials();
	verifyLoginSuccessful();
	  
  }
}

