package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class Hotels extends Properties {

	public Hotels() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-hotels']/parent::li[@aria-current='page']")
	public static WebElement hotelPage;
	
	@FindBy (xpath = "//a[@data-hook='hotels-page_skip']")
	public static WebElement ContinueHotels;
	
	 public  void hotelsPage() {	
			Assert.assertTrue(hotelPage.isDisplayed());
			System.out.println("Seats page is displayed");
		}
	public void continueHotel() {
		try {
			Thread.sleep(6000);
			CommonMethods.clickElement(ContinueHotels, "Continue hotels ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
}
}