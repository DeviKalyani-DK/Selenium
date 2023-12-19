package test;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseClass;

public class WindowHandles extends BaseClass{
	
	@Test
	public void redbus() {
		open("chrome");
		driver.get("https://www.redbus.in/");
		String parentWindow=driver.getWindowHandle();
		System.out.println(parentWindow);
		
		driver.findElement(By.xpath("//span[text()='Help']")).click();
		driver.findElement(By.xpath("//span[text()='Help']")).click();
		
		Set<String> windows=driver.getWindowHandles();
		System.out.println(windows);

		
		
		
		
		
	}

}
