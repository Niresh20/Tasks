package goibibo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonFunctions extends BaseClass {
	
	public static void clickElement(WebElement ele,String eleName) throws IOException, InterruptedException {
		
		try {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.click();
		System.out.println(eleName + "Clicked ");
		}
		catch(Exception e){
			System.err.println(eleName + "not Clicked");
			throw new Error();
		}			
	}
	
public static void enterKeys(WebElement ele,String value,String eleName) {
		
		try {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(ele));
		ele.sendKeys(value);
		System.out.println( eleName + "entered");
		}
		catch(Exception e){
			System.err.println(eleName + "not entered " );
			throw new Error();
		}			
	}

public static void selectElement(WebElement ele,String type,String value,String eleName) {
	Select select=new Select(ele);
	try {
		
		if(type.contains("index")) {
			
			select.selectByIndex(Integer.parseInt(value));
			System.out.println(eleName+"is selected in dropdown");
			
		}
		else if(type.contains("value")) {
			
			select.selectByValue(value);
			System.out.println(eleName+"is selected in dropdown");
			
		}
		else if(type.contains("visibletext")) {
			
			select.selectByVisibleText(eleName);
			System.out.println(eleName+"is selected in dropdown");
			
		}

		/*
		 * WebElement staticDropdown= driver.findElement(By.id("eleName"));
		 * 
		 * Select dropdown = new select(staticDropdown); dropdown.selectByIndex(3);
		 * System.out.println(dropdown.getFirstSelectedOption().getText());
		 */
		else {
			System.err.println("Please enter valid type");
		}
		
	}
	catch(Exception e){
		System.err.println(eleName+"not selected");
	}			
}

public static void validateTitle(String expectedTitle) {
	
	String actualTitle=driver.getTitle();
	System.out.println(actualTitle);
	Assert.assertEquals(actualTitle, expectedTitle);
}
}
