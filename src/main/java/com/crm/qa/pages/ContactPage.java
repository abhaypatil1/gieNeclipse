package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactPage extends TestBase {

	public ContactPage() {
		PageFactory.initElements(driver, this);
	}

	// Object repository

	@FindBy(name = "title")
	WebElement title;

	@FindBy(name = "first_name")
	WebElement fname;

	@FindBy(name = "surname")
	WebElement lname;

	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement saveBtn;

	// Actions

	public void enterNewContactDetails(String strtitle, String strfname, String strlname) {
		Select select = new Select(title);
		select.selectByVisibleText(strtitle);
		fname.sendKeys(strfname);
		lname.sendKeys(strlname);
		saveBtn.click();

	}
}
