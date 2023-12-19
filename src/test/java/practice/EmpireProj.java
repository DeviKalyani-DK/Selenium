package practice;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import base.BaseClass;

public class EmpireProj extends BaseClass{
	
	@Test
	public void fileUpload() throws Throwable {
		open("chrome");
		driver.get("http://empirehome.myprojectsonline.co.in/");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("sureshbabuemp@gmail.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("ZPMHQHIA");
		driver.findElement(By.xpath("//button[text()='Login']")).click();
		
	    Thread.sleep(3000);
		driver.findElement(By.xpath("//i[@class='fa fa-houzz']")).click();
		driver.findElement(By.xpath("//a[text()='All Inventory']")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='btn btn-add']")).click();
		
		WebElement opt=driver.findElement(By.xpath("//select[@id='catDD']"));
		Select s=new Select(opt);
		s.selectByValue("729");
		
		driver.findElement(By.name("ModelNumber")).sendKeys("72984");
		driver.findElement(By.name("Title")).sendKeys("wood");
		driver.findElement(By.name("ItemDescription")).sendKeys("Its very strong in nature");
		driver.findElement(By.name("Brand")).sendKeys("iphone");
		driver.findElement(By.name("Height")).sendKeys("5.5 cm");
		driver.findElement(By.name("Width")).sendKeys("2.4 cm");
		driver.findElement(By.name("Breadth")).sendKeys("0.5 cm");
		driver.findElement(By.name("ColorName")).sendKeys("Blue");
		
		
		//first choose file
		WebElement text=driver.findElement(By.name("ColorImageUploaded"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",text);
		
		//primary_img.sendKeys("C:\\Users\\admin\\eclipse-workspace\\Images\\color_img.png");

		Robot rb=new Robot();
		rb.delay(2000);
		StringSelection ss=new StringSelection("C:\\Users\\admin\\eclipse-workspace\\Images\\color_img.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		WebElement InvStatus=driver.findElement(By.id("InventoryStatusId"));
		s=new Select(InvStatus);
		s.selectByValue("187");
		
		WebElement InvCondition=driver.findElement(By.id("InventoryConditonId"));
		s=new Select(InvCondition);
		s.selectByValue("473");
		
		WebElement InvLocation=driver.findElement(By.id("InventoryLocationId"));
		s=new Select(InvLocation);
		s.selectByValue("392");
		
		driver.findElement(By.id("actual")).sendKeys("50000");
		
		WebElement mrpLocator=driver.findElement(By.id("factor"));
		s=new Select(mrpLocator);
		s.selectByValue("124");
		
		driver.findElement(By.name("HSNCode")).sendKeys("HSN8706");
		driver.findElement(By.name("RackName")).sendKeys("Apple");
		driver.findElement(By.name("PODetails")).sendKeys("Hyderabad,Telangana");
		driver.findElement(By.name("InvoiceNumber")).sendKeys("34268347397237");
		driver.findElement(By.name("Qty")).sendKeys("5");
		
		//second choose file
		text=driver.findElement(By.name("ProductMainImageUploaded"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",text);
		
		rb=new Robot();
		rb.delay(2000);
		ss=new StringSelection("C:\\Users\\admin\\eclipse-workspace\\Images\\apple-iphone-mobile.png");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		
		//third choose file
		text=driver.findElement(By.name("ProductOtherImagesUploaded"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",text);

		rb=new Robot();
		rb.delay(2000);
		ss=new StringSelection("C:\\Users\\admin\\eclipse-workspace\\Images\\0010436_apple-iphone-11-256gb-product-red_510.jpeg");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
		//fourth choose file
		text=driver.findElement(By.name("DocumentsUploaded"));
		js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",text);

		rb=new Robot();
		rb.delay(2000);
		ss=new StringSelection("C:\\Users\\admin\\eclipse-workspace\\Images\\sept selenium.txt");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		
//		WebElement primary_Img=driver.findElement(By.name("ProductMainImageUploaded"));
//		primary_Img.sendKeys("C:\\Users\\admin\\eclipse-workspace\\Images\\apple-iphone-mobile.png");
//		
//		WebElement otherImg=driver.findElement(By.name("ProductOtherImagesUploaded"));
//		otherImg.sendKeys("C:\\Users\\admin\\eclipse-workspace\\Images\\0010436_apple-iphone-11-256gb-product-red_510.jpeg");
//		
//		WebElement documentsUpload=driver.findElement(By.name("DocumentsUploaded"));
//		documentsUpload.sendKeys("C:\\Users\\admin\\eclipse-workspace\\Images\\sept selenium.txt");
//		
		;
	}

}
