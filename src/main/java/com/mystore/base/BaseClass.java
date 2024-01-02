/**
 * 
 */
package com.mystore.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mystoreactiondriver.Action1;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static Properties prop;
	public static WebDriver driver;
	public static Action1 action = new Action1();
	public void loadconfig() {
       try {
    	   prop = new Properties();
    	   System.out.println("super constructer invoked");
    	   FileInputStream ip= new FileInputStream(System.getProperty("user.dir")+"\\configuration\\Config.properties");
    			   prop.load(ip);
    	   System.out.println("driver:"+driver); 
       } catch (FileNotFoundException e) {
    	   e.printStackTrace();
       } catch (IOException e ) {
    	   e.printStackTrace();
       }

}
    public static void launchApp(){
    	WebDriverManager.chromedriver().setup();
    	String browserName = prop.getProperty("browser");
    	
    	if(browserName.contains("Chrome")) {
    		driver = new ChromeDriver();
    	}else if (browserName.contains("FireFox")) {
    		driver = new FirefoxDriver();
    	}
    	
		
			action.implicitWait(driver, 10);
	        action.pageLoadTimeOut(driver, 30);
	        driver.get(prop.getProperty("url"));
    	
    }
}