package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class Cars extends Properties {

	public Cars() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-cars']/parent::li[@aria-current='page']")
	public static WebElement carPage;
	
	@FindBy (xpath = "//a[@data-hook='cars-page_skip']/child::span")
	public static WebElement ContinueCars;
	
	 public  void carsPage() {	
			Assert.assertTrue(carPage.isDisplayed());
			System.out.println("Cars page is displayed");
		}
	public void continueCar() {
		try {
			Thread.sleep(5000);
			CommonMethods.clickElement(ContinueCars, "Continue cars ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
