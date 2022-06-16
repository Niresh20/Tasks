package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class CommonMethods extends Properties {
	
	
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
			System.setProperty("webdriver.gecko.driver","D:\\drivers\\msedgedriver.exe");
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
	
	public void closeBrowser() {
		
		driver.quit();
	}
	
	public static void clickElement(WebElement element, String name) throws IOException, InterruptedException {
		try {
			WebDriverWait wait= new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.click();
			System.out.println(name + " Clicked ");
			}
			catch(Exception e){
				System.err.println(name + " not Clicked ");
				throw new Error();
			}			
		}
	
	public static void enterKeys(WebElement element,String value,String name) {
		
		try {
		WebDriverWait wait= new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
		element.sendKeys(value);
		System.out.println(value + " entered in " + name);
		}
		catch(Exception e){
			System.err.println(value +" not entered in " + name );
		}			
	}
	/*
	public static void enterKeys(WebElement element, Object[][] value, String name) {
		
		try {
			WebDriverWait wait= new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.elementToBeClickable(element));
			element.sendKeys(value);
			System.out.println(value + " entered in " + name);
			}
			catch(Exception e){
				System.err.println(value +" not entered in " + name );
			}	
	}
*/
	
	public static void enterKeys(WebElement item, Keys key, String itemName) {
   	 try {
   			WebDriverWait wait= new WebDriverWait(driver, 30);
   			wait.until(ExpectedConditions.elementToBeClickable(item));
   			item.sendKeys(key);
   			System.out.println(key +" entered in " + itemName);
   			}
   			catch(Exception e){
   				System.err.println(key +" Not entered in " + itemName );
   			}
   	 
	}
	public static void enterKeys(WebElement item, String[] object, String name) {
		try {
   			WebDriverWait wait= new WebDriverWait(driver, 30);
   			wait.until(ExpectedConditions.elementToBeClickable(item));
   			item.sendKeys(object);
   			System.out.println(object +" entered in " + name);
   			}
   			catch(Exception e){
   				System.err.println(object +" Not entered in " + name );
   			}
   	 
	}
		
	
	public static void validateTitle(String expectedTitle) {
		try {
			Thread.sleep(4000);
			String actualTitle=driver.getTitle();
			System.out.println(actualTitle);
			Assert.assertEquals(actualTitle, expectedTitle);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
			}
/*	
public static ArrayList<String> getData(String testSheetName, String testCaseName, String testScenario ) throws IOException {
		
		ArrayList<String> a= new ArrayList<String>();
		FileInputStream fis= new FileInputStream("C:\\Users\\nmadhanagopal\\eclipse-workspace\\Framework\\Resources\\traveller_details.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(fis);
		int sheets=workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase(testSheetName)) {
				
				XSSFSheet sheet= workbook.getSheetAt(i);
				Iterator <Row> rows=sheet.iterator();
				Row firstRow=rows.next();
				Iterator<Cell> cel=firstRow.cellIterator();
				int k=0;
				int column =0;
				while (cel.hasNext()) {
					Cell value=cel.next();
					if (value.getStringCellValue().equalsIgnoreCase(testCaseName)) {
						column=k;
					}
					k++;
				}
				System.out.println(column+ "th Column");
				
				while(rows.hasNext())
				{
					Row r=rows.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase(testScenario))
					{
						Iterator <Cell> ci=r.cellIterator();
						while (ci.hasNext()){
							Cell c=ci.next();
							if(c.getCellType()==c.getCellType().STRING) {
								a.add(c.getStringCellValue());
							}
							else {
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
							
						}
					}
				}
					
			}
			
			
		}
		
		return a;
	
		
	}

*/

	

	
	

}
