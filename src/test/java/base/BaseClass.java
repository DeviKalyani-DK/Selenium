package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public WebDriver driver;
	
    @Test
    public WebDriver open(String browser) {
    	if(browser.equals("chrome")) {
    		//System.setProperty("webdriver.chrome.driver","C:\\Users\\admin\\Downloads\\chromedriver-win64\\chromedriver.exe");
    		WebDriverManager.chromedriver().setup();
    		driver=new ChromeDriver();
    	}
    	else if(browser.equals("edge")) {
    		driver=new EdgeDriver();
    	}
    	else if(browser.equals("firefox")) {
    		driver=new FirefoxDriver();
    	}
    	
    	
    	driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    	
    	return driver;
    	
    }

}
