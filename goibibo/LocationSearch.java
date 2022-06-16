package goibibo;

import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LocationSearch extends BaseClass {
		
	@FindBy (xpath ="//span[text()='From']//parent::div")
	public static WebElement fromDestination;
	
	@FindBy (xpath ="//input[@type='text']")
	public static WebElement textFieldFromDest;
	
	@FindBy (xpath ="//ul[@id='autoSuggest-list']/li/div//p/span[text()='Chennai, India']")
	public static WebElement selectSuggestionFrom;
	
	@FindBy (xpath ="//input[@type='text']")
	public static WebElement textFieldToDest;
	
	@FindBy (xpath ="//ul[@id='autoSuggest-list']/li/div//p/span[text()='Mumbai, India']")
	public static WebElement selectSuggestionTo;
	
	@FindBy (className ="DayPicker-Day")
	public static List<WebElement> dayPicker;
	
	@FindBy (xpath ="//span[text()='Done']")
	public static WebElement doneBtnCalendar;
	
	@FindBy (xpath ="//ul/li[text()='business']")
	public static WebElement business;
	
	@FindBy (xpath ="//span[text()='SEARCH FLIGHTS']")
	public static WebElement searchFlightBtn;
	@FindBy (xpath ="//a[text()='Done']")
	public static WebElement doneBtnTravel;
	
	
	public LocationSearch(){
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void clickFromDestination() {	
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(fromDestination, " From Location ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void enterFromDestination() {	
		
			try {
				Thread.sleep(1000);
				CommonFunctions.enterKeys(textFieldFromDest, "Chennai (MAA)", " From Location ");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
	}
	
	public void selectSuggestionFrom() {
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(selectSuggestionFrom, " Suggestions ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	
	public void enterToDestination() {	
		
		try {
			Thread.sleep(1000);
			CommonFunctions.enterKeys(textFieldToDest, "Mumbai (BOM)", " To Location ");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}	
}

	public void selectSuggestionTo() {
	try {
		Thread.sleep(1000);
		CommonFunctions.clickElement(selectSuggestionTo, " Suggestions ");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
	
	}
	
	public void selectDate() {
		
		List<WebElement> dates=dayPicker;
		int count=dayPicker.size();
		System.out.println(count);
		for(int i=0; i<count;i++) {
			String text=dayPicker.get(i).getText();
			if(text.contains("31")) {
				
				dayPicker.get(i).click();
				break;				
			}
		}		
		try {
			CommonFunctions.clickElement(doneBtnCalendar, " Done button ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void selectBusinessClass() {
		
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(business, " Business Class ");
			Thread.sleep(1000);
			CommonFunctions.clickElement(doneBtnTravel, " Done ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}
	
	public void clickSearchFlights() {
		
		try {
			Thread.sleep(1000);
			CommonFunctions.clickElement(searchFlightBtn, " Search Flights ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
}