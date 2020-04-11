package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.Shopping;
import Pages.VerizonMainPage;
import Utilities.Constants;

public class ShoppingTest {
	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;
	Shopping shopping;

	@BeforeMethod

	public void setUp() {

		basePage = new BasePage(); // Baslangic noktasi
		prop = basePage.initialize_properties(); // 1.asama
		driver = basePage.initialize_driver(prop); // 2.asama
		verizonMainPage = new VerizonMainPage(driver); // 3.asama
		shopping = verizonMainPage.doSendAndClick();
	}

	@Test(priority = 1,description="Shopping Page Title")

	public void getTitle() {

		String title = shopping.getShoppingTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Shopping_Title, "Shopping title is incorrect");

	}

	@Test(priority = 2, description="IPhone Selection")
	public void doSendAndClik() {
		shopping.doSendAndClick();
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
