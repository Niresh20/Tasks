package seleniumFourFeatures.SeleniumNewFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GettingXandY {

	public static void main(String[] args) {
WebDriverManager.chromedriver().setup();
ChromeDriver driver = new ChromeDriver();
driver.get("https://www.facebook.com/");
WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
Rectangle loginButtonRect = loginButton.getRect();
System.out.println(loginButtonRect.getHeight());
System.out.println(loginButtonRect.getWidth());
System.out.println(loginButtonRect.getX());
System.out.println(loginButtonRect.getY());
	}

}
