package allegiant_Pages;


import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.CommonMethods;
import utils.Properties;

public class TravelerDetails extends Properties {

	public TravelerDetails() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	@FindBy (xpath = "//span[@data-hook='flights-breadcrumb_item-travelers']/parent::li[@aria-current='page']")
	public static WebElement travelerPage;
	
	@FindBy(xpath = "//input[@placeholder='First Name']")
	public static WebElement T1FirstName;
	
	@FindBy(xpath = "//input[@placeholder='Last Name']")
	public static WebElement T1LastName;
	
	@FindBy(xpath = "//input[@placeholder='Year']")
	public static WebElement T1Year;
	
	@FindBy(xpath = "//input[@placeholder='Email Address']")
	public static WebElement T1EmailAddress;
	
	@FindBy(xpath = "//label[@data-hook='travelers-form_adults_0_gender_MALE']")
	public static WebElement T1Gender;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_0_dob-month']")
	public static WebElement T1Month;
	
	@FindBy(xpath = "//div[text()='January']")
	public static WebElement T1SelectMonth;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_0_dob-day']")
	public static WebElement T1Day;
	
	@FindBy(xpath = "//div[text()='3']")
	public static WebElement T1SelectDay;
	
	
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_1_first-name']")
	public static WebElement T2FirstName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_1_last-name']")
	public static WebElement T2LastName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_1_dob-year']")
	public static WebElement T2Year;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_1_email']")
	public static WebElement T2EmailAddress;
	
	@FindBy(xpath = "//label[@data-hook='travelers-form_adults_1_gender_MALE']")
	public static WebElement T2Gender;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_1_dob-month']")
	public static WebElement T2Month;
	
	@FindBy(xpath = "//div[text()='March']")
	public static WebElement T2SelectMonth;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_1_dob-day']")
	public static WebElement T2Day;
	
	@FindBy(xpath = "//div[text()='7']")
	public static WebElement T2SelectDay;
	
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_2_first-name']")
	public static WebElement T3FirstName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_2_last-name']")
	public static WebElement T3LastName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_2_dob-year']")
	public static WebElement T3Year;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_2_email']")
	public static WebElement T3EmailAddress;
	
	@FindBy(xpath = "//label[@data-hook='travelers-form_adults_2_gender_MALE']")
	public static WebElement T3Gender;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_2_dob-month']")
	public static WebElement T3Month;
	
	@FindBy(xpath = "//div[text()='July']")
	public static WebElement T3SelectMonth;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_2_dob-day']")
	public static WebElement T3Day;
	
	@FindBy(xpath = "//div[text()='20']")
	public static WebElement T3SelectDay;
	
	
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_3_first-name']")
	public static WebElement T4FirstName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_3_last-name']")
	public static WebElement T4LastName;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_3_dob-year']")
	public static WebElement T4Year;
	
	@FindBy(xpath = "//input[@data-hook='travelers-form_adults_3_email']")
	public static WebElement T4EmailAddress;
	
	@FindBy(xpath = "//label[@data-hook='travelers-form_adults_3_gender_MALE']")
	public static WebElement T4Gender;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_3_dob-month']")
	public static WebElement T4Month;
	
	@FindBy(xpath = "//div[text()='September']")
	public static WebElement T4SelectMonth;
	
	@FindBy(xpath = "//div[@data-hook='travelers-form_adults_3_dob-day']")
	public static WebElement T4Day;
	
	@FindBy(xpath = "//div[text()='13']")
	public static WebElement T4SelectDay;
	
	@FindBy (xpath = "//span[text()='Continue']")
	public static WebElement ContinueTravel;
	
	
    public  void travelerDetailsPage() {
		Assert.assertTrue(travelerPage.isDisplayed());
		System.out.println("Traveler Details page is displayed");
	}
    
	public void gettravellerDetails1(String fName, String lName, String dob, String email) {
		
		try {
			CommonMethods.enterKeys(T1FirstName, fName, "Traveller 1 First Name ");
			CommonMethods.enterKeys(T1LastName, lName, "Traveller 1 Last Name ");
			CommonMethods.enterKeys(T1Year, dob, "Traveller 1 Dob ");
			CommonMethods.enterKeys(T1EmailAddress, email, "Traveller 1 Email ");
			
			try {
				CommonMethods.clickElement(T1Gender, "Traveller 1 Gender ");
				CommonMethods.clickElement(T1Month,"Traveller 1 Month of birth ");
				CommonMethods.clickElement(T1SelectMonth, "Traveller 1 Month of birth selected and ");
				CommonMethods.clickElement(T1Day,"Traveller 1 Birth date ");
				CommonMethods.clickElement(T1SelectDay, "Traveller 1 Birth date selected and ");
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
public void gettravellerDetails2(String fName, String lName, String dob, String email) {
		
		try {
			CommonMethods.enterKeys(T2FirstName, fName, "Traveller 2 First Name ");
			CommonMethods.enterKeys(T2LastName, lName, "Traveller 2 Last Name ");
			CommonMethods.enterKeys(T2Year,  dob, "Traveller 2 Dob");
			CommonMethods.enterKeys(T2EmailAddress, email, "Traveller 2 Email ");
			
			try {
				CommonMethods.clickElement(T2Gender, "Traveller 2 Gender ");
				CommonMethods.clickElement(T2Month,"Traveller 2 Month of birth ");
				CommonMethods.clickElement(T2SelectMonth, "Traveller 2 Month of birth selected and ");
				CommonMethods.clickElement(T2Day,"Traveller 2 Birth date ");
				CommonMethods.clickElement(T2SelectDay, "Traveller 2 Birth date selected and ");
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void gettravellerDetails3(String fName, String lName, String dob, String email) {
	
	try {
		CommonMethods.enterKeys(T3FirstName, fName, "Traveller 3 First Name ");
		CommonMethods.enterKeys(T3LastName, lName, "Traveller 3 Last Name ");
		CommonMethods.enterKeys(T3Year, dob, "Traveller 3 Dob");
		CommonMethods.enterKeys(T3EmailAddress, email, "Traveller 3 Email ");
		
		try {
			CommonMethods.clickElement(T3Gender, "Traveller 3 Gender ");
			CommonMethods.clickElement(T3Month,"Traveller 3 Month of birth ");
			CommonMethods.clickElement(T3SelectMonth, "Traveller 3 Month of birth selected and ");
			CommonMethods.clickElement(T3Day,"Traveller 3 Birth date ");
			CommonMethods.clickElement(T3SelectDay, "Traveller 3 Birth date selected and ");
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}

public void gettravellerDetails4(String fName, String lName, String dob, String email) {
	
	try {
		CommonMethods.enterKeys(T4FirstName, fName, "Traveller 4 First Name ");
		CommonMethods.enterKeys(T4LastName, lName, "Traveller 4 Last Name ");
		CommonMethods.enterKeys(T4Year, dob, "Traveller 4  Year");
		CommonMethods.enterKeys(T4EmailAddress, email, "Traveller 4 Email ");
		
		try {
			CommonMethods.clickElement(T4Gender, "Traveller 4 Gender ");
			CommonMethods.clickElement(T4Month,"Traveller 4 Month of birth ");
			CommonMethods.clickElement(T4SelectMonth, "Traveller 4 Month of birth selected and ");
			CommonMethods.clickElement(T4Day,"Traveller 4 Birth date  ");
			CommonMethods.clickElement(T4SelectDay,"Traveller 4 Birth date selected and ");
			
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	} catch (IOException e) {
		e.printStackTrace();
	}
}
	public void continueTravel() {
		try {
			CommonMethods.clickElement(ContinueTravel, "Continue Travel");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
