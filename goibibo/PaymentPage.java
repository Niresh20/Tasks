package goibibo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class PaymentPage extends BaseClass {
	
	@FindBy (id = "tab_card")
	public static WebElement clickCard;

	@FindBy (xpath = "//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardnumber']")
	public static WebElement cardDetails;
	
	@FindBy (xpath = "//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='ccname']")
	public static WebElement cardName;
	
	@FindBy (xpath = "//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardExpiry']")
	public static WebElement cardExpiry;
	
	@FindBy (xpath = "//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardCVV']")
	public static WebElement cardCvv;
	
	@FindBy (xpath = "//p[text()='Address Line']/following-sibling::input")
	public static WebElement addressLine;
	
	@FindBy (xpath = "//p[text()='Zip Code']/following-sibling::input")
	public static WebElement zipCode;
	
	@FindBy (xpath = "//p[text()='City']/following-sibling::input")
	public static WebElement city;
	
	@FindBy (xpath = "//p[text()='State']/following-sibling::input")
	public static WebElement state;
	
	@FindBy (xpath = "(//div[@class='width100']/div/div/button)[1]")
	public static WebElement payButton;
	
	public PaymentPage() {
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
		
	}
	
	public void enterPaymentDetails() {
			try {
				CommonFunctions.clickElement(clickCard, " card payment  ");
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			CommonFunctions.enterKeys(cardDetails, "5555555555554444", " Credit card number  ");
			CommonFunctions.enterKeys(cardName, "Test", " Credit card name  ");
			CommonFunctions.enterKeys(cardExpiry, "0226", " Credit card expiry  ");
			CommonFunctions.enterKeys(cardCvv, "000", " Credit card cvv ");

	}
		
	public void enterAddressDetails() {
			
			CommonFunctions.enterKeys(addressLine, "811 test chennai", " Address  ");
			CommonFunctions.enterKeys(zipCode, "600000", " Zipcode  ");
			CommonFunctions.enterKeys(city, "Chennai", " City ");
			CommonFunctions.enterKeys(state, "Tamilnadu", " State ");
	}
	
	public void clickPayNow() {
		
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(payButton, " Pay Now Button ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}
