package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	// Page factory OR
	@FindBy(xpath = "//td[contains(text(),'Demo User')]")
	WebElement userLabel;

	@FindBy(xpath = "//td[contains(text(),'CRMPRO')]")
	WebElement homePageLogo;

	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement dealsLink;

	@FindBy(xpath = "//a[contains(text(),'Contact')]")
	WebElement contactLink;

	@FindBy(xpath = "//a[contains(text(),'Task')]")
	WebElement taskLink;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement contactSubLnk;
			
	// Actions

	public String verifyUserName() {
		String text = null;
		if (userLabel.isDisplayed()) {
			text = userLabel.getText();
		}
		return text;
	}

	public boolean verifyHomePageLogo() {
		return homePageLogo.isDisplayed();
	}

	public DealsPage clickOnDealLink() {
		boolean flagclick = dealsLink.isDisplayed();
		dealsLink.click();
		return new DealsPage();
	}

	public ContactPage clickOnContactLink() {
		boolean flagContact = contactLink.isDisplayed();
		contactLink.click();
		return new ContactPage();// flagContact;
	}
	
	public void clickContactSubLink()
	{
		Actions action = new Actions(driver);
		action.moveToElement(contactLink).build().perform();
		contactSubLnk.click();
	}

}
