package Util;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class MobileDevices {
	
	public static RemoteWebDriver StartMobileConfigurations(RemoteWebDriver driver){
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "Android"); 
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "emule-5556");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
		capabilities.setCapability("automationName", "UiAutomator2");
		capabilities.setCapability("browserName", "Chrome");
		capabilities.setCapability("chromedriverExecutable", "C:\\selenium_drivers\\chromedriver.exe");
		try {
			driver = new RemoteWebDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return driver;
	}
}
