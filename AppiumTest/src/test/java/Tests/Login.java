package Tests;

import org.openqa.selenium.By;
import Util.ActionControl;

public class Login {
	
	public static void Execute() {
		String user = "johancruz@capitole-consulting.com";
		String password = "Johan2212";
		
		//DO CLICK TO HAMBURGER MENU
		ActionControl.ClickToButton(By.xpath(".//a[@href='#']"), 3);
		
		//SELECT THE BUTTON EMPLOYEES
		ActionControl.ClickToButton(By.linkText("Employees"), 2);
		
		//PUT USER NAME
		ActionControl.SetText(By.id("UserName"), user, 4);
	
		//PUT PASSWORD
		ActionControl.SetText(By.id("Password"), password, 1);

		//CLOSE COOKIES
		ActionControl.ClickToButton(By.id("btn-dismiss"), 3);
		
		//CLICK TO BUTTON "Inciar sesión"
		ActionControl.SubmitToButton(By.xpath(".//input[@value='Iniciar sesión']"), 2);
	}
}
