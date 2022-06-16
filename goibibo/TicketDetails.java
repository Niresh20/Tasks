package goibibo;

import java.io.IOException;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class TicketDetails extends BaseClass{
	
@FindBy (xpath = "//button[text()='Insure for ₹']")
public static WebElement insurance;

@FindBy(xpath = "//span[text()='Cab from Mumbai airport']")
public static WebElement cab;

@FindBy(xpath = "//input[@name='givenname']/parent::div//preceding-sibling::div/select")
public static WebElement title;

@FindBy(xpath = "//input[@name='givenname']")
public static WebElement name;

@FindBy(xpath = "//input[@name='email']")
public static WebElement email;

@FindBy(xpath = "//input[@name='mobile']")
public static WebElement mobile;

@FindBy(xpath = "//button[text()='Proceed']")
public static WebElement proceed;

@FindBy(xpath = "//button[text()='Proceed To Payment']")
public static WebElement proceedPayment;


public TicketDetails() {
	PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30),this);
}

public void selectInsurance() {
	try {
		Thread.sleep(1000);
		CommonFunctions.clickElement(insurance, "Insured");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
public void selectCab() {
	try {
		Thread.sleep(1000);
		CommonFunctions.clickElement(cab, "CabfromMumbai");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
public void selectTitle() {
	CommonFunctions.selectElement(title, "index", "1", " salutation ");
}

public void enterName() {
	CommonFunctions.enterKeys(name, "Niresh", "firstname");
}

public void enterEmail() {
	CommonFunctions.enterKeys(email, "test@gmail.com", "Email");
}
public void enterMobile() {
	CommonFunctions.enterKeys(mobile, "9499962740", "MobileNo");
}

public void proceed() {
	try {
		Thread.sleep(1000);
		CommonFunctions.clickElement(proceed, " Proceed ");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}

public void proceedPayment() {
	try {
		Thread.sleep(1000);
		CommonFunctions.clickElement(proceedPayment, " Proceed Payment ");
	} catch (IOException e) {
		e.printStackTrace();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
}
}
