package sfdc.tests;

import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Listeners;
import com.aventstack.extentreports.Status;

//import org.testng.asserts.SoftAssert;
import sfdc.utilities.ListenersUtilities;
import sfdc.pages.ContactsPage;
import sfdc.pages.CreateAccountPage;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;


@Listeners(ListenersUtilities.class)
public class Contacts extends BaseTest
{
	@BeforeSuite
	public void setUp()
	{		
		driver = getDriver("chrome");		
		initializeReport("Contacts");		

	}
	@AfterSuite
	public void finishTest()
	{
		report.flush();
	}
	
	
	/*@BeforeMethod
	public void launchApp() throws IOException, InterruptedException {	
		driver = getDriver("chrome");
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		contactsPage = new ContactsPage(driver);
		bu.waitForElement(loginPage.eUserName,driver);
		Thread.sleep(5000);
		//WebElement userName =driver.findElement(By.name("username"));
		//bu.waitForElement(userName,driver);
	}*/
	
	@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
	public void loginToApp() throws IOException, InterruptedException{	
		
		driver = getDriver("chrome");
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		contactsPage = new ContactsPage(driver);
		//bu.waitForElement(loginPage.eUserName,driver);
		Thread.sleep(5000);
				
	}	
	
	@AfterMethod
	public void exit() throws InterruptedException {

		driver.quit();
		Thread.sleep(5000);
	}


