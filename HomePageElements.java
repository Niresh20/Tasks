package page;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import commons.CommonMethods;
import commons.Validation;

public class HomePageElements extends BaseClass {

	@FindBy(xpath = "//button[@class='Popup__CloseIcon-sc-1kasz48-2 eKPgGA']")
	public static WebElement popUpCloseBtn;

	@FindBy(xpath = "//div[@class=' css-173wrpp-control']")
	public static WebElement fromCityTextBox;

	@FindBy(xpath = "(//div[@class=' css-1hwfws3'])[2]")
	public static WebElement toCityTextBox;

	@FindBy(xpath = "((//div[@class='ant-col ant-col-24 ant-col-lg-12'])[1]//input)[1]")
	public static WebElement departure;

	@FindBy(xpath = "((//div[@class='ant-col ant-col-24 ant-col-lg-12'])[2]//input)[1]")
	public static WebElement destination;

	@FindBy(xpath = "//button[@aria-label='Open calendar for start selection']")
	public static WebElement dateButton;

	@FindBy(xpath = "//button[@aria-label='Open calendar for end selection']")
	public static WebElement dateButtonReturn;

	@FindBy(xpath = "//span[text()='Continue']")
	public static WebElement continue_btn;

	@FindBy(xpath = "//span[text()='1']")
	public static WebElement roomNumber;

	@FindBy(xpath = "//button[@data-hook='flight-search-submit']")
	public static WebElement searchButton;

	@FindBy(xpath = "(//button[@aria-label='Close'])[2]")
	public static WebElement closeCookieBanner;

	@FindBy(xpath = "(//div[@class='Calendar__Grid-epvxa4-0 Calendar__DateGrid-epvxa4-3 gNEFIj'])[1]//button")
	public static List<WebElement> DayPicker;

	@FindBy(xpath = "(//div[@class='Calendar__Grid-epvxa4-0 Calendar__DateGrid-epvxa4-3 gNEFIj'])[2]//button")
	public static List<WebElement> DayPicker_2;

	public HomePageElements() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void closePopUp() throws InterruptedException {
		Validation.title();
		Validation.URL();
		Thread.sleep(2000);
		CommonMethods.clickMethod(popUpCloseBtn, "Close button on pop-up");
		CommonMethods.clickMethod(closeCookieBanner, "Close cookie banner");
	}

	public void flyingFrom() throws InterruptedException {
		Validation.isDisplay(fromCityTextBox, "Departure city textbox");
		Validation.isEnable(fromCityTextBox, "Departure city textbox");
		CommonMethods.clickMethod(fromCityTextBox, "Departure city textbox");

		CommonMethods.sendKeys(departure, DepartureCity);
		departure.sendKeys(Keys.ENTER);
		departure.sendKeys(Keys.TAB);

	}

	public void flyingTo() {
		Validation.isDisplay(toCityTextBox, "Destination city");
		Validation.isEnable(toCityTextBox, "Destination city");
		CommonMethods.clickMethod(toCityTextBox, "Destination City");

		CommonMethods.sendKeys(destination, DestCity);
		destination.sendKeys(Keys.ENTER);
		destination.sendKeys(Keys.TAB);
	}

	public void dateSelection() {
		CommonMethods.clickMethod(dateButton, "Date button");
		CommonMethods.datePicker(DayPicker, "August 2022", "5", DayPicker_2, "August");
		CommonMethods.datePicker(DayPicker, "November 2022", "20", DayPicker_2, "November");
	}

	public void searchFlight() {
		Validation.isDisplay(searchButton, "Search Button");
		Validation.isEnable(searchButton, "Search Button");
		CommonMethods.clickMethod(searchButton, "Search Button");
	}
}