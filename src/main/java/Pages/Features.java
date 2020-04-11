package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import BasePage.BasePage;
import Utilities.Constants;
import Utilities.ElementUtil;

public class Features extends BasePage {

	WebDriver driver;
	ElementUtil elementUtil;

	 By color = By.xpath("//div[@id='tile_container']/div/div[2]/div/div/div[2]/div/div/div/div/div[6]/div");

	// By.xpath("//div[contains(@class,'positionRelative color-swatch-selected
	// borderRadius50 cursorPointer')]");
	By capacity = By.xpath("//p[text()[contains(.,'128')]]");
	By paymentMethods = By.xpath("//div[contains(@class, 'contractName') and text()=' Retail price']");//UZUN OLMUS
	By nextBtn = By.xpath("//button[@analyticstrack='Continue-Btn-PDP']"); //
	By zipCode = By.xpath("//input[@id='zipcode']");
	By confirmBtn = By.xpath("//button[@class='defaultPrimaryCTA ']");
	By newCustomer = By.xpath("//button[@aria-label='New Customer']");

	public Features(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}

	public String getFeaturesTitle() {
		return elementUtil.waitForGetPageTitle(Constants.Features_Title);
	}

	public Customize doSendAndClick() {
		
		elementUtil.doClick(color);
		elementUtil.doClick(capacity);
		elementUtil.doClick(paymentMethods);
		elementUtil.doClick(nextBtn);
		elementUtil.doSendKeys(zipCode, "10466");
		elementUtil.doClick(confirmBtn);
		elementUtil.doClick(newCustomer);
		
		return new Customize(driver);
	}

}