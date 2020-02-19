package Tests;

import org.openqa.selenium.By;

import Util.ActionControl;

public class Check {
	public static void Execute(String state) {
		
		//DO CLICK IN CHECK-IN  AND CHECK-OUT BUTTON
		ActionControl.ClickToButton(By.id("btnCheckIn"), 8);
			 
		//DO CLICK IN CHECK-OUT AND CHECK-IN  BUTTON 
		ActionControl.ClickToButton(By.id("btnCheckOut"), 8);
	}
}