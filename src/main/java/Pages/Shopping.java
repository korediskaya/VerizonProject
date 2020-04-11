package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class Shopping extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	By thePhone = By.xpath("//div[@class='NHaasTX75Bd']//following::a[@aria-label='Apple iPhone 11']");

	public Shopping(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getShoppingTitle() {

		return elementUtil.waitForGetPageTitle(Constants.Shopping_Title);
	}

	public Features doSendAndClick() {
		elementUtil.doClick(thePhone);
		return new Features(driver);

	}
}
