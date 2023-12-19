package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class Checkboxes extends BaseClass{
	
	@Test
	public void dropDown() {
		open("chrome");
		driver.get("https://testautomationpractice.blogspot.com/");
		List<WebElement> checkboxes = driver
				.findElements(By.xpath("//input[@class='form-check-input'][@type='checkbox']"));
		System.out.println(checkboxes.size());

		for (WebElement checks : checkboxes) {
			
			WebElement label=checks.findElement(By.xpath("following-sibling::*"));

			System.out.println(label.getText());
			if(label.getText().contains("Sunday")) {
				checks.click();
			}
			
			//checks.click();
		}

	}
}