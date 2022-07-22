package seleniumFourFeatures.SeleniumNewFeatures;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandles {
public static void main(String[] args) throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
	driver.get("https://www.google.co.in/");
	System.out.println(driver.getTitle());
	driver.switchTo().newWindow(WindowType.TAB);
	Set <String> handles=driver.getWindowHandles();
	List <String> ls= new ArrayList<String>(handles);
	String ParentWindow = ls.get(0);
    String ChildWindow = ls.get(1);
    System.out.println(ParentWindow);
    System.out.println(ChildWindow);
    driver.get("https://www.allegiantair.com/");
    System.out.println("After switching: "+ driver.getTitle() );
    driver.close();
    driver.switchTo().window(ParentWindow);
    System.out.println("Parent Window: "+ driver.getTitle());
    driver.manage().window().getSize().getWidth();
	driver.manage().window().getSize().getHeight();
	Dimension size = driver.manage().window().getSize();
	System.out.println(size.getWidth());
	System.out.println(size.getHeight());
	driver.manage().window().setSize(new Dimension(600,400));
	Thread.sleep(3000);
	System.out.println(size.getWidth());
	System.out.println(size.getHeight());
}
}
