package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;
import org.openqa.selenium.support.events.WebDriverEventListener;

import com.crm.qa.utils.TestUtil;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;


	public TestBase() throws IOException {
		
		 prop=new Properties();
		FileInputStream ffis = null;
		try {
			ffis = new FileInputStream("C:/Users/TiaaUser/Documents/selenium space/FreeCRMTest/src/main/java/com/crm/qa/config/config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				prop.load(ffis);
	}
	
	
	public  static void initilization() throws InterruptedException {
		
		String browserName=prop.getProperty("browser");
	
		driver=new ChromeDriver();
		
//		if(browserName.equals("Chrome"))
//		{
//			System.setProperty("webdriver.chrome.driver"," C:\\Users\\TiaaUser\\Documents\\chromedriver_win32 (3)\\chromedriver.exe");
//			
//		driver=new ChromeDriver();
//			//driver=new EdgeDriver();
//		}
//		else if(browserName.equals("ff"))
//		{
//			driver=new FirefoxDriver();
//		}
//		
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		driver.get(prop.getProperty("url"));
	

}
}
