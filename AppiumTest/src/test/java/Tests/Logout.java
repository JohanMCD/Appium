package Tests;

import Util.ActionControl;

public class Logout {
	public static void Execute() {
		
		//DO CLICK IN LOGOUT
		ActionControl.ExecuteJavaScriptCode("LogOut()",1);
		ActionControl.WaitForSec(3);
	}
}
