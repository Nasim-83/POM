package com.crm.qa.testcase;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginPage;
	HomePage homePage;

	public LoginPageTest() throws IOException {
		super();

	}
	
	
	@BeforeMethod
	public void setup() throws InterruptedException, IOException
	{
		initilization();
		loginPage=new LoginPage();
	}
	
	@Test(priority = 1)
	public void loginPageTitleTest()
	{
		String title=loginPage.validateLoginpage();
		Assert.assertEquals(title, "Free CRM software for customer relationship management, sales, and support.");
		System.out.println(title);
	}
	
	@Test(priority = 2)
	public void crmImageTest()
	{
		boolean flag=loginPage.validateCRMimg();
		Assert.assertTrue(flag);
	}
	
	@Test(priority = 3)
	public void loginTest() throws IOException
	{
	homePage=loginPage.login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}

}
