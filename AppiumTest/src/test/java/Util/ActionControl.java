package Util;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.relevantcodes.extentreports.ExtentReports;

public class ActionControl {
	static WebDriverWait wait;
	static ExtentReports logger;
	public static RemoteWebDriver driver;
	public static WebElement element;
	
	public static void SetDriver(RemoteWebDriver driverNew) {
		driver = driverNew;
	}
	
	//WAIT FOR SECOND 
	public static void WaitForSec(int second) {
		synchronized (driver) {
			try {
				driver.manage().timeouts().implicitlyWait(second, TimeUnit.SECONDS);
				driver.wait(second * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	//SEARCH PROPERTY
	public static String Properties(String properties) {
		String property = ".//*[@" + properties + "]";
		return property;
	}

	//CLICK TO BUTTON
	public static boolean ClickToButton(By by, int waitTime) {
		WaitForSec(waitTime);
		element = driver.findElement(by);
		if(element.isEnabled()){
			element.click();
			return true;
		}
		return false;
	}
	
	//DO SUBMIT TO BUTTON
	public static void SubmitToButton(By by, int waitTime) {
		WaitForSec(waitTime);
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).submit();
	}
	
	//SET TEXT 
	public static void SetText(By by, String value, int waitTime) {
		WaitForSec(waitTime);
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.presenceOfElementLocated(by));
		driver.findElement(by).sendKeys(value);
	}
	
	public static void ExecuteJavaScriptCode(String code, int second){
		ActionControl.WaitForSec(second);
		try {
			((JavascriptExecutor) driver).executeAsyncScript(code);
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	//IS DISPLAYED
	public static boolean IsDiplayed(By by, int waitTime){
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by).isDisplayed();
	}
	
	//IS ENABLED
	public static boolean IsEnabled(By by, int waitTime){
		wait = new WebDriverWait(driver, waitTime);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
		return driver.findElement(by).isEnabled();
	}
	
	public static void ClosePopup() {
		WaitForSec(2);
		driver.findElementById("com.android.chrome:id/positive_button").click();
		WaitForSec(2);
		driver.findElementById("com.android.chrome:id/positive_button").click();	
	}
}
