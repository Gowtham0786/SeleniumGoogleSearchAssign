package com.amazon.test.AmazonTestSuite;

import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import com.aventstack.extentreports.Status;

public class CommonComponents extends BaseClass {

	public static void launchDriver() {
		System.setProperty("webdriver.chrome.driver", UserDir + "/Resources/chromedriver.exe");

		driver = new ChromeDriver();
		driver.get(prop.getProperty("URL"));
		test.log(Status.PASS, "URL launched successfully");
	}

	@SuppressWarnings("unused")
	public static void navigateToSignIn() throws Exception {
		WebElement signInLink = Util.getWebElementByID(driver, "nav-link-accountList");
		Actions action = new Actions(driver);
		action.moveToElement(signInLink).click().build().perform();
		test.log(Status.PASS, "Hovered on SignIn link and clicked");

	}

	@SuppressWarnings("unused")
	public static void signInWithValidCredentials() throws Exception {

		try {
			WebElement email = Util.enterTextByID(driver, "ap_emssail", ExcelUtils.getCellData("Data", 0, 1),
					"emailField");
			WebElement continueButton = Util.clickWebElementByXpath(driver, "//*[@class='a-button-input']");
			WebElement password = Util.enterTextByID(driver, "ap_password", prop.getProperty("password"),
					"PasswordField");
			WebElement signInButton = Util.clickWebElementByXpath(driver, "//*[@id='signInSubmit']");
		} catch (Exception e) {
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "SignInPage");
		}

	}

	public static void verifyLoginSuccessful() {
		if (driver.findElement(By.className("nav-line-1")).getText().contains("gow")) {

		} else {

		}
	}

	@SuppressWarnings("unused")
	public static void enterSearchString() throws Exception {
		try {
			WebElement searchField = Util.enterTextByID(driver, "twotabsearchtextbox",
					ExcelUtils.getCellData("Data", 1, 2), "searchField");
			test.log(Status.PASS, "Search string enetered");
			WebElement clickSearch = Util.clickWebElementByXpath(driver, "//*[@class='nav-input' and @value='Go']");
			test.log(Status.PASS, "Search button clicked");
			Thread.sleep(5000);

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Enter Search string");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "Search String");
		}
	}

	public static void listAllProductsAndChooseOneProduct() {
		try {
			List<WebElement> products = driver.findElements(By.xpath("//h2"));
			System.out.println("Products" + products.size());
			Random ran = new Random();
			int rannum = ran.nextInt(products.size()) + 1;
			Util.scrollToElement(driver, products.get(rannum));
			test.log(Status.PASS, "Randomly Choosen Product to click is in the row of : " + rannum);
//		products.get(rannum).click();
			driver.findElement(By.xpath("(//img[@class='s-image'])[" + rannum + "]")).click();
			test.log(Status.PASS, "Clicked on Product to navigate to Details Page");
			Set<String> list = driver.getWindowHandles();
			for (String handle : list) {
				driver.switchTo().window(handle);

			}
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to Enter Search string");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "ProductsList");
		}

	}

	public static void checkout() {

		try {
			Util.clickWebElementByXpath(driver, "//input[@value='Add to Cart']");
			test.log(Status.PASS, "Clicked on Checkout button");
		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to click Checkout string");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "Checkout");
		}

		try {
			Util.clickWebElementByXpath(driver, "//*[contains(text(),'Proceed to Buy')]");
			test.log(Status.PASS, "Clicked on Proceed to Buy button");

		} catch (Exception e) {
			test.log(Status.FAIL, "Failed to click Proceed to buy button");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "ProceedToBuy");
		}

	}
}
