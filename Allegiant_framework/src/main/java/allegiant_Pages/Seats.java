package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class Seats extends Properties {
	
	public Seats() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-seats']/parent::li[@aria-current='page']")
	public static WebElement seatPage;
	
	@FindBy (xpath = "//span[text()='No thanks, skip seat selection.']")
	public static WebElement ContinueSeats;
	
	 public  void seatsPage() {	
			Assert.assertTrue(seatPage.isDisplayed());
			System.out.println("Seats page is displayed");
		}
	public void continueSeats() {
		try {
			Thread.sleep(2000);
			CommonMethods.clickElement(ContinueSeats, "Continue Seats ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	}

