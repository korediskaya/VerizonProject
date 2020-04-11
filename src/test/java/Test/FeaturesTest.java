package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.Features;
import Pages.Shopping;
import Pages.VerizonMainPage;
import Utilities.Constants;

public class FeaturesTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	Shopping shopping;
	Features features;

	@BeforeMethod

	public void setUp() {

		basePage = new BasePage(); // Baslangic noktasi
		prop = basePage.initialize_properties(); // 1.asama
		driver = basePage.initialize_driver(prop); // 2.asama
		verizonMainPage = new VerizonMainPage(driver); // 3.asama
		shopping = new Shopping(driver);// 4.asama
		features = new Features(driver);// 5.asama
		shopping = verizonMainPage.doSendAndClick();
		features = shopping.doSendAndClick();
	}

	@Test(priority = 1,  enabled=true)

	public void getTitle() {
		String title = features.getFeaturesTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Features_Title, "Features title is incorrect");
	}

	@Test(priority = 2)

	public void doSendAndClik() {
		features.doSendAndClick();
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}