package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;

public class SelectBundle extends Properties {

	public SelectBundle() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-bundles']/parent::li[@aria-current='page']")
	public static WebElement bundlePage;
	
	@FindBy (xpath = "//span[text()='Continue']")
	public static WebElement ContinueBundle;
	
        public  void bundlePage() {	
		Assert.assertTrue(bundlePage.isDisplayed());
		System.out.println("Bundle page is displayed");
	}
		public void continueBundle() {
		try {
			Thread.sleep(2000);
			CommonMethods.clickElement(ContinueBundle, "Continue Bundle ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
