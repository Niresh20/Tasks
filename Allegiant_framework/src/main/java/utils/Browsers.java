package utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Browsers extends Properties {
	
	public void Browser() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}
	
	public void openBrowser(String browser, String url) {
		
		
		if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver","D:\\drivers\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get(url);
			}
		else if(browser.equalsIgnoreCase("firefox")){
				System.setProperty("webdriver.gecko.driver","D:\\drivers\\geckodriver.exe");
				driver = new FirefoxDriver();
				driver.get(url);
				}
			
		else if(browser.equalsIgnoreCase("edge")){
			System.setProperty("webdriver.edge.driver","D:\\drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			driver.get(url);
			}
		else if(browser.equalsIgnoreCase("IE")){
			System.setProperty("webdriver.gecko.driver","D:\\drivers\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.get(url);
			}
		else {
			System.out.println("Please enter valid browser");
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
}
