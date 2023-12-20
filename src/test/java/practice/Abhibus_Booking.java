package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import base.BaseClass;

public class Abhibus_Booking extends BaseClass{
	
	@Test
	public void bookingTicket() throws Throwable {
		open("chrome");
		driver.get("https://www.abhibus.com/");
		
		//start
		String start="Hyderabad Airport RGIA";
		WebElement start_place=driver.findElement(By.xpath("//input[@placeholder='From Station']"));
		start_place.sendKeys(start.substring(0, 3));
		
		Thread.sleep(1000);
		List<WebElement> start_stations=driver.findElements(By.xpath("//div[@class='row ']/div[@class=' col']"));
		
		for(WebElement station:start_stations) {
			if(start.equals(station.getText())) {
				station.click();
				break;
			}
		}
		
		//destination
		String end="Vijayawada";
		WebElement end_place=driver.findElement(By.xpath("//input[@placeholder='To Station']"));
		end_place.sendKeys(end.substring(0, 3));
		
		Thread.sleep(1000);
		List<WebElement> end_stations=driver.findElements(By.xpath("//div[@class='row ']/div[@class=' col']"));
		
		for(WebElement station:end_stations) {
			if(end.equals(station.getText())) {
				station.click();
				break;
			}
		}
		
		//calender
		String user_Mon="December";
		String user_Year="2023";
		String user_Date="26";
		
    	boolean cal=calender(user_Year,user_Mon,user_Date);
    	if(!cal) {
    		System.out.println("There is no such Date");
    		return;
    	}
		
		
		//search
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		
		//notfound
		try{
			driver.findElement(By.xpath("//div[@id='not-found-container']"));
		
			System.out.println(driver.findElement(By.xpath("//div[@id='not-found-container']//h5")).getText());
		    return;
		}
		catch(Exception e) {
			
		
		
		
		//routes
		List<WebElement> routes=driver.findElements(By.xpath("//div[@class='container card service  md ']"));
		
		//sorted price
		List<WebElement> prices=driver.findElements(By.xpath("//div[@class='row ']//strong//span"));
		List<String> sorted_Prices=sort(prices);
		int size=sorted_Prices.size();
		
		for(WebElement r:routes) {
			String price=r.findElement(By.xpath(".//strong//span")).getText();
			if(price.equals(sorted_Prices.get(0))) {  //lowest price
				r.findElement(By.xpath(".//button")).click();
				break;
				
			}
		}
		}
			
		//select seats
		String[] user_seats= {"11","12","13"};
		
        boolean flag=false;
		List<WebElement> seats=driver.findElements(By.xpath("//table[@id='seat-layout-details']//button"));
		for(WebElement s:seats) {
			WebElement seat=s.findElement(By.xpath(".//span"));
			for(String st:user_seats) {
				
				if(st.equals(seat.getText())) {
					WebElement color=s.findElement(By.xpath("./*[name()='svg']/*[name()='rect']"));
					if(color.getAttribute("fill").equals("#DEDEDE")) {
						flag=true;
						System.out.println(seat.getText()+" is already booked");
						break;
					}
					s.click();
					
				}
			}
		}
			
		if(flag==false) {
			driver.findElement(By.xpath("//button[@class='btn btn-shake filled primary md inactive button']")).click();
			driver.findElement(By.xpath("//a[text()='Skip']")).click();
		}
		else {
			System.out.println("some seats are already booked... ");
			return;
		}
		
	//filling billing details
		String p1_name="devi";
		String p1_age="24";
		String p1_gender="Female";
		
		List<WebElement> persons=driver.findElements(By.xpath("//div[@class='container passengers-detail ']//div[@class='row ']"));
		for(WebElement p:persons) {
			p.findElement(By.xpath(".//div[@id='passenger-detail-name']//input")).sendKeys(p1_name);
			p.findElement(By.xpath(".//div[@id='passenger-detail-age']//input")).sendKeys(p1_age);
			if(p1_gender.equals("Male")) {
				p.findElement(By.xpath(".//div[@id='passenger-detail-gender']//button[text()='Male']")).click();
			}
			else {
				p.findElement(By.xpath(".//div[@id='passenger-detail-gender']//button[text()='Female']")).click();
			}
			
		}
		
		driver.findElement(By.xpath("//input[@placeholder='Enter Mobile Number']")).sendKeys("9876543212");
		driver.findElement(By.xpath("//input[@placeholder='Enter Email Address']")).sendKeys("devi@gmail.com");
		
		driver.findElement(By.xpath("//button[@class='btn  filled primary md inactive button']")).click();
}
	
	//calender
	public boolean calender(String user_Year,String user_Mon,String user_Date ) {
		
		driver.findElement(By.xpath("//input[@placeholder='Onward Journey Date']")).click();
		
		//month_year
		while(true) {
			
			List<WebElement> cal_MY=driver.findElements(By.xpath("//div[@class='container month ']/div[@class=' col']/span"));
			String cal_Mon=cal_MY.get(0).getText();
			String cal_Year=cal_MY.get(1).getText();
			
			List<WebElement> navigate=driver.findElements(By.xpath("//div[@class='container month ']//div[@class=' col auto']/span"));
			WebElement backward=navigate.get(0);
			WebElement forward=navigate.get(1);
			
			if(user_Year.equals(cal_Year) && user_Mon.equals(cal_Mon)) {
				break;
			}
			
			else if(Integer.parseInt(user_Year)>=Integer.parseInt(cal_Year)){
				if(forward.getText().equals(" ")) {
					return false;
				}
				forward.click();
			}
			else if(Integer.parseInt(user_Year)<=Integer.parseInt(cal_Year)) {
				if(backward.getText().equals(" ")) {
					return false;		
				}
				backward.click();
			}
			
		}
		
		//dates
		List<WebElement> dates=driver.findElements(By.xpath("//div[@class='container date ']/span[@tabindex='1']"));
		
		for(WebElement date:dates) {
			if(user_Date.equals(date.getText())) {
				date.click();
				break;
			}
		}
		return true;
	}
		
    //sorting
	public List<String> sort(List<WebElement> prices) {
		
		List<String> original=new ArrayList<String>();
		for(WebElement p:prices) {
			original.add(p.getText());
		}
		System.out.println(original);
		Collections.sort(original);
		System.out.println(original);
		return original;
	}

}
