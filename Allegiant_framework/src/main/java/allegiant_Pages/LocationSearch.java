package allegiant_Pages;

import java.io.IOException;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

import utils.CommonMethods;
import utils.Properties;



public class LocationSearch extends Properties {
	
	public LocationSearch() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	} 
	@FindBy(xpath = "//div[@data-hook='flight-search-origin']")
	public static WebElement DepartureField;
	
	@FindBy(xpath = "//div[text()='Destination, airport']")
	public static WebElement DestinationField;
	
	@FindBy(xpath = "//div[text()='Allentown (Lehigh Valley), PA (ABE)']")
	public static WebElement verifyDepartureField;
	
	@FindBy(xpath = "//div[text()='Nashville, TN (BNA)']")
	public static WebElement verifyDestinationField;
	
	@FindBy (xpath = "//button[@aria-label='Open calendar for start selection']")
	public static WebElement DepartureDate;
	
	@FindBy (xpath = "//button[@data-hook='flight-search-date-picker_navigate-next-month']")
	public static WebElement navigateDate;
	
	
	@FindBy (xpath = "//div[@data-hook='flight-search-date-picker_calendar-0']/div/following-sibling::div[2]//button[contains(@data-hook,'flight-search-date-picker_calendar')]")
	public static List<WebElement> DayPicker;
	
	@FindBy (xpath = "//div[@data-hook='flight-search-date-picker_calendar-0']/div/following-sibling::div[2]//button[contains(@data-hook,'flight-search-date-picker_calendar')]")
	public static List<WebElement> ReturnDayPicker;
	
	
	  @FindBy(xpath ="//button[@data-hook='flight-search-travelers-expando-button']") 
	  public static WebElement Travelors;
	  
	  @FindBy(xpath = "//button[@data-hook='flight-search-adults_increment']")
	  public static WebElement CountIncrement;
	 
	
	  @FindBy (xpath = "//button[@data-hook='flight-search-submit']")
	  public static WebElement SearchFlights;
	
	
	public void enterDepartureAndSendKey(String fromLc) throws IOException, InterruptedException {
		Actions action=new Actions(driver);
		action.moveToElement(DepartureField).click().sendKeys(fromLc, Keys.ENTER).build().perform();	
	}
     
	public void enterDestinationAndSendKey(String toLoc) throws IOException {
		Actions action=new Actions(driver);
		action.moveToElement(DestinationField).click().sendKeys(toLoc, Keys.ENTER).build().perform();	
		
	}
	
	public  void verifyDeparture(String selectedFromLoc) {	
		Assert.assertTrue(verifyDepartureField.isDisplayed());
		System.out.println("Departure "+ selectedFromLoc + " is displayed");
	}
	
	public  void verifyDestination(String selectedToLoc) {	
		Assert.assertTrue(verifyDestinationField.isDisplayed());
		System.out.println("Destination "+ selectedToLoc + " is displayed");
	}
	
	public void departureDate() {
		try {
			CommonMethods.clickElement(DepartureDate, "Departure Date ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void navigateDate() {
		try {
			CommonMethods.clickElement(navigateDate, "Departure Date ");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
    public void selectDateForDeparture(String date) {
		List<WebElement> dates=DayPicker;
		int count=DayPicker.size();
		for(int i=0; i<count;i++) {
			String text=DayPicker.get(i).getText();
			if(text.contains(date)) {
				DayPicker.get(i).click();
				System.out.println("Departure date " + date + " is selected");
				break;				
			}
		}		
     }

	 public void selectDateForReturn(String date) { 
		  List<WebElement>dates=ReturnDayPicker; 
	      int count=ReturnDayPicker.size(); 
		  for(int i=0; i<count;i++) { 
		    String text=ReturnDayPicker.get(i).getText(); 
		     if(text.contains(date)) {
		      ReturnDayPicker.get(i).click(); 
		      System.out.println("Destination date " + date+ " is selected");
		      break; 
		     } 
	       } 
		 }
		  
			  public void travelorsCount() { 
				  try { 
					  CommonMethods.clickElement(Travelors, "Count"); } 
				  catch (IOException | InterruptedException e)
			  { 
				  e.printStackTrace(); } 
			  }
			  
			  public void countIncrement() { 
				  int i =1; while(i<4) { 
				try {
			  CommonMethods.clickElement(CountIncrement, "Increase count");
			  } catch (IOException | InterruptedException e) {
			  e.printStackTrace(); }
			  i++; 
			  }
			  }
			 
		 
		  public void searchFlight() {
				try {
					CommonMethods.clickElement(SearchFlights, "Search Flight ");
				} catch (IOException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

}
