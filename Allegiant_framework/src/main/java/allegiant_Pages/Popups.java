package allegiant_Pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonMethods;
import utils.Properties;


public class Popups extends Properties {

	public Popups() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy(xpath = "//button[text()='Accept All Cookies']")
	public static WebElement acceptCookies;
	
	@FindBy(xpath = "//button[@data-hook='overlay-merchandise_ice-pop_close']")
	public static WebElement closePagePopUp;
	
	
	
	
	public void acceptCookies() {	
		try {
			Thread.sleep(1000);
			CommonMethods.clickElement(acceptCookies, "Cookies ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void topPopup() {	
		try {
			Thread.sleep(1000);
			CommonMethods.clickElement(closePagePopUp, "Popup ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
}
