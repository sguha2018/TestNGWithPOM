package com.qa.tvompower.testcases;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.tvompower.base.TestBase;
import com.qa.tvompower.pages.AddProfilePage;
import com.qa.tvompower.pages.CreateAccountPage;
import com.qa.tvompower.pages.HomePage;
import com.qa.tvompower.util.Utility;

public class CreateAccountPageTest extends TestBase{
	
	private HomePage homePage;
	private CreateAccountPage createAccountPage;
	private AddProfilePage profilePage;
	private String sheetName = "AccountDetails";
	
	@BeforeTest
	public void setUp() {
		setupDriver();
		homePage = new HomePage();
		createAccountPage = new CreateAccountPage();
		profilePage= new AddProfilePage();
	}
	
	@DataProvider
	public Object[][] getTvOmPowerTestData(){
		Object data[][] = Utility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=1)
	public void goToHomePage() {
		String homePageTitle=homePage.validateHomePageTitle();
		Assert.assertEquals(homePageTitle, prop.getProperty("homePageTitle"));
		homePage.clickOnCreateAccount();
	}
	
	@Test(dataProvider="getTvOmPowerTestData", priority=2)
	public void createAccountTvOmPower(String fname,String lname,String emailid,String pwd) {
		String createAccountPageTitle=createAccountPage.validateCreateAccountPageTitle();
		Assert.assertEquals(createAccountPageTitle, prop.getProperty("createAccountPageTitle"));
		
		String newEmailid=emailid+Math.random()+"@gmail.com";
		createAccountPage.fillCreateAccountDetails(fname,lname,newEmailid,pwd);
	}
	
	@Test(priority=3)
	public void verifyCreateAccount() {
		waitForPageToLoad(prop.getProperty("addProfilePageTitle"));
		String addProfilePageTitle = profilePage.validateAddProfilePageTitle();
		Assert.assertEquals(addProfilePageTitle, prop.getProperty("addProfilePageTitle"));
		Assert.assertTrue(profilePage.validateNextButtonDisplayed());
	}
	
	@AfterTest	
	public void tearDown() {
		driver.quit();
	}
}
