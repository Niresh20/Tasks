package seleniumFourFeatures.SeleniumNewFeatures;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MobileEmulatorTest {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		DevTools devTools = driver.getDevTools();
		devTools.createSession();
		Map deviceMetrics = new HashMap();
		deviceMetrics.put("width", 600);
		deviceMetrics.put("height", 1000);
		deviceMetrics.put("deviceScalerFactor", 50);
		deviceMetrics.put("mobile", true);
		//devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
		driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//i[@class='hm-icon nav-sprite']")).click();
		
		
		
	}
	}