package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseClass;

public class ActionsDemo_1 extends BaseClass{
	
	@Test
	public void flip() {
		
		open("chrome");
		driver.get("http://flipkart.com");
		driver.findElement(By.xpath("//span[@role='button']")).click();
		WebElement login= driver.findElement(By.xpath("//a[@href='/account/login?ret=/']"));
		
		Actions ac=new Actions(driver);
		ac.moveToElement(login).perform();
		
	}

}
