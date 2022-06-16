package allegiant_Pages;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class PaymentPage extends Properties {


	public PaymentPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-payment']/parent::li[@aria-current='page']")
	public static WebElement paymentPage;
	
	@FindBy(xpath = "//button[@data-hook='payment-page_ice-popup_close']")
	public static WebElement paymentPagePopUp;
	
	@FindBy(xpath = "//input[@name='card-number']")
	public static WebElement CardNumber;
	
	@FindBy(xpath = "//div[@data-hook='payment-page_card-expiration-month']")
	public static WebElement MonthField;
	
	@FindBy(xpath = "//div[text()='February']")
	public static WebElement CardExpiryMonth;
	
	@FindBy(xpath = "//div[@data-hook='payment-page_card-expiration-year']")
	public static WebElement YearField;
	
	@FindBy(xpath = "//div[text()='2026']")
	public static WebElement CardExpiryYear;
	
	@FindBy(xpath = "//input[@name='card-cvv']")
	public static WebElement CardCvv;
	
	@FindBy(xpath = "//input[@placeholder='Street Address']")
	public static WebElement Address;
	
	@FindBy(xpath = "//input[@placeholder='City']")
	public static WebElement City;
	
	@FindBy(xpath = "//div[@data-hook='payment-page_state']")
	public static WebElement States;
	
	@FindBy(xpath = "//div[text()='California']")
	public static WebElement SelectStates;
	
	@FindBy(xpath = "//input[@placeholder='Zip Code']")
	public static WebElement ZipCode;
	
	@FindBy(xpath = "//label[@data-hook='payment_terms-and-conditions-checkbox_label']")
	public static WebElement TermsAndConditions;
	
	public void paymentPopup() {	
		try {
			Thread.sleep(5000);
			CommonMethods.clickElement(paymentPagePopUp, "Payment popup ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	 public  void paymentsPage() {	
			Assert.assertTrue(paymentPage.isDisplayed());
			System.out.println("Payments page is displayed");
		}
	 
	
	public void cardDetails(String cardno, String cvvno) {	
		try {
			Thread.sleep(5000);
			CommonMethods.clickElement(CardNumber, "Card No");
			CommonMethods.enterKeys(CardNumber, cardno, "Card Number ");
			CommonMethods.clickElement(CardCvv, "Cvv");
			CommonMethods.enterKeys(CardCvv, cvvno, "Cvv Number ");
			CommonMethods.clickElement(MonthField, "Month Field");
			CommonMethods.clickElement(CardExpiryMonth, "Expiry Month");
			CommonMethods.clickElement(YearField, "YearField");
			CommonMethods.clickElement(CardExpiryYear, "Expiry Year");
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void billingAddress(String sAdress, String city, String zipcode) {	
		try {
			Thread.sleep(5000);
			CommonMethods.clickElement(Address, "Street Address");
			CommonMethods.enterKeys(Address, sAdress,"Street Address");
			CommonMethods.clickElement(City, "City");
			CommonMethods.enterKeys(City, city, "City");
			CommonMethods.clickElement(States, "State");
			CommonMethods.clickElement(SelectStates, "Select States");
			CommonMethods.enterKeys(ZipCode, zipcode, "Zipcode");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void continueTermsAndConditions() {
		try {
			Thread.sleep(2000);
			CommonMethods.clickElement(TermsAndConditions, "Terms and Conditions");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
