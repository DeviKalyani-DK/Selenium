package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class Autosuggestions extends BaseClass{
	
	@Test
	public void autoSugg() {
		open("chrome");
		driver.get("http://www.google.com");
		driver.findElement(By.id("APjFqb")).sendKeys("selenium");
		
		List<WebElement> opt=driver.findElements(By.xpath("//div[@role='option']//b"));
		
		opt.size();
		for(WebElement auto:opt) {
			System.out.println(auto.getText());
			if(auto.getText().contains("webdriver")) {
				auto.click();
				break;
			}
		}
		
	}

}
