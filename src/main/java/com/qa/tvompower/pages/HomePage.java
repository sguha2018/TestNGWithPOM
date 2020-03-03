package com.qa.tvompower.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tvompower.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Create an Account') and @class='mpower-button button-red']")
	public WebElement createAccountButton;

	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}

	//Actions:
	public String validateHomePageTitle(){
		return driver.getTitle();
	}
	
	public boolean createAccountButtonDisplayed() {
		return createAccountButton.isDisplayed();
	}
	
	public void clickOnCreateAccount(){
		createAccountButton.click();
	}

}
