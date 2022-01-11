package com.sauce.test.GoogleSearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aventstack.extentreports.Status;

public class CommonComponents extends BaseClass {

	// ArrayList<String> obtainedList = new ArrayList<String>();
	public static void launchDriver() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", UserDir + "/Resources/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		test.log(Status.PASS, "URL launched successfully");
		System.out.println("URL Launched Successfully");
	}

	@SuppressWarnings("unused")
	public static void googlePage() {
		try {
			WebElement search = Util.clickWebElementByXpath(driver, "//input[@title='Search']");
			search.clear();
			search.click();
			test.log(Status.PASS, "Navigated to Google Search Page");
			System.out.println("Navigated to Google Search Page");

			WebElement googleSearch = Util.clickWebElementByXpath(driver, "//input[@title='Search']");
			googleSearch.clear();
			//String cellData = ExcelWSheet.getRow(rowNum).getCell(colNum).getStringCellValue();
			//ExcelUtils.getCellDataString(1, 1);
			// googleSearch.sendKeys(new String[ExcelUtils.getCellDataString(1, 1)]);
			// System.out.println("\n"+s1);
			googleSearch.sendKeys(prop.getProperty("searchKeyword1"));
			WebElement buttonSearch = Util.clickWebElementByXpath(driver, "(//input[@type='submit'])[1]");
			buttonSearch.click();
			test.log(Status.PASS, "Keyword is Searched");
		} catch (org.openqa.selenium.StaleElementReferenceException e) {
			e.printStackTrace();
		}
	}

	public static void rating() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("scroll(650, 1000);");
			WebElement play = Util.clickWebElementByXpath1(driver, "//*[contains(@href,'https://play')]");
			System.out.println("App Rating: "+play.getText());
			test.log(Status.PASS, "Search Text is Available");
		} catch (Exception e) {
			test.log(Status.FAIL, "Unable to Scroll the Page");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "searchpage");
		}
	}

	public static void stringSplit() {

		try {
			WebElement rating = Util.clickWebElementByXpath1(driver, "(//*[contains(text(),'Rating')])[2]");
			String ratingValue = rating.getText();
			System.out.println("" + ratingValue);
			String myString = ratingValue;
			String[] splitString = myString.split(" ");
			for (String s : splitString) {
				System.out.println(""+s);
			}
			test.log(Status.PASS, "Application Rating is Available");
		}

		catch (Exception e) {
			test.log(Status.FAIL, "Unable to find the App Rating");
			takeScreenshotWithPath(UserDir + "/Reports/Screenshots", "App Rating");
			e.printStackTrace();
		}
	}
}
