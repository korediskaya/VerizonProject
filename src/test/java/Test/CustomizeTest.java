package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.Customize;
import Pages.Features;
import Pages.Shopping;
import Pages.VerizonMainPage;
import Utilities.Constants;

public class CustomizeTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	Shopping shopping;
	Features features;
	Customize customize;

	@BeforeMethod

	public void setUp() {

		basePage = new BasePage(); // Baslangic noktasi
		prop = basePage.initialize_properties(); // 1.asama
		driver = basePage.initialize_driver(prop); // 2.asama
		verizonMainPage = new VerizonMainPage(driver); // 3.asama
		shopping = new Shopping(driver);// 4.asama
		features = new Features(driver);// 5.asama
		customize = new Customize(driver);// 6.asama
		shopping = verizonMainPage.doSendAndClick();
		features = shopping.doSendAndClick();
		customize = features.doSendAndClick();

	}

	@Test(priority = 1)

	public void getTitle() {

		String title = customize.getShoppingTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Customize_Title, "Customize title is incorrect");

	}
 @Test(priority = 2, enabled = true)

	public void doSendAndClik() {
		customize.doSendAndClick();
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
