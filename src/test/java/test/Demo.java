package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;



public class Demo extends BaseClass{
	
	@Test
	public void openBrowser() throws InterruptedException {
		
		open("chrome");
		driver.get("http://trytestingthis.netlify.app/");
		
		WebElement firstname=driver.findElement(By.xpath("//form[@oninput='x.value=parseInt(a.value)']//input[1]"));
		firstname.sendKeys("devi");
		WebElement lastname=driver.findElement(By.id("lname"));
		lastname.sendKeys("viswanadhula");
		
		WebElement radio=driver.findElement(By.id("male"));
		//radio.click();
		System.out.println(radio.isSelected());
		
		driver.findElement(By.xpath("//p[text()='Some text..']")).isDisplayed();
	
//		WebDriverWait wait=new WebDriverWait(driver, 15);
//		wait.until(ExpectedConditions.visibilityOfElementLocated(null));
		
	}
	

}
