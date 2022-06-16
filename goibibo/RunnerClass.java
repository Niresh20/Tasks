package goibibo;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RunnerClass extends BaseClass {

	@BeforeMethod
	public void openbrowser() throws IOException {
		new Browser().setURL(browser, url);
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("D://screenshot.png)"));
		
	}
	
	@Test
	public void runtest1(){
		CommonFunctions.validateTitle("Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off");
		new LocationSearch().clickFromDestination();
		new LocationSearch().enterFromDestination();
		new LocationSearch().selectSuggestionFrom();
		new LocationSearch().enterToDestination();
		new LocationSearch().selectSuggestionTo();
		new LocationSearch().selectDate();
		new LocationSearch().selectBusinessClass();
		new LocationSearch().clickSearchFlights();
		
		CommonFunctions.validateTitle("Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo");
		
		new BookingPage().clickBook();		
		
		new TicketDetails().selectInsurance();
		new TicketDetails().selectCab();
		new TicketDetails().selectTitle();
		new TicketDetails().enterName();
		new TicketDetails().enterEmail();
		new TicketDetails().enterMobile();
		new TicketDetails().proceed();
		new TicketDetails().proceedPayment();
		
		CommonFunctions.validateTitle("Book Cheap Flights, Air Tickets, Hotels, Bus & Holiday Package at Goibibo");
		
		new PaymentPage().enterPaymentDetails();
		new PaymentPage().enterAddressDetails();
		new PaymentPage().clickPayNow();
		
	}
}
