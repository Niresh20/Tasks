package commons;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import page.BaseClass;

public class CommonMethods extends BaseClass {
	public static void clickMethod(WebElement closeBtn, String string) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(closeBtn));

		closeBtn.click();
		System.out.println(string + " is clicked");
	}

	public static void sendKeys(WebElement ele, String string) {
		ele.sendKeys(string);
		System.out.println(string + " is entered");
	}

	public static void listDropDown(List<WebElement> ele, String str) {
		List<WebElement> fromlist = ele;
		for (WebElement web : fromlist) {
			String web2 = web.getText();
			if (web2.equalsIgnoreCase(str)) {
				web.click();
				System.out.println("List value is selected");
				break;
			}
		}
	}

	public static void datePicker(List<WebElement> daySPicker, String startMonth, String startDate,
			List<WebElement> dayPicker_2, String strMonth) {

		while (true) {
			String month_cal = driver
					.findElement(By.xpath("(//h2[@class='Calendar__MonthAndYearHeading-epvxa4-4 chbQGp'])[1]"))
					.getText();
			String month_cal2 = driver
					.findElement(By.xpath("(//h2[@class='Calendar__MonthAndYearHeading-epvxa4-4 chbQGp'])[2]"))
					.getText();

			if (startMonth.equals(month_cal) || startMonth.equals(month_cal2)) {
				break;
			} else {
				driver.findElement(By.xpath("//button[@aria-label='Go to next month']")).click();
			}
		}

		String mon = strMonth;
		switch (mon) {
		case "January", "March", "May", "July", "September", "November":
			for (WebElement stDate : dayPicker_2) {
				String date = stDate.getText();
				if (date.equalsIgnoreCase(startDate)) {
					Validation.isEnable(stDate, "Date: " + date + " " + strMonth);
					if (stDate.isEnabled()) {
						stDate.click();
						System.err.println("Date" + startDate + " " + strMonth + " is selected");
						break;
					} else {
						System.err.println("Flight is not avaliable on this date. Please select another date!");
					}
				}
			}
			break;

		default:
			for (WebElement stDate : daySPicker) {
				String date = stDate.getText();
				if (date.equalsIgnoreCase(startDate)) {
					Validation.isEnable(stDate, "Date: " + date + " " + strMonth);
					if (stDate.isEnabled()) {
						stDate.click();
						System.err.println("Date " + startDate + " is selected");
						break;
					} else {
						System.err.println("Flight is not avaliable on this date. Please select another date!");
					}
				}
			}
			break;
		}
	}

	public static void selectDropDown(WebElement countryCode, String type, String value, int index) {
		System.out.println();
		if (type.equalsIgnoreCase("visibleText")) {
			Select se = new Select(countryCode);
			se.selectByVisibleText(value);
			System.out.println(value + " is selected from dropdown");
		} else if (type.equalsIgnoreCase("value")) {
			Select se = new Select(countryCode);
			se.selectByValue(value);
			System.out.println(value + " is selected from dropdown");
		} else {
			Select se = new Select(countryCode);
			se.selectByIndex(index);
			System.out.println(value + " is selected from dropdown");
		}
	}
	
	public static void scrollDown(WebElement element) {
		JavascriptExecutor val = (JavascriptExecutor) driver;
		val.executeScript("arguments[0].scrollIntoView(true)", element);
	}

}