		@Test
		public  void CreateNewContact_TC25() throws IOException, InterruptedException{
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);	
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eNew);
		bu.clickOnElement(contactsPage.eNew);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(contactsPage.eLastName);
		bu.clickOnElement(contactsPage.eLastName);
		bu.clearText(contactsPage.eLastName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.lastName"), contactsPage.eLastName);
		Thread.sleep(9000);
		
		bu.isElementVisible(contactsPage.eAccountName);
		bu.clickOnElement(contactsPage.eAccountName);
		Thread.sleep(5000);
		bu.clearText(contactsPage.eAccountName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.accountName"),contactsPage.eAccountName);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eSave);
		bu.clickOnElement(contactsPage.eSave);
		Thread.sleep(5000);
		}	
		
		
		@Test
		public  void createNewViewInContact_TC26() throws IOException, InterruptedException{	
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
		
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eCreateNewView);
		bu.clickOnElement(contactsPage.eCreateNewView);
		Thread.sleep(5000);
				
		bu.isElementVisible(contactsPage.eViewName);
		bu.clickOnElement(contactsPage.eViewName);
		bu.clearText(contactsPage.eViewName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.viewName"), contactsPage.eViewName);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eViewUniqueName);
		bu.clickOnElement(contactsPage.eViewUniqueName);
		bu.clearText(contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.viewUniqueName"), contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		bu.isElementVisible(contactsPage.eSave);
		bu.clickOnElement(contactsPage.eSave);	
		Thread.sleep(5000);
		
		}
		
		@Test
		public void checkRecentlyCreatedContact_TC27() throws IOException, InterruptedException{		
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.ERecent);
		bu.clickOnElement(contactsPage.ERecent);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(contactsPage.eRecentlyCreated);
		bu.clickOnElement(contactsPage.eRecentlyCreated);
		Thread.sleep(5000);
		
		}
		@Test
		public void checkMyContactsView_TC28()  throws IOException, InterruptedException{
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);	
			
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
			
		bu.isElementVisible(contactsPage.eVIewDropDown);
		bu.clickOnElement(contactsPage.eVIewDropDown);	
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eMyContacts);
		bu.clickOnElement(contactsPage.eMyContacts);
		Thread.sleep(5000);
		}
		
		@Test
		public void ViewAcontact_TC29() throws IOException, InterruptedException{
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
			
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
				
		bu.isElementVisible(contactsPage.eContactName);
		bu.clickOnElement(contactsPage.eContactName);
		Thread.sleep(5000);
		}
		
		@Test
		public void checkErrorMessage_TC30() throws IOException, InterruptedException{
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eCreateNewView);
		bu.clickOnElement(contactsPage.eCreateNewView);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eViewUniqueName);
		bu.clearText(contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.efgh"), contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eSave);
		bu.clickOnElement(contactsPage.eSave);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eViewNameErrorMsg);
		bu.readTextFromElement(contactsPage.eViewNameErrorMsg);
		Thread.sleep(5000);
		
		SoftAssert a1=new SoftAssert();
		String actualErrorMsg= (contactsPage.eViewNameErrorMsg.getText());//driver.findElement(By.id("error")).getText();
		a1.assertEquals(actualErrorMsg,dataUtil.readValidationText("contact.error"));
		a1.assertAll();	
		Thread.sleep(5000);
		
		
		}	
		
		@Test
		public void checkCancelButton_TC31() throws IOException, InterruptedException{
		
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
			
			
		bu.isElementVisible(contactsPage.eContactsTab);
		bu.clickOnElement(contactsPage.eContactsTab);
		Thread.sleep(5000);
			
		bu.isElementVisible(contactsPage.eCreateNewView);
		bu.clickOnElement(contactsPage.eCreateNewView);
		Thread.sleep(5000);
		
		bu.isElementVisible(contactsPage.eViewName);
		bu.clearText(contactsPage.eViewName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.abcd"), contactsPage.eViewName);
		Thread.sleep(5000);
		bu.isElementVisible(contactsPage.eViewUniqueName);
		bu.clearText(contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.efgh"), contactsPage.eViewUniqueName);
		Thread.sleep(5000);
		bu.isElementVisible(contactsPage.eCancel);
		bu.clickOnElement(contactsPage.eCancel);		
		Thread.sleep(5000);
		}	
		@Test
		public void checkSaveAndNewButtonInNewContact_TC32() throws IOException, InterruptedException{
			
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
			Thread.sleep(5000);
			bu.clickOnElement(loginPage.eLoginButton);
			Thread.sleep(5000);
			
			bu.isElementVisible(contactsPage.eContactsTab);
			bu.clickOnElement(contactsPage.eContactsTab);
			Thread.sleep(5000);
		
			bu.isElementVisible(contactsPage.eNew);
			bu.clickOnElement(contactsPage.eNew);
			Thread.sleep(5000);
			
			bu.isElementVisible(contactsPage.eLastName);
			bu.clickOnElement(contactsPage.eLastName);			
			bu.clearText(contactsPage.eLastName);
			Thread.sleep(5000);
			bu.sendText(dataUtil.readAccounts("prod.eLastName"), contactsPage.eLastName);
			Thread.sleep(5000);
			
			bu.isElementVisible(contactsPage.eAccountName);
			bu.clickOnElement(contactsPage.eAccountName);
			Thread.sleep(5000);
			bu.clearText(contactsPage.eAccountName);
			Thread.sleep(5000);
			bu.sendText(dataUtil.readAccounts("prod.eAccountName"),contactsPage.eAccountName);
			Thread.sleep(5000);
			
			bu.isElementVisible(contactsPage.eSaveAndNew);
			bu.clickOnElement(contactsPage.eSaveAndNew);
			Thread.sleep(5000);
			
			SoftAssert a2=new SoftAssert();
			String actualErrMsg= (contactsPage.invalidEntryError.getText());//driver.findElement(By.id("error")).getText();
			a2.assertEquals(actualErrMsg,dataUtil.readValidationText("contact.invalidEntryerror"));
			a2.assertAll();	
			Thread.sleep(5000);
						
		}	
		
}	





/*public class Contacts extends BaseTest{
/*static ContactsPage contactsPage;


//@Parameters("browser name")
	@BeforeSuite
	public void setUp(String browserName) throws Exception  {		
		//initializeLogging();		
		 driver= getDriver("chrome");
		 leadsPage = new LeadsPage(driver);			 
		 initializeReport();			
	}		
	//@Parameters("env name")
	@BeforeTest
	public void launchApp() throws IOException {		
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		bu.waitForElement(loginPage.eUserName,driver);
		
	}
	
	@BeforeMethod           
	public void loginToApp() throws IOException{			
				Assert.assertTrue(loginPage.isLoginPageDisplayed());
				bu.isElementVisible(loginPage.eUserName);
				bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
				
				bu.isElementVisible(loginPage.ePassword);
				bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
				
				bu.clickOnElement(loginPage.eLoginButton);	
				}	
*/








	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
				
		
		
