package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class SelectFlights extends Properties {
	
	public SelectFlights() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	
	@FindBy (xpath = "//span[text()='Continue']")
	public static WebElement continueBooking;
	
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-flights']/parent::li[@aria-current='page']")
	public static WebElement flightPage;
	
	public  void flightPage() {
		
		Assert.assertTrue(flightPage.isDisplayed());
		System.out.println("Flight page is displayed");
	}
	
	public void continueBooking() {
		try {
			CommonMethods.clickElement(continueBooking, "Continue Booking ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
