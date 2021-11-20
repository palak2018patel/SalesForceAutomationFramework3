package sfdc.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.Listeners;
import sfdc.utilities.ListenersUtilities;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;
@Listeners(ListenersUtilities.class)
public class Leads extends BaseTest {
	
	//static LeadsPage leadsPage;
		@BeforeSuite
		public void setUp() throws Exception  {		
			                    //initializeLogging();		
			 driver= getDriver("chrome");
			 initializeReport("Leads");			
		
		}
		@AfterSuite
		public void finishTest()
		{
			report.flush();
		}
		
		/*@BeforeMethod
		public void launchApp() throws IOException {
			driver = getDriver("chrome");
			driver.get(dataUtil.readAccounts("prod.url"));
			loginPage = new LoginPage(driver);	
			leadsPage = new LeadsPage(driver);		
			driver.manage().window().maximize();
			bu.waitForElement(loginPage.eUserName,driver);
			//WebElement userName =driver.findElement(By.name("username"));
			//bu.waitForElement(userName,driver);
		}
		*/
		@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
		public void loginToApp() throws IOException, InterruptedException{			
			driver = getDriver("chrome");
			driver.get(dataUtil.readAccounts("prod.url"));
			loginPage = new LoginPage(driver);	
			leadsPage = new LeadsPage(driver);		
			driver.manage().window().maximize();
			Thread.sleep(5000);
			//bu.waitForElement(loginPage.eUserName,driver);
			
					}
		
		@AfterMethod
		public void exit() {

			driver.quit();
		}

		@Test
		public void checkLeadsTabLink_TC20() throws InterruptedException, IOException{
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(3000);			
			bu.isElementVisible(leadsPage.eLeadsTab);
			bu.clickOnElement(leadsPage.eLeadsTab);
			Thread.sleep(5000);
			
			boolean leadsPageIsVisible=true;
			Assert.assertEquals(leadsPageIsVisible,bu.isElementVisible(leadsPage.eLeadIcon));
			test.log(Status.INFO, " You are on the Leads page");
			
			
		}
		
		@Test
		public void  LeadsSelectView_TC21() throws InterruptedException, IOException{
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(3000);
			
			bu.isElementVisible(leadsPage.eLeadsTab);
			bu.clickOnElement(leadsPage.eLeadsTab);
			Thread.sleep(5000);
			
			bu.isElementVisible(leadsPage.eViewLeads);
			bu.clickOnElement(leadsPage.eViewLeads);
			Thread.sleep(5000);
			
			bu.isElementVisible(leadsPage.eUserMenu);
			bu.clickOnElement(leadsPage.eUserMenu);
			Thread.sleep(5000);
			
			bu.isElementVisible(leadsPage.eLogOut);
			bu.clickOnElement(leadsPage.eLogOut);
			Thread.sleep(5000);
		}	
		
		@Test
		public void LeadsGoDefaultView_TC22()throws  InterruptedException,IOException{
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(3000);
			
			bu.isElementVisible(leadsPage.eLeadsTab);
			bu.clickOnElement(leadsPage.eLeadsTab);	
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eViewLeads);
			bu.clickOnElement(leadsPage.eViewLeads);
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eTodaysLead);
			bu.clickOnElement(leadsPage.eTodaysLead);	
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eUserMenu);
			bu.clickOnElement(leadsPage.eUserMenu);	
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eLogOut);
			bu.clickOnElement(leadsPage.eLogOut);	
			Thread.sleep(5000);
			driver.get(dataUtil.readAccounts("prod.url"));
			bu.waitForElement(loginPage.eUserName,driver);
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eLoginButton);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eLeadsTab);
			bu.clickOnElement(leadsPage.eLeadsTab);	
			Thread.sleep(5000);
			
			
			bu.isElementVisible(leadsPage.eGOLeads);
			bu.clickOnElement(leadsPage.eGOLeads);	
			Thread.sleep(5000);
		}	
		
		@Test
		public void TodaysLeads_TC23() throws InterruptedException, IOException{
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(3000);
			
			bu.isElementVisible(leadsPage.eLeadsTab);
			bu.clickOnElement(leadsPage.eLeadsTab);
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eViewLeads);
			bu.clickOnElement(leadsPage.eViewLeads);
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eTodaysLead);
			bu.clickOnElement(leadsPage.eTodaysLead);
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eUserMenu);
			bu.clickOnElement(leadsPage.eUserMenu);	
			Thread.sleep(5000);
			bu.isElementVisible(leadsPage.eLogOut);
			bu.clickOnElement(leadsPage.eLogOut);	
			Thread.sleep(5000);
			
		}		
				
		}

