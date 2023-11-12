package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.utils.TestUtil;

public class HomePageTest extends TestBase {

	
	
	
	LoginPage loginPage;
	HomePage homepage;
	TestUtil testutil;
	ContactPage contactPage;

	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setup() throws Throwable
	{
		initilization();
		loginPage=new LoginPage();
		homepage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testutil=new TestUtil();
		contactPage=new ContactPage();
		
	
	}
	
	@Test
	public void verifyhomePageTitleTest() {
		 String homePageTitle=  homepage.verifyHomePageTitle();
		 Assert.assertEquals(homePageTitle, "CRMPRO","message-homepage title is not correct");
		
	}
	
	@Test(priority =  2)
	
	public void verifyUserName()
	{
		testutil.switchToFrame();
		Assert.assertTrue(homepage.verifyCorrectUserName());
	}
	
	@Test(priority = 0)
	private void verifyContactLink() throws Exception  {
		testutil.switchToFrame();
	contactPage=homepage.clickOnContactsLink();

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}


}
