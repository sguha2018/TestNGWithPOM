package com.qa.tvompower.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.tvompower.base.TestBase;

public class CreateAccountPage extends TestBase{
	
	@FindBy(xpath="//img[@id='mPowerHeaderLogo']")
	WebElement mPowerLogo;
	
	@FindBy(name="firstName")
	WebElement firstName;
	
	@FindBy(name="lastName")
	WebElement lastName;
	
	@FindBy(name="emailParent")
	WebElement email;
	
	@FindBy(name="userPassword")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit' and @id='registerSubmitParent']")
	WebElement createAccountButton;
	
	//initializing page object
	public CreateAccountPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String validateCreateAccountPageTitle(){
		return driver.getTitle();
	}
	
	public void fillCreateAccountDetails(String fname,String lname,String emailid,String pwd) {
		firstName.clear();
		firstName.sendKeys(fname);
		lastName.clear();
		lastName.sendKeys(lname);
		email.clear();
		email.sendKeys(emailid);
		password.clear();
		password.sendKeys(pwd);
		createAccountButton.click();
	}
}
