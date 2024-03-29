package commonuseractions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.json.JSONObject;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.MouseButton;
import org.openqa.selenium.interactions.PointerInput.Origin;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.appium.java_client.AppiumDriver;
import utils.Browserfactory;
import utils.DriverFactory;
import utils.ExcelReader;

/**
 * @author vbaskar
 * @This Class has all CommonActionMethods
 *
 *
 */
public class CommonActionMethods extends TestListner {
	protected static AppiumDriver appDriver = null;
	protected static boolean invokeMail = false;
	protected static ThreadLocal<String> url = new ThreadLocal<>();
	protected static String testName = "";
	protected static ExtentReports extentreport;
	protected static ExtentHtmlReporter htmlreporter;
	protected static ExtentTest testcase;
	protected static String configFilename = "C:\\AutomationTask\\Sucide_Squad_Automation_Repo\\src\\main\\java\\log4j.properties";
	protected static Logger log = LogManager.getLogger(CommonActionMethods.class);
	protected static ThreadLocal<Map<String, String>> inputdata = ThreadLocal.withInitial(() -> {
		 return new HashMap<>();
		
	});

	public static Map<String, String> getInputData() {
		return inputdata.get();
	}

	/**
	 * @This method call the pagename,author,category
	 * @param message
	 * @param author
	 * @param category
	 */
	public static void extent(String message, String author, String category) {
		testcase = extentreport.createTest(message).assignAuthor(author).assignCategory(category);
	}

	/**
	 * @This method is used to call the extend report
	 * @param name
	 */
	public static void extentReports(String name) {
		extentreport = new ExtentReports();
		htmlreporter = new ExtentHtmlReporter(name);
		htmlreporter.config().setTheme(Theme.DARK);
		extentreport.attachReporter(htmlreporter);
	}

	/**
	 *
	 * @This method is used to print the log message in console
	 * @param message -string value about the action being performed
	 */
	public static void logMessage(String message) {
		log.info(message);
		if (extentreport != null) {
			testcase.log(Status.PASS, message);
		}
	}

	/**
	 * @This method is used to print the log error message in console and stop the
	 *       execution
	 * @param MessageStopExecution -string value about the action being performed
	 * @throws Exception
	 */
	public static synchronized  void logErrorMessage(String messagestopexecution) throws Exception {
		log.error(messagestopexecution);
		String shot = takeSnapShot();
		if (invokeMail) {
			FailedScreenShotdestination.set(shot);
			scenarioComments.set(messagestopexecution);
			scenarioDescription.set(getdata("Scenario"));
			scenarioNo.set(getdata("Number"));
			scenarioStatus.set("Failed");
		}
		if (extentreport != null) {
			testcase.log(Status.FAIL, messagestopexecution);
			testcase.addScreenCaptureFromPath(shot);
		}
		throw new RuntimeException(messagestopexecution);
	}

	/**
	 * @This method is used to print the log error message in console and stop the
	 *       execution
	 * @param MessageStopExecution -string value about the action being performed
	 * @throws Exception
	 */
	public synchronized static void logErrorAndMessage(String MessageStopExecution) throws Exception {
		log.error(MessageStopExecution);
		throw new RuntimeException(MessageStopExecution);
	}

	/**
	 * @This method is used to invoke the browser
	 * @param browser-string     value about the action being performed
	 * @param browsertype-string value about the action being performed
	 * @param url-string         value about the action being performed
	 * @throws Exception
	 */


	public void invokeBrowser(String browser, String browsertype, String url) throws Exception {
		PropertyConfigurator.configure(configFilename);
		DriverFactory.setDriver(Browserfactory.createBrowser(browser, browsertype));
		DriverFactory.getDriver().manage().window().maximize();
		DriverFactory.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		DriverFactory.getDriver().get(url);
	}

	/**
	 *
	 * @This method is for click the element
	 * @param element -Webelement to click
	 * @param button  -string value about the action being performed
	 * @throws Exception
	 */
	public static void clickMethod(WebElement element, String button) throws Exception {
		try {
			element.click();
			logMessage(button + " button is clicked  ");
		} catch (Exception e) {
			e.printStackTrace();
			logErrorMessage(button + " button is not clicked ");
		}
	}

