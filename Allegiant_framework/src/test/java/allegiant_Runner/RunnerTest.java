package allegiant_Runner;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import allegiant_Pages.Bags;
import allegiant_Pages.Cars;
import allegiant_Pages.Hotels;
import allegiant_Pages.LocationSearch;
import allegiant_Pages.PaymentPage;
import allegiant_Pages.Popups;
import allegiant_Pages.Seats;
import allegiant_Pages.SelectBundle;
import allegiant_Pages.SelectFlights;
import allegiant_Pages.TravelerDetails;
import readExcel.ReadExcelData;
import utils.Browsers;
import utils.CommonMethods;
import utils.Properties;

public class RunnerTest extends Properties{
	
	@DataProvider
	public Object [][] getLocationData() throws IOException{	
		String [][] excelData= ReadExcelData.getExcelData("Location");
		return excelData;
		
				
	}	
	
	@DataProvider
	public Object [][] getTravelerData() throws IOException{
		String [][] excelData= ReadExcelData.getExcelData("Traveller_data");
		return excelData;
				
	}
	
	@DataProvider
	public Object [][] getPaymentData() throws IOException{
		String [][] excelData= ReadExcelData.getExcelData("Payment_Details");
		return excelData;
				
	}	


	@Test (dataProvider = "getLocationData") 
	public void run(String data[]) throws IOException, InterruptedException {
		new Browsers().openBrowser(browser, url);
		CommonMethods.validateTitle("Allegiant® | Cheap Flights, Airline Tickets, Vacation & Hotel Deals");
		new Popups().acceptCookies();
		new Popups().topPopup();
		new LocationSearch().enterDepartureAndSendKey(data[1]);
		new LocationSearch().enterDestinationAndSendKey(data[2]);
		new LocationSearch().verifyDeparture(data[1]);
		new LocationSearch().verifyDestination(data[2]);
		new LocationSearch().departureDate();
		new LocationSearch().navigateDate();
		new LocationSearch().selectDateForDeparture(data[3]);
		new LocationSearch().selectDateForReturn(data[4]);
		new LocationSearch().travelorsCount(); 
		new LocationSearch().countIncrement();
		new LocationSearch().searchFlight();
		new SelectFlights().flightPage();
		new SelectFlights().continueBooking();
		new SelectBundle().bundlePage();
		new SelectBundle().continueBundle();
	}
	@Test (dependsOnMethods="run",dataProvider = "getTravelerData") 
	public void run1(String data[]) throws IOException, InterruptedException {
		new TravelerDetails().travelerDetailsPage();
		Thread.sleep(1000);
		new TravelerDetails().gettravellerDetails1(data[1],data[2],data[3],data[4]);
		new TravelerDetails().gettravellerDetails2(data[5],data[6],data[7],data[8]);
		new TravelerDetails().gettravellerDetails3(data[9],data[10],data[11],data[12]);
		new TravelerDetails().gettravellerDetails4(data[13],data[14],data[15],data[16]);
		new TravelerDetails().continueTravel();
		new Seats().seatsPage();
		new Seats().continueSeats();
		new Bags().bagsPage();
		new Bags().continueBags();
		new Bags().continueBagsPopUp();
		new Hotels().hotelsPage();
		new Hotels().continueHotel();
		new Cars().carsPage();
		new Cars().continueCar();
		
	}
	
	@Test (dependsOnMethods="run1",dataProvider = "getPaymentData") 
	public void run2(String data[]) throws IOException, InterruptedException {
		new PaymentPage().paymentsPage();
		new PaymentPage().paymentPopup();
		new PaymentPage().cardDetails(data[1],data[2]);
		new PaymentPage().billingAddress(data[3],data[4],data[5]);
		new PaymentPage().continueTermsAndConditions();
	}
	
	}

