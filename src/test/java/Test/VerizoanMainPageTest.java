package Test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BasePage.BasePage;
import Pages.VerizonMainPage;
import Utilities.Constants;

public class VerizoanMainPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	VerizonMainPage verizonMainPage;

	@BeforeMethod

	public void setUp() throws InterruptedException {

		basePage = new BasePage(); // Baslangic noktasi
		prop = basePage.initialize_properties(); // 1.asama
		driver = basePage.initialize_driver(prop); // 2.asama
		verizonMainPage = new VerizonMainPage(driver); // 3.asama

	}

	@Test(priority = 1, description="Main Page Title")
	
	public void getTitle() {

		String title = verizonMainPage.getVerizonTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.Verizon_Title, "Verizon Main Page title is incorrect");
	}

	@Test(priority = 2,description="Main page Mouse over and clik")
	public void doSendAndClik() {

		verizonMainPage.doSendAndClick();
	}

	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