	/**
	 * @This method is for enter the value
	 * @param key   -Webelement of the textbox to send the text
	 * @param enter -string value about the action being performed
	 * @throws Exception
	 *
	 */
	public static void sendKeysMethod(WebElement key, String enter) throws Exception {
		try {
			key.sendKeys(enter);
			logMessage(enter + " is entered ");
		} catch (Exception e) {
			logErrorMessage(" Element is not entered in " + enter);
		}
	}

	/**
	 * @This method is for selectByVisibleText
	 * @param element     -Webelement to select an option from the dropdown
	 *                    ByVisibleText
	 * @param text-string value about the action being performed
	 * @throws Exception
	 */
	public static void selectByVisibleText(WebElement element, String text) throws Exception {
		try {
			scrollToElement(element);
			Select sel = new Select(element);
			sel.selectByVisibleText(text);
			logMessage(text + " is selected in dropdown selectByVisibleText ");
		} catch (Exception e) {
			logErrorMessage(text + " Element is not selected selectByVisibleText ");
		}
	}

	/**
	 *
	 * @This method is for selectByValue
	 * @param element-Webelement to select an option from the dropdown ByValue
	 * @param text-string        value about the action being performed
	 * @throws Exception
	 */
	public static void selectByValue(WebElement element, String text) throws Exception {
		try {
			webwaitVisibility(element);
			Select sel = new Select(element);
			sel.selectByValue(text);
			logMessage(text + " is selected in dropdown selectByValue ");
		} catch (Exception e) {
			logErrorMessage(text + " Element is not selected selectByValue ");
		}
	}

	/**
	 *
	 * @This method is for selectByIndex
	 * @param element-Webelement to select an option from the dropdown ByIndex
	 * @param Index-string       value about the action being performed
	 * @throws Exception
	 */
	public static void selectByIndex(WebElement element, int index) throws Exception {
		try {
			Select sel = new Select(element);
			sel.selectByIndex(index);
			logMessage(index + " is selected in dropdown selectByIndex");
		} catch (Exception e) {
			logErrorMessage(index + " Element is not selected selectByIndex");
		}
	}

