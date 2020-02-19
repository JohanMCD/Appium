package SystemRun;
import Tests.Login;
import Tests.Logout;
import Tests.Check;
import java.net.MalformedURLException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Util.ActionControl;
import Util.MobileDevices;

public class SystemTest {

	RemoteWebDriver driver;

	@BeforeTest
	public void StartConfigutations () throws MalformedURLException{
		driver = MobileDevices.StartMobileConfigurations(driver);
		driver.get("https://capitole-consulting.com/");
		ActionControl.SetDriver(driver);
	}
	
	@Test  //REGRETION
	public void RunTst()  {
		
		//LOGIN STEP
		Login.Execute();
		
		//DO CHECK-IN OR CHECK-OUT
		Check.Execute("in");
		
		//LOGOUT STEP
		Logout.Execute();
	}
	
	@AfterTest
	public void EndText () {
		driver.quit();
	}
}