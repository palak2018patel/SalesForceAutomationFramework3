package sfdc.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import com.aventstack.extentreports.Status;


//import sfdc.pages.LeadsPage;
import sfdc.pages.OpportunitiesPage;
import sfdc.pages.LoginPage;
import sfdc.utilities.ListenersUtilities;
@Listeners(ListenersUtilities.class)
public class Opportunities extends BaseTest{
	//static OpportunitiesPage optyPage;

	@BeforeSuite
	public void setUp() throws Exception  {		
		//initializeLogging();		
		 driver= getDriver("chrome");				 
		 initializeReport("CreateOpportunity");			
	}
	
	@AfterSuite
	public void finishTest()
	{
		report.flush();
	}
	
	@BeforeMethod
	public void launchApp() throws IOException, InterruptedException {		
		driver= getDriver("chrome");
		loginPage = new LoginPage(driver);	
		optyPage = new OpportunitiesPage(driver);	
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		Thread.sleep(3000);
		//bu.waitForElement(loginPage.eUserName,driver);
		//WebElement userName =driver.findElement(By.name("username"));
		//bu.waitForElement(userName,driver);
	}
	
	/*@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
	public void loginToApp() throws IOException, InterruptedException{			
				
	}	*/

	@Test
	public void selectOpportunitiesLink_TC15() throws IOException, InterruptedException{
	
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(3000);
		
	bu.isElementVisible(optyPage.optyLink);
	bu.clickOnElement(optyPage.optyLink);
	Thread.sleep(5000);

	bu.isElementVisible(optyPage.optyDropdown);
	bu.clickOnElement(optyPage.optyDropdown);	
	Thread.sleep(5000);
	
	String[] exp= {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities", "New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
    WebElement dropdown = optyPage.optyDropdown;
	Select select = new Select(dropdown);
	List<WebElement> dropdownvalues = select.getOptions();
	for (int i=0; i<dropdownvalues.size();i++)
	{ 
		Assert.assertEquals(exp[i], dropdownvalues.get(i).getText());
		test.log(Status.INFO, "Dropdown values displayed are correct");
		
	}
	}
	
	@Test
	public void createNewOpportunity_TC16() throws IOException, InterruptedException{
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(3000);
		
		bu.isElementVisible(optyPage.optyLink);
		bu.clickOnElement(optyPage.optyLink);
		Thread.sleep(5000);

		bu.isElementVisible(optyPage.optyDropdown);
		bu.clickOnElement(optyPage.optyDropdown);	
		Thread.sleep(5000);
		
		
	bu.isElementVisible(optyPage.createnewoptyBtn);
	bu.clickOnElement(optyPage.createnewoptyBtn);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.optyName);	
	bu.clickOnElement(optyPage.optyName);
	bu.clearText(optyPage.optyName);
	Thread.sleep(5000);
	bu.sendText(dataUtil.readAccounts("prod.optyName"),optyPage.optyName);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.AccName);
	bu.clickOnElement(optyPage.AccName);
	bu.clearText(optyPage.AccName);
	Thread.sleep(5000);
    bu.sendText(dataUtil.readAccounts("prod.accountName"), optyPage.AccName);
    Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.closeDate);
	bu.clickOnElement(optyPage.closeDate);
	bu.clearText(optyPage.closeDate);
	Thread.sleep(5000);
	bu.sendText(dataUtil.readAccounts("prod.closeDate"), optyPage.closeDate);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.yearDrpDown);
	bu.clickOnElement(optyPage.yearDrpDown);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.yearselection);
	bu.clickOnElement(optyPage.yearselection);	
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.stage);
	bu.clickOnElement(optyPage.stage);	
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.stageSelection);
	bu.clickOnElement(optyPage.stageSelection);	
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.probability);
	bu.clickOnElement(optyPage.probability);
	bu.clearText(optyPage.probability);
	Thread.sleep(5000);
	bu.sendText(dataUtil.readAccounts("prod.probability"), optyPage.probability);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.leadSource);
	bu.clickOnElement(optyPage.leadSource);	
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.leadSourceSelect);
	bu.clickOnElement(optyPage.leadSourceSelect);
	Thread.sleep(5000);
	
	bu.isElementVisible(optyPage.primaryCmpSrc);
	bu.clickOnElement(optyPage.primaryCmpSrc);
	bu.clearText(optyPage.primaryCmpSrc);
	Thread.sleep(5000);
	bu.sendText(" ", optyPage.primaryCmpSrc);
	Thread.sleep(5000);
		
	bu.isElementVisible(optyPage.Savebtn);
	bu.clickOnElement(optyPage.Savebtn);
	Thread.sleep(5000);
	
	
	}

	@Test
	public  void testOpportunityPipeline_TC17() throws IOException, InterruptedException{
	
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(3000);
		
		bu.isElementVisible(optyPage.optyLink);
		bu.clickOnElement(optyPage.optyLink);
		Thread.sleep(5000);
	
		bu.isElementVisible(optyPage.optyPipelineLink);
		bu.clickOnElement(optyPage.optyPipelineLink);
		Thread.sleep(5000);
		
	}
	@Test	
	public void testStuckOpportunitiesReport_TC18() throws IOException, InterruptedException{	
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		bu.isElementVisible(loginPage.ePassword);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(3000);
		
		bu.isElementVisible(optyPage.optyLink);
		bu.clickOnElement(optyPage.optyLink);
		Thread.sleep(5000);
			
		bu.isElementVisible(optyPage.stuckOpty);
		bu.clickOnElement(optyPage.stuckOpty);	
		Thread.sleep(5000);
		
	}
	@Test
	public void testQuarterlySummaryReport_TC19() throws IOException, InterruptedException{
		//bu.isElementVisible(optyPage.);
		//bu.clickOnElement();	
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(3000);
		
		bu.isElementVisible(optyPage.optyLink);
		bu.clickOnElement(optyPage.optyLink);
		Thread.sleep(5000);
	
		bu.isElementVisible(optyPage.selectionIntervallist);
		bu.clickOnElement(optyPage.selectionIntervallist);	
		Thread.sleep(5000);
	
		
		bu.isElementVisible(optyPage.CurrentNextFQfrominterval);
		bu.clickOnElement(optyPage.CurrentNextFQfrominterval);
		Thread.sleep(5000);
		
		bu.isElementVisible(optyPage.Includebox);
		bu.clickOnElement(optyPage.Includebox);	
		Thread.sleep(5000);
		
		bu.isElementVisible(optyPage.intervalselection);
		bu.clickOnElement(optyPage.intervalselection);
		Thread.sleep(5000);
		
	
		bu.isElementVisible(optyPage.runReport);
		bu.clickOnElement(optyPage.runReport);	
		Thread.sleep(5000);
	
	}
	
	@AfterMethod
	public void exit() throws InterruptedException
	{
		Thread.sleep(3000);
		driver.quit();
	}
}		
	
		
		
	//bu.isElementVisible(optyPage.);
	//bu.clickOnElement();	
	
	
	
	
	
	
	


