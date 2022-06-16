package goibibo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browser extends BaseClass{

	public Browser() {
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, 30), this);
	}

	public void setBrowser(String browser) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	  public void setURL(String browser1, String link) { 
		  setBrowser(browser1); 
		  driver.get(link);
	  }
}