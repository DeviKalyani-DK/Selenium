package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;

public class W3proj extends BaseClass{
	
	@Test
	public void fileUp() throws Throwable {
		open("chrome");
		driver.get("https://www.w3schools.com/howto/howto_html_file_upload_button.asp");
		driver.findElement(By.xpath("//a[text()='Try it Yourself »']")).click();
		
		Set<String> wh=driver.getWindowHandles();
		List<String> windows=new ArrayList<String>(wh);
		
		driver.switchTo().window(windows.get(1));
		System.out.println(driver.getTitle());
	
		
		
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
//		WebElement uploadElement=driver.findElement(By.id("myFile"));
//		uploadElement.sendKeys("C:\\Users\\admin\\eclipse-workspace\\Images\\color_img.png");
		
	}

}
