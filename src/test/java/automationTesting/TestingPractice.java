package automationTesting;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class TestingPractice extends BaseClass{
	
	@Test
	public void fillWebsite() throws InterruptedException {
		open("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
		
		//text
		driver.findElement(By.id("name")).sendKeys("Devi Kalyani");
		driver.findElement(By.id("email")).sendKeys("devi@gmail.com");
		driver.findElement(By.id("phone")).sendKeys("9876543201");
		driver.findElement(By.id("textarea")).sendKeys("Hello, this is devikalyani. Nice to meet you.");
		
		//radiobuttons
		driver.findElement(By.id("male")).click();
		driver.findElement(By.id("female")).click();
		
		//checkboxes
		List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
		for (WebElement checks : checkboxes) {
			checks.click();
		}
		
		//dropdown
		WebElement dropdown=driver.findElement(By.id("country"));
		Select dd=new Select(dropdown);
		dd.selectByIndex(2);
		Thread.sleep(1500);
		dd.selectByValue("australia");
		Thread.sleep(1500);
		dd.selectByVisibleText("India");
		
		WebElement dropdown_2=driver.findElement(By.id("colors"));
		Select dd2=new Select(dropdown_2);
		dd2.selectByIndex(1);
		Thread.sleep(1500);
		dd2.selectByValue("green");
		Thread.sleep(1500);
		dd2.selectByVisibleText("White");
		
		//new browser window
		String windowHandleBefore=driver.getWindowHandle();
		System.out.println("Window Parent"+windowHandleBefore);
		
		driver.findElement(By.xpath("//button[text()='New Browser Window']")).click();
		Set<String> handles=driver.getWindowHandles();	
		System.out.println(handles);
		
		List<String> window_handles=new ArrayList<String>(handles);
		System.out.println(window_handles);
		
		if(window_handles.size()<=2) {
			driver.switchTo().window(window_handles.get(1));
			driver.findElement(By.name("search")).sendKeys("devi");
		}
		
		driver.switchTo().window(windowHandleBefore);
		
		
		//Alert
		WebElement alert=driver.findElement(By.xpath("//button[text()='Alert']"));
		alert.click();
		
		Alert al=driver.switchTo().alert();
		al.accept();
		
		Thread.sleep(1500);
		
		WebElement confirm_box=driver.findElement(By.xpath("//button[text()='Confirm Box']"));
		confirm_box.click();

		al=driver.switchTo().alert();
		al.dismiss();
		
		Thread.sleep(1200);
		
		WebElement prompt=driver.findElement(By.xpath("//button[text()='Prompt']"));
		prompt.click();
		al=driver.switchTo().alert();
		al.sendKeys("devikalyani");
		al.accept();
		
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
		
		WebElement slider=driver.findElement(By.xpath("//div[@id='slider']/span"));
		ac.dragAndDropBy(slider, 30, 0).perform();
				
		
		
		
		
		
		
		
	   
		
		
		
		
	}

}
