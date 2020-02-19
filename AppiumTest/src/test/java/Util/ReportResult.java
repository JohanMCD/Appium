package Util;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

public class ReportResult {
	private static String basePath = System.getProperty("user.dir") + File.separator;
	static int contador = 1;
	static File file;
	
	//Validate the step and return result
	public static boolean ValidateStep(boolean verify, ExtentReports logger, String coments, boolean validate){
		if(verify){
			if (validate){
				logger.log(LogStatus.PASS, coments,"Done");
				return true;
			}else {
				logger.log(LogStatus.FATAL, coments," Not Done");
				CreatePrintScreen(logger);
				return false;
			}
		} else if(!verify){
			logger.log(LogStatus.FATAL, coments," Not Done");
			CreatePrintScreen(logger);
			return false;
		}else{
			logger.log(LogStatus.SKIP, coments," Not RUN");
			return false;
		}
	} 
	
	//Validate the step and return result
		public static boolean ValidateStep(boolean verify, ExtentReports logger, String coments){
			if(verify){
				logger.log(LogStatus.PASS, coments,"Done");
				return true;
			} else if(!verify){
				logger.log(LogStatus.FATAL, coments," Not Done");
				CreatePrintScreen(logger);
				return false;
			}else{
				logger.log(LogStatus.SKIP, coments," Not RUN");
				return false;
			}
		} 

	private static void CreatePrintScreen(ExtentReports logger){
		 BufferedImage pantalla= null;
		 try {
			Robot robot = new Robot();
			pantalla = robot.createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
			file = new File(basePath + "report" + File.separator + "captura" + contador + ".png");
			ImageIO.write(pantalla, "png", file);
			logger.attachScreenshot(file.getCanonicalPath() );
		} catch (Exception e) {
		   e.printStackTrace();
		   System.err.println(e.getMessage());
		   System.err.println(e.getCause());
		}	
		 contador++;
	}
	
	//wait a few sec
		public static void WaitForSec(WebDriver driver, int segundos) {
			synchronized (driver) {
				try {
					driver.manage().timeouts().implicitlyWait(segundos, TimeUnit.SECONDS);
					driver.wait(segundos * 1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}
