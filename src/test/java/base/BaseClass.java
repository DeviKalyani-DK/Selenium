package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class BaseClass {
	
	public WebDriver driver;
	
    @Test
    public WebDriver open(String browser) {
    	if(browser.equals("chrome")) {
    		driver=new ChromeDriver();
    	}
    	else if(browser.equals("edge")) {
    		driver=new EdgeDriver();
    	}
    	else if(browser.equals("firefox")) {
    		driver=new FirefoxDriver();
    	}
    	
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    	driver.manage().window().maximize();
    	
    	return driver;
    	
    }

}
