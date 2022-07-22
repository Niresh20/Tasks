package seleniumFourFeatures.SeleniumNewFeatures;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshots {
public static void main(String[] args) throws IOException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.redbus.in/");
	WebElement element = driver.findElement(By.xpath("//a[@class='home-redirect redbus-logo']"));
	File img1=element.getScreenshotAs(OutputType.FILE);	
	FileUtils.copyFile(img1, new File("./image.png"));
	
}
}