	/**
	 * @return
	 * @This method is used to take a screenshot
	 * @throws Exception
	 */
	public static String takeSnapShot() throws Exception {
		try {
			File srcfile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);
			File filepath = new File("./Snaps/" + System.currentTimeMillis() + ".png");
			String pathlocation = filepath.getAbsolutePath();
			FileUtils.copyFile(srcfile, filepath);
			logMessage(" Screenshot taken-stored in the given path ");
			return pathlocation;
		} catch (Exception e) {
			System.err.println(" Screenshot is not taken ");
		}
		return null;
	}

	/**
	 * @This method is used for windowhandle
	 * @throws Exception
	 *
	 */
	public static void windowHandle() throws Exception {
		try {
			String hand = DriverFactory.getDriver().getWindowHandle();
			List<String> wind = (List<String>) DriverFactory.getDriver().getWindowHandles();
			for (String window : wind) {
				if (!window.equalsIgnoreCase(hand)) {
					DriverFactory.getDriver().switchTo().window(window);
				}
			}
			logMessage(" windowhandle is successful ");
		} catch (Exception e) {
			logErrorMessage(" windowhandle is not successful ");
		}
	}

	/**
	 *
	 * @This method is used for frameByElement
	 * @param element -Webelement of the frame to switch the driver
	 * @throws Exception
	 */
	public static void frameByElement(WebElement element) throws Exception {
		try {
			DriverFactory.getDriver().switchTo().frame(element);
			logMessage(" framehandle is successful by webelement ");
		} catch (Exception e) {
			logErrorMessage(" no such frame exception frameByElement ");
		}
	}

	/**
	 *
	 * @This method is used for frameByIndex
	 * @param Index -Integer index of the frame
	 * @throws Exception
	 */
	public static void frameByIndex(int index) throws Exception {
		try {
			DriverFactory.getDriver().switchTo().frame(index);
			logMessage(" framehandle is successful by index ");
		} catch (Exception e) {
			logErrorMessage(" no such frame exception frameByIndex ");
		}
	}

	/**
	 *
	 * @This method is used for frameByNameorID
	 * @param nameORid-string value about the action being performed
	 * @throws Exception
	 */
	public static void frameByNameorID(String nameORid) throws Exception {
		try {
			DriverFactory.getDriver().switchTo().frame(nameORid);
			logMessage(" framehandle is successful by name or id ");
		} catch (Exception e) {
			logErrorMessage(" no such frame exception frameByNameorID ");
		}
	}

	/**
	 * @This method is used for default window
	 * @throws Exception
	 *
	 */
	public static void defaultwindow() throws Exception {
		try {
			DriverFactory.getDriver().switchTo().defaultContent();
			logMessage(" Switched to defaultwindow ");
		} catch (Exception e) {
			logErrorMessage(" Not switched to defaultwindow ");
		}
	}

	/**
	 * @This method is for get current page title
	 * @return
	 */
	public static String getTitle() {
		String title = DriverFactory.getDriver().getTitle();
		logMessage(title);
		return title;
	}

	/**
	 * @This method is for get a current url
	 * @return
	 */
	public static String getURL() {
		String url = DriverFactory.getDriver().getCurrentUrl();
		logMessage(url);
		return url;
	}

	/**
	 *
	 * @This method is for element is displayed
	 * @param element     -WebElement to check whether is displayed or not
	 * @param ElementName
	 * @throws Exception
	 */
	public static void isDisplayed(WebElement element, String elementname) throws Exception {

		Assert.assertTrue(element.isDisplayed(), elementname + " is not displayed in catch block ");
		logMessage(elementname + " is displayed ");
	}

	/**
	 *
	 * @This method is for element is selected
	 * @param element     -WebElement to check whether is Selected or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isSelected(WebElement element, String elementname) throws Exception {

		Assert.assertTrue(element.isSelected(), elementname + " is not selected ");
		logMessage(elementname + " is selected");
	}

	/**
	 * @This method is for element is enabled
	 * @param element     -WebElement to check whether is Enabled or not
	 * @param ElementName -string value about the action being performed
	 * @throws Exception
	 */
	public static void isEnabled(WebElement element, String elementname) throws Exception {
		Assert.assertTrue(element.isEnabled(), elementname + " is not enabled in catch block ");
		logMessage(elementname + " is enabled ");

	}

	/**
	 * @This method is used to check the variable are equal
	 * @param intial-object   value about the action being performed
	 * @param end-object      value about the action being performed
	 * @param obj1name-string value about the action being performed
	 * @param obj2name-string value about the action being performed
	 * @throws Exception
	 */

	public static void checkEquality(Object intial, Object end) throws Exception {

		Assert.assertTrue(
				String.valueOf(intial).trim().toLowerCase().contains(String.valueOf(end).trim().toLowerCase()),
				intial + " & " + end + " is not equal");
		logMessage(intial + " & " + end + " is equal");
	}

	/**
	 * @This method for getting the data from the hash map and returns the value
	 *
	 * @param Name It is the name of the column
	 * @return
	 * @throws Exception
	 */
	public static synchronized String getdata(String name) throws Exception {
		String data = "";
		if (inputdata.get().containsKey(name)) {
			data = inputdata.get().get(name);
		} else {
			logErrorMessage(" Given Column name is not available in the Excel " + name);
		}
		return data;
	}

	/**
	 * This method is to click the respective element by its text from the list of
	 * webelements.
	 *
	 * @param listelement
	 * @param Toselect
	 * @return
	 * @throws Exception
	 */
	public static void listDrop(List<WebElement> listelement, String toselect) throws Exception {
		boolean flag = true;
		for (WebElement element : listelement) {
			String name = element.getText();
			logMessage(name);
			if (name.contains(toselect)) {
				flag = false;
				clickMethod(element, toselect);
				logMessage(toselect + "  is clicked");
				break;
			}
		}
		if (flag) {
			logErrorMessage(" No such String to click ");
		}
	}

	/**
	 * This method is to split the given given string by comma.
	 *
	 * @param data
	 * @return
	 */
	public static String[] splitString(String data, String symbol) {

		return data.split(symbol);
	}

	public static void scrollToElement(WebElement ele) {
		JavascriptExecutor scrl = (JavascriptExecutor) DriverFactory.getDriver();
		scrl.executeScript("arguments[0].scrollIntoView(true)", ele);
	}

	/**
	 * This method is to get the text data from excel
	 *
	 * @param sheetname
	 * @return
	 * @throws Exception
	 */
	public static synchronized Iterator<Object[]> getTestData(String sheetname, String excelfilename) throws Exception {
		ExcelReader xlRead = null;
		int xlRowCount = 0;
		xlRead = new ExcelReader(excelfilename, sheetname);
		xlRowCount = xlRead.getRowCount();
		ArrayList<Object[]> data = new ArrayList<>();
		for (int i = 1; i < xlRowCount; i++) {
			data.add(new Object[] { xlRead.xlReader(i) });
		}
		return data.iterator();
	}

	/**
	 * This method is to get text of the element
	 *
	 * @param element
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public static String getTextElement(WebElement element, String name) throws Exception {
		String text = "";
		try {
			text = element.getText();
			logMessage(text + " is displayed");
		} catch (Exception e) {
			logErrorMessage(" The object  " + name + " is not displayed " + e);
			e.printStackTrace();
		}
		return text;
	}

	/**
	 * This method waits for the given element until it is clickable
	 *
	 * @param ele
	 * @throws Exception
	 */
	public static void webWait(WebElement ele) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		} catch (Exception e) {
			logErrorMessage(" Element not clickable time out waiting for element to be clickable ");
		}
	}

	/**
	 * This methods waits until the element is visible.
	 *
	 * @param ele
	 * @throws Exception
	 */
	public static void webwaitVisibility(WebElement ele) throws Exception {
		try {
			WebDriverWait wait = new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(ele));
		} catch (Exception e) {
			logErrorMessage(" Element not clickable time out waiting for element to be clickable ");
		}
	}

	/**
	 * This method deletes every sub-files inside the given directory
	 *
	 * @param file
	 */
	public static void deleteFolder(File file) {
		if (file.length() != 0) {
			for (File subFile : file.listFiles()) {
				if (subFile.isDirectory()) {
					deleteFolder(subFile);
				} else {
					boolean del = subFile.delete();
					if (del) {
						logMessage("sub files deleted successfully");
					} else {
						logMessage("sub files not deleted ");
					}
				}
			}
			boolean del = file.delete();
			if (del) {
				logMessage("File deleted successfully");
			} else {
				logMessage("File not deleted ");
			}
		}

	}

	/**
	 * @This method is used to capitalize the string case provided
	 *
	 * @param str - String to be capitalized
	 * @return string
	 *
	 */
	public static String capitalize(String str) {
		if (str == null || str.isEmpty()) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1).toLowerCase();
	}

	/**
	 *
	 * @This method is to convert the text response into JSON
	 *
	 * @param textString
	 * @return JSONObject
	 *
	 */
	public static JSONObject restConvertTextAsJson(String textString) {
		return new JSONObject(textString);
	}

	/**
	 *
	 * @This method is to get the correlate parameter value from the array object by
	 *       giving rest response object as input
	 *
	 * @param response
	 * @param jsonPath
	 * @return jsonString
	 * @throws Exception
	 *
	 */
	public static String restCorrelateJSON(String jsonString, String jsonPath) throws Exception {

		boolean flag = true;
		JSONObject jsonObj = null;
		Iterator<String> jsonItr = null;

		String[] jsonPathSplit = jsonPath.split(Pattern.quote("."));
		for (String matchKey : jsonPathSplit) {
			if (matchKey.contains("[")) {
				jsonObj = restConvertTextAsJson(jsonString);
				int strLen = matchKey.length();
				jsonString = jsonObj.getJSONArray(matchKey.replaceAll("\\[\\d\\]", ""))
						.getJSONObject(Integer.parseInt(matchKey.substring(strLen - 2, strLen - 1))).toString();
			}
			jsonObj = restConvertTextAsJson(jsonString);
			jsonItr = jsonObj.keys();
			while (jsonItr.hasNext()) {
				String keyvalue = jsonItr.next();
				if (keyvalue.equals(matchKey)) {
					jsonString = jsonObj.get(keyvalue).toString();
					flag = false;
					break;
				}
			}
		}

		if (flag) {
			logErrorMessage("No value found");
		}

		return jsonString;

	}

	/**
	 * @method returns the requested date from the curent date in the format
	 *         MMMMMMMMMM/d/yyyy
	 * @param plusdays
	 * @return
	 */
	public String currentDate(int plusdays, String format) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, +plusdays);
		SimpleDateFormat date = new SimpleDateFormat();
		date.applyPattern(format);
		return date.format(cal.getTime());
	}

	/**
	 * @method To swipe down until the element appears, If need to click, sendKey or
	 *         get text pass the action in the string format in the action parameter
	 *         and if not using sendkey, click or gettext set action and keyToSend
	 *         parameter null, if the action parameter is other than sendkey the
	 *         keyToSend parameter must be null
	 * @param element
	 * @param name
	 * @param click
	 * @return
	 * @throws Exception
	 */
	public String swipeUpToElement(WebElement element, String name, String action, String keyToSend) throws Exception {
		Dimension windowSize = appDriver.manage().window().getSize();
		String text = null;
		int scrollPoints = 0;
		boolean endPage = false;
		String previousSource = null;
		while (!endPage) {
			Thread.sleep(1000);
			if (!isElementPresent(element)) {
				previousSource = appDriver.getPageSource();
				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeUpToElement");
				Sequence swipeUp = new Sequence(finger, 1);
				swipeUp.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), windowSize.width / 2,
						windowSize.height / 2)).addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
						.addAction(finger.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
								windowSize.width / 2, 0))
						.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
				appDriver.perform(Arrays.asList(swipeUp));
				logMessage(" Element not in view, Scrolling up ");
				scrollPoints++;
				if (scrollPoints > 10) {
					logErrorMessage(" Element not found ");
					break;
				}
			} else if (isElementPresent(element)) {
				if (action != null) {
					switch (action) {
					case "click":
						clickMethod(element, name);
						break;
					case "sendkey":
						sendKeysMethod(element, keyToSend);
						break;
					case "gettext":
						text = getTextElement(element, name);
						return text;
					default:
						logMessage("Swiped to element ");
						break;
					}
				}
				break;
			}
				if (previousSource != null) {
					endPage = previousSource.equals(appDriver.getPageSource());
				}
			
		}
		if (endPage) {
			logErrorMessage("Element not found in the page");
		}
		return text;
	}

	/**
	 * @method Returns false if the element doesn't exist in the window.
	 * @param element
	 * @return
	 */
	public boolean isElementPresent(WebElement element) {
		boolean flag = true;
		try {

			logMessage(" presence of Element is " + (element.isDisplayed()));
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * @method To swipe down until the element appears, If need to click, sendKey or
	 *         get text pass the action in the string format in the action parameter
	 *         and if not using sendkey, click or gettext set action and keyToSend
	 *         parameter null, if the action parameter is other than sendkey the
	 *         keyToSend parameter must be null
	 * @param element
	 * @param name
	 * @param click
	 * @return
	 * @throws Exception
	 */
	public String swipeDownToElement(WebElement element, String name, String action, String keyToSend)
			throws Exception {
		Dimension windowSize = appDriver.manage().window().getSize();
		String text = null;
		int scrollPoints = 0;
		boolean endPage = false;
		String previousSource = null;
		while (!endPage) {
			if (!isElementPresent(element)) {
				previousSource = appDriver.getPageSource();
				PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeDownToElement");
				Sequence swipeDown = new Sequence(finger, 1);
				swipeDown
						.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), windowSize.width / 2,
								windowSize.height / 2))
						.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
						.addAction(finger.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
								windowSize.width / 2, windowSize.height / 2 + (windowSize.height / 2)))
						.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
				appDriver.perform(Arrays.asList(swipeDown));
				logMessage(" Element not in view, Scrolling up ");
				scrollPoints++;
				if (scrollPoints > 10) {
					logErrorMessage(" Element not found ");
					break;
				}
			} else if (isElementPresent(element)) {
				if (action != null) {
					switch (action) {
					case "click":
						clickMethod(element, name);
						break;
					case "sendkey":
						sendKeysMethod(element, keyToSend);
						break;
					case "gettext":
						text = getTextElement(element, name);
						return text;
					default:
						logMessage("Swiped to element ");
						break;
					}
				}
				break;
			}
				if (previousSource != null) {
					endPage = previousSource.equals(appDriver.getPageSource());
				}
			
		}
		if (endPage) {
			logErrorMessage("Element not found in the page");
		}
		return text;
	}

	/**
	 * @method Swipes up once when called.
	 */
	public void swipeUp() {
		Dimension windowSize = appDriver.manage().window().getSize();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeUp");
		Sequence swipeUp = new Sequence(finger, 1);
		swipeUp.addAction(
				finger.createPointerMove(Duration.ZERO, Origin.viewport(), windowSize.width / 2, windowSize.height / 2))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(700), Origin.viewport(), windowSize.width / 2, 0))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		appDriver.perform(Arrays.asList(swipeUp));
		logMessage("Swiped up");
	}

	/**
	 * @method Swipes down once when called.
	 */
	public void swipeDown() {
		Dimension windowSize = appDriver.manage().window().getSize();
		PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeDown");
		Sequence swipeDown = new Sequence(finger, 1);
		swipeDown
				.addAction(finger.createPointerMove(Duration.ZERO, Origin.viewport(), windowSize.width / 2,
						windowSize.height / 2))
				.addAction(finger.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
						windowSize.height / 2 - windowSize.height / 3, windowSize.height / 2 + windowSize.height / 2))
				.addAction(finger.createPointerUp(MouseButton.LEFT.asArg()));
		appDriver.perform(Arrays.asList(swipeDown));
		logMessage("Swiped Down");
	}

	/**
	 * @Method Delete's all the texts
	 * @param filePath
	 * @throws FileNotFoundException
	 */
	public static void emptyFile(String filePath) throws FileNotFoundException {
		PrintWriter writer = new PrintWriter(filePath);
		writer.print("");
		writer.close();
	}

	/**
	 * @Method Swipes the given element horizontal until the endElement appears.
	 * @param ele
	 * @param swipedirection
	 * @return
	 * @throws Exception
	 */
	public String swipeHorizontalToElement(WebElement startEle, WebElement endElement, String swipedirection,
			String action, String name, String keyToSend) throws Exception {
		String text = null;
		int scrollPoints = 0;
		Point elementLocation = startEle.getLocation();
		switch (swipedirection) {
		case "Left":
			boolean leftendPage = false;
			String leftpreviousSource = null;
			while (!leftendPage) {
				leftpreviousSource = appDriver.getPageSource();
				if (!isElementPresent(endElement)) {
					PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeHorizontal");
					Sequence swipeLeft = new Sequence(finger1, 1);
					swipeLeft
							.addAction(finger1.createPointerMove(Duration.ZERO, Origin.viewport(), elementLocation.x,
									elementLocation.y))
							.addAction(finger1.createPointerDown(MouseButton.LEFT.asArg())).addAction(finger1
									.createPointerMove(Duration.ofMillis(700), Origin.viewport(), 0, elementLocation.y))
							.addAction(finger1.createPointerUp(MouseButton.LEFT.asArg()));
					appDriver.perform(Arrays.asList(swipeLeft));
					scrollPoints++;
					if (scrollPoints > 10) {
						logErrorMessage(" Element not found ");
						break;
					}
				} else if (isElementPresent(endElement)) {
					if (action != null) {
						switch (action) {
						case "click":
							clickMethod(endElement, name);
							break;
						case "sendkey":
							sendKeysMethod(endElement, keyToSend);
							break;
						case "gettext":
							text = getTextElement(endElement, name);
							return text;
						default:
							logMessage("Swiped to element ");
							break;
						}
					}
					break;
				}
				leftendPage = leftpreviousSource.equals(appDriver.getPageSource());
			}
			if (leftendPage) {
				logErrorMessage("Element not found in the page");
			}

		case "Right":
			boolean rightendPage = false;
			String rightpreviousSource = null;
			while (!rightendPage) {
				rightpreviousSource = appDriver.getPageSource();
				if (!isElementPresent(endElement)) {
					PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
					Sequence swipeRight = new Sequence(finger2, 1);
					swipeRight
							.addAction(finger2.createPointerMove(Duration.ZERO, Origin.viewport(), elementLocation.x,
									elementLocation.y))
							.addAction(finger2.createPointerDown(MouseButton.LEFT.asArg()))
							.addAction(finger2.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
									elementLocation.x * 2, elementLocation.y))
							.addAction(finger2.createPointerUp(MouseButton.LEFT.asArg()));
					appDriver.perform(Arrays.asList(swipeRight));
					scrollPoints++;
					if (scrollPoints > 10) {
						logErrorMessage(" Element not found ");
						break;
					}
				} else if (isElementPresent(endElement)) {
					if (action != null) {
						switch (action) {
						case "click":
							clickMethod(endElement, name);
							break;
						case "sendkey":
							sendKeysMethod(endElement, keyToSend);
							break;
						case "gettext":
							text = getTextElement(endElement, name);
							return text;
						default:
							logMessage("Swiped to element ");
							break;
						}
					}
					break;
				}
				rightendPage = rightpreviousSource.equals(appDriver.getPageSource());
			}
			if (rightendPage) {
				logErrorMessage("Element not found in the page");
			}
		}
		return text;
	}

	/**
	 * @this method is to swipe the given element left or right
	 * @param ele
	 * @param swipedirection
	 * @throws Exception
	 */
	public void swipeElement(WebElement ele, String swipedirection) throws Exception {
		if (!isElementPresent(ele)) {
			Point elementLocation = ele.getLocation();
			switch (swipedirection) {
			case "Left":
				PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "fingerswipeElement");
				Sequence swipeLeft = new Sequence(finger1, 1);
				swipeLeft
						.addAction(finger1.createPointerMove(Duration.ZERO, Origin.viewport(), elementLocation.x,
								elementLocation.y))
						.addAction(finger1.createPointerDown(MouseButton.LEFT.asArg())).addAction(finger1
								.createPointerMove(Duration.ofMillis(700), Origin.viewport(), 0, elementLocation.y))
						.addAction(finger1.createPointerUp(MouseButton.LEFT.asArg()));
				appDriver.perform(Arrays.asList(swipeLeft));
				break;

			case "Right":
				PointerInput finger2 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
				Sequence swipeRight = new Sequence(finger2, 1);
				swipeRight
						.addAction(finger2.createPointerMove(Duration.ZERO, Origin.viewport(), elementLocation.x,
								elementLocation.y))
						.addAction(finger2.createPointerDown(MouseButton.LEFT.asArg()))
						.addAction(finger2.createPointerMove(Duration.ofMillis(700), Origin.viewport(),
								elementLocation.x * 2, elementLocation.y))
						.addAction(finger2.createPointerUp(MouseButton.LEFT.asArg()));
				appDriver.perform(Arrays.asList(swipeRight));
				break;

			}
		} else {
			logErrorMessage("Element not in view");
		}
	}

	/**
	 * @method Performs click in the given Coordinates.
	 * @param x
	 * @param y
	 */
	public void clickByCoordinate(int x, int y) {
		PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger");
		Sequence swipeLeft = new Sequence(finger1, 1);
		swipeLeft.addAction(finger1.createPointerMove(Duration.ZERO, Origin.viewport(), x, y))
				.addAction(finger1.createPointerDown(MouseButton.LEFT.asArg()))
				.addAction(finger1.createPointerUp(MouseButton.LEFT.asArg()));
		appDriver.perform(Arrays.asList(swipeLeft));
	}

	/**
	 * @method Returns value from json for the given key.
	 * @param json
	 * @param key
	 * @return
	 */
	public Object getValuefromJson(JSONObject json, String key) {

		return json.get(key);

	}

}