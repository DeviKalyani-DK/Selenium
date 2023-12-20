package practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class WebTable extends BaseClass{
	
	@Test
	public void tableRead() {
		open("chrome");
		driver.get("https://cosmocode.io/automation-practice-webtable/");
		String text="India";
		
		WebElement table=driver.findElement(By.id("countries"));
		
		List<WebElement> rows=table.findElements(By.xpath(".//tr"));
		
		System.out.println(rows.size());
		
		for(WebElement row:rows) {
			List<WebElement> cells=row.findElements(By.xpath(".//td"));
			for(WebElement cell:cells) {
				if(text.equals(cell.getText())) {
					row.findElement(By.xpath(".//input")).click();
					return;
				}
			}
			
		}
	}

}
