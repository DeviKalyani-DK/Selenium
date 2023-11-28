package test;

import org.testng.annotations.Test;

import base.BaseClass;



public class Demo extends BaseClass{
	
	@Test
	public void openBrowser() {
		open("chrome");
		driver.close();
	}
	

}
