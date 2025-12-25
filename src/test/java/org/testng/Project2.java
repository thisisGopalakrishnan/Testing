package org.testng;


import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.utility_package.Helper;

public class Project2 extends Helper{
	
	@Parameters("browser")
	@Test
	public void navenlab_Automation(String browsername) {
		
	launch_browser(browsername, "https://naveenautomationlabs.com/opencart/index.php?route=account/login");
		
		
	}
	
	
	
}
