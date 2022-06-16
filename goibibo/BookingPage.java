package goibibo;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class BookingPage extends BaseClass {
	
	@FindBy(xpath="//button[text()='BOOK']")
	public static WebElement bookBtn;
	
	public BookingPage() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,30), this);
	}
	
	public void clickBook() {
		
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(bookBtn, "Book Button");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
