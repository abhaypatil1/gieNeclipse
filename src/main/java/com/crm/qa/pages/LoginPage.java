package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page factory OR
	@FindBy(name = "username") // Ths code is equivalent to :: WebElement username =
							// driver.findElement(By.xpath("//input[@name='email']"))
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[contains(@Class,'btn btn-small')]")
	WebElement loginBtn;

	@FindBy(xpath = "/html/body/div[2]/div/a/font")
	WebElement loginPgLink;

	public LoginPage() {
		//PageFactory.initElements(driver, LoginPage.class);
		PageFactory.initElements(driver, this);
	}
	
	// Actions

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean verifyLink() {
		return loginPgLink.isDisplayed();
	}

	public HomePage login(String strUsername, String strPassword) {
		username.sendKeys(strUsername);
		password.sendKeys(strPassword);
		loginBtn.click();
		return new HomePage();
	}

}
