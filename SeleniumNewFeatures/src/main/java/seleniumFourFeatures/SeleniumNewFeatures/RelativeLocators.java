package seleniumFourFeatures.SeleniumNewFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RelativeLocators {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.airvistara.com/in/en/club-vistara/login/login-page");
		WebElement emailField = driver.findElement(By.cssSelector("#flyerid"));
		System.out.println(emailField.getText());
		Thread.sleep(2000);
		String Login = driver.findElement(RelativeLocator.with(By.tagName("span")).above(emailField)).getText();
		System.out.println("Above the field is "+ Login);
		
		String enroll = driver.findElement(RelativeLocator.with(By.tagName("u")).toRightOf(emailField)).getText();
		System.out.println("Right of field is "+ enroll);
		
		String forgotPwd = driver.findElement(RelativeLocator.with(By.tagName("a")).below(emailField)).getText();
		System.out.println("Below the field is "+ forgotPwd);
	
		
	}

}
