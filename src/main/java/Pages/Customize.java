package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class Customize extends BasePage {
	WebDriver driver;
	ElementUtil elementUtil;

	// By NoBtn = By.xpath("//input[@id='radio_none']");
	By NoBtn = By.xpath("//div[@id='none']//div[@class='flex']//div//p[@class='body fontDisplayBold headerText']");
	By NextBtn = By.xpath("//button[@aria-label='Next']");
	By tradeIn = By.xpath("//button[@aria-label='No I would not like to trade in']");
	By declineBtn1 = By.xpath("//button[@id='declineDeviceSelectProtecionBtn']");
	By declineBtn2 = By.xpath("//button[@class='secondary button cancelProtectionButton']");

	public Customize(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getShoppingTitle() {

		return elementUtil.waitForGetPageTitle(Constants.Customize_Title);
	}

	public void doSendAndClick() {
		elementUtil.doClick(NoBtn);
		elementUtil.doClick(NextBtn);
		elementUtil.doClick(tradeIn);
		elementUtil.doClick(declineBtn1);
		elementUtil.doClick(declineBtn2);
	}

}
