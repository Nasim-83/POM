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

public class ContactPageTest extends TestBase {

	LoginPage loginpage;
	HomePage homepage;
	ContactPage contactpage;
	TestUtil testutil;
	public ContactPageTest() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@BeforeMethod
	private void setup() throws Exception {
		initilization();
		loginpage=new LoginPage();
		homepage=new HomePage();
		contactpage=new ContactPage();
		testutil=new TestUtil();
	homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	testutil.switchToFrame();
	contactpage=homepage.clickOnContactsLink();
	
		
			}

	@Ignore
	@Test(priority = 1)
	private void verifyContactLabel() {
		contactpage.verifycontactLabelTest();
		Assert.assertTrue(contactpage.verifycontactLabelTest(),"contact page label is missing");

	}
	@Ignore
	@Test(priority = 2)
	public void selectContactTest()
	{
		contactpage.verifycontactNameTest("test2 test2");
	}
	@Ignore
	@Test(priority = 3)
	public void selectmultiContactTest()
	{
		contactpage.verifycontactNameTest("test1 test1");
	}
	
	
	@AfterMethod
	private void teardown() {
		driver.quit();

	}
	
	@Test(priority = 4)
	private void validateCreateNewContactTest() throws InterruptedException {
		//testutil.switchToLeftframe();
	homepage.clickOnNewContactLink();
	contactpage.createNewContact("Tom1", "peter1", "yahoo");

	}
}
