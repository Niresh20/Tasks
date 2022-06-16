package goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestEx {
	
	@Test
	public void flightBooking() throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
		String title=driver.getTitle();
		System.out.println(title);
		
		Assert.assertEquals(title, "Goibibo - Best Travel Website. Book Hotels, Flights, Trains, Bus and Cabs with upto 50% off1233434");
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='From']//parent::div")).click();
		
		
	}

}
