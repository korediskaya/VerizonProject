package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class VerizonMainPage extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By phones = By.xpath("//button[contains(text(),'Phones list')]");
	By smartPhones = By.cssSelector("#thirdLevel00");

	public VerizonMainPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getVerizonTitle() {

		return elementUtil.waitForGetPageTitle(Constants.Verizon_Title);
	}

	public Shopping doSendAndClick() {
		elementUtil.MovetoElement(driver, phones);
		elementUtil.doClick(smartPhones);

		return new Shopping(driver);
	}

}
