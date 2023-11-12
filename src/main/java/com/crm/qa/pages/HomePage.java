package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;



public class HomePage extends TestBase {

	public HomePage() throws IOException {
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//td[contains(text(),'User: Nasim shaikh ')]")
	WebElement userNameLabel;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactLinkElement;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealLink;

	@FindBy(xpath = "//a[contains(text(),'Tasks')]")
	WebElement taskLink;
	
	public String verifyHomePageTitle () {
		return driver.getTitle();
	}
	
	public ContactPage clickOnContactsLink() throws Exception {
		
		contactLinkElement.click();
		return new ContactPage();
	}
	public boolean verifyCorrectUserName() {
	return	userNameLabel.isDisplayed();
		
	}
	
}
