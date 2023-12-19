package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import base.BaseClass;

public class ActionsDemo_2 extends BaseClass{
	
	@Test
	public void actdemo() throws Throwable {
		open("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
	
		//actions class
		Actions ac=new Actions(driver);
		
		//double click
		WebElement doubleck=driver.findElement(By.xpath("//button[text()='Copy Text']"));
		ac.doubleClick(doubleck).perform();
		
		//right click
		ac.contextClick().perform();
		
		//drag and drop
		WebElement source=driver.findElement(By.id("draggable"));
		WebElement destination=driver.findElement(By.id("droppable"));
		
		ac.dragAndDrop(source, destination).perform();
		
		Thread.sleep(3000);
		driver.close();
		
	}

}
