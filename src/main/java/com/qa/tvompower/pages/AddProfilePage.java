package com.qa.tvompower.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tvompower.base.TestBase;

public class AddProfilePage extends TestBase{
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement nextButton;
	
	//initializing page object
	public AddProfilePage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateAddProfilePageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateNextButtonDisplayed() {
		return nextButton.isDisplayed();
	}
}
