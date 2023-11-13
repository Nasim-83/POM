package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
	@FindBy(css = "#first_name")
	WebElement firstName;

	@FindBy(css = "#surname")
	WebElement lastName;
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;

	@FindBy(xpath = "//input[@name='client_lookup']")
	WebElement companyName;

	@FindBy(xpath = "//input[@type='submit' and @value='Save']")
	WebElement saveButoon;

	public boolean verifycontactLabelTest() {

		return contactsLabel.isDisplayed();

	}

	public void verifycontactNameTest(String name) {

		driver.findElement(By.xpath("//a[@context='contact' and contains( text(),'" + name + "')]")).click();

	}
	
	

	public void createNewContact(String ftName, String ltName, String cName) {

//		Select select = new Select(driver.findElement(By.xpath("//select[@name='title']")));
//		select.selectByVisibleText(title);
		firstName.sendKeys(ftName);
		lastName.sendKeys(ltName);
		companyName.sendKeys(cName);
		saveButoon.click();

	}
}
