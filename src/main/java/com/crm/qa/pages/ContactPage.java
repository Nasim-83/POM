package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() throws IOException, InterruptedException {
		super();
	
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath = "//a[contains(text(),'Nasim shaikh')]")
	WebElement contactName;
	
	
	public boolean verifycontactLabelTest() {
		
		return contactsLabel.isDisplayed();
		
	}
	
	public void verifycontactNameTest(String name) {
		
		
		driver.findElement(By.xpath("//a[@context='contact' and contains( text(),'"+name+"')]")).click();
		
		
	}
}
