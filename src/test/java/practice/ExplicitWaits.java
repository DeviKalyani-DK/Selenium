package practice;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseClass;

public class ExplicitWaits extends BaseClass{

	@Test
	public void ExpWait() throws Throwable {
		open("chrome");
		driver.get("https://chercher.tech/practice/explicit-wait-sample-selenium-webdriver");
		
		//alert
		WebElement alert=driver.findElement(By.id("populate-text"));
		alert.click();
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		
		try{
			wait.until(ExpectedConditions.alertIsPresent());
			Alert al=driver.switchTo().alert();
			System.out.println("Is Alert Present: "+true);
			al.accept();	
		}
		catch(TimeoutException e) {
			System.out.println("Is Alert Present: "+false +" "+e.getMessage());
		}
//		catch(NoAlertPresentException e) {
//			System.out.println("Is Alert Present: "+false +" "+e.getMessage());
//		}
		
		
		//change text
		WebElement changeText=driver.findElement(By.id("populate-text"));
		changeText.click();
		
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("h2"), "Selenium Webdriver"));
		String text = driver.findElement(By.id("h2")).getText();
		if(text.equals("Selenium Webdriver")) {
			System.out.println("Is Text Changed: true"); }
		else { System.out.println("Is Text Changed: false"); }
		
		
		//display button
		WebElement disButton=driver.findElement(By.id("display-other-button"));
		disButton.click();
		
		wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("hidden")));
		System.out.println("Is button Displayed: "+driver.findElement(By.id("hidden")).isDisplayed());
		
		//enable button
		WebElement enaButton=driver.findElement(By.id("enable-button"));
		enaButton.click();
		
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("disable")));
		System.out.println("Is button Enabled: "+driver.findElement(By.id("disable")).isEnabled());
		
		//checkbox
		WebElement checkbox=driver.findElement(By.id("checkbox"));
		checkbox.click();
		
		wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.elementToBeSelected(By.id("ch")));
		System.out.println("Is checkbox Selected: "+driver.findElement(By.id("ch")).isSelected());
		
		//close the window
		Thread.sleep(3000);
		driver.close();
		
	}
}
