package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class Bags extends Properties {
	
	public Bags() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-bags']/parent::li[@aria-current='page']")
	public static WebElement bagPage;
	@FindBy (xpath = "//form[@class='bg-white']/div/child::div[7]/div/div/button")
	public static WebElement ContinueBags;
	@FindBy (xpath = "//form[@class='bg-white']/div/child::div[7]/div/div/child::div/descendant::button/span[text()='Continue']")
	public static WebElement ContinueBagsPopup;
	
	public  void bagsPage() {	
		Assert.assertTrue(bagPage.isDisplayed());
		System.out.println("Bags page is displayed");
	}
	public void continueBags() {
		try {
			Thread.sleep(2000);
			CommonMethods.clickElement(ContinueBags, "Continue Seats ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void continueBagsPopUp() {
		try {
			Thread.sleep(2000);
			CommonMethods.clickElement(ContinueBagsPopup, "Continue bags popup");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
