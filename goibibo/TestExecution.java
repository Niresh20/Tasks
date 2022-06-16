package goibibo;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestExecution{
	
	
	@Test
	public void flightBooking() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		//driver.findElement(By.linkText("Flights")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='From']//parent::div")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Chennai (MAA)");
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/div//p/span[text()='Chennai, India']")).click();
		
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Mumbai (BOM)"); 
		driver.findElement(By.xpath("//ul[@id='autoSuggest-list']/li/div//p/span[text()='Mumbai, India']")).click();
		//driver.findElement(By.cssSelector(".DayPicker-Day.DayPicker-Day--start.DayPicker-Day--selected.DayPicker-Day--today")).click(); 
		Thread.sleep(2000);
		List<WebElement> dates=driver.findElements(By.className("DayPicker-Day"));
		int count=driver.findElements(By.className("DayPicker-Day")).size();
		for(int i=0; i<count;i++) {
			String text=driver.findElements(By.className("DayPicker-Day")).get(i).getText();
			//System.out.println(text);
			if(text.contains("31")) {
				
				driver.findElements(By.className("DayPicker-Day")).get(i).click();
				break;
				
			}
		}
		
		driver.findElement(By.xpath("//span[text()='Done']")).click();
		driver.findElement(By.xpath("//ul/li[text()='business']")).click();
		driver.findElement(By.xpath("//a[text()='Done']")).click();
		driver.findElement(By.xpath("//span[text()='SEARCH FLIGHTS']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()='BOOK']")).click();
		driver.findElement(By.xpath("//button[text()='Insure for ₹']")).click();
		driver.findElement(By.xpath("//span[text()='Cab from Mumbai airport']")).click();
		WebElement title=driver.findElement(By.xpath("//input[@name='givenname']/parent::div//preceding-sibling::div/select"));

	    CommonFunctions.selectElement(title, "index", "1", " salutation ");
	    driver.findElement(By.xpath("//input[@name='givenname']")).sendKeys("Niresh");
	    driver.findElement(By.xpath("//input[@name='email']")).sendKeys("test@gmail.com");
	    driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys("9000000000");
	    driver.findElement(By.xpath("//button[text()='Proceed']")).click();
		driver.findElement(By.xpath("//button[text()='Proceed To Payment']")).click();
		driver.findElement(By.xpath("//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardnumber']")).sendKeys("5555555555554444");
		driver.findElement(By.xpath("//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='ccname']")).sendKeys("Test");
		driver.findElement(By.xpath("//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardExpiry']")).sendKeys("0626");
		driver.findElement(By.xpath("//span[text()='Debit/Credit Card']/parent::div/parent::div/parent::div/following-sibling::div//input[@name='cardCVV']")).sendKeys("000");
		driver.findElement(By.xpath("//p[text()='Address Line']/following-sibling::input")).sendKeys("811 North Cataline Avenue, No.3002 test avenue");
		driver.findElement(By.xpath("//p[text()='Zip Code']/following-sibling::input")).sendKeys("600000");
		driver.findElement(By.xpath("//p[text()='City']/following-sibling::input")).sendKeys("test");
		driver.findElement(By.xpath("//p[text()='State']/following-sibling::input")).sendKeys("Tamilnadu");
		driver.findElement(By.cssSelector(".button.green.large.citipatBtn.btn.payNowBtn")).click();
		
		
	 
		
		
		/*
		 * driver.findElement(By.id("autoSuggest-list")).sendKeys("chennai");
		 * Thread.sleep(2000); List<WebElement>
		 * searchResults=driver.findElements(By.xpath("//li[@role='presentation']"));
		 * for(WebElement options: searchResults) {
		 * 
		 * if(searchResults.toString().contains("Chennai International Airport")) {
		 * 
		 * ((WebElement) searchResults).click();
		 * 
		 * }
		 * 
		 * }
		 */
		
		
	}

}
