package sfdc.tests;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import org.testng.annotations.Listeners;
import sfdc.utilities.ListenersUtilities;
//import sfdc.pages.AllTabPage;
import sfdc.pages.CreateAccountPage;
import sfdc.pages.LoginPage;
@Listeners(ListenersUtilities.class)
public class CreateAccount extends BaseTest {

	// static CreateAccountPage createAccountPage;

	@BeforeSuite
	public void setUp() throws Exception{
		// initializeLogging();
		 driver= getDriver("chrome");
		initializeReport("CreateAccount");
	}

	@AfterSuite
	public void finishTest()
	{
		report.flush();
	}

	/*@BeforeMethod
	
	public void launchApp() throws IOException {

		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);

	}*/

	@BeforeMethod
	public void loginToApp() throws IOException, InterruptedException {
		driver = getDriver("chrome");
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		createAccountPage = new CreateAccountPage(driver);
		Thread.sleep(9000);
		//bu.waitForElement(loginPage.eUserName, driver);
		
	}

	@AfterMethod
	public void exit() throws InterruptedException {

		driver.quit();
		Thread.sleep(5000);
	}
	
	@Test
	public void create_An_Account_TC10() throws IOException, InterruptedException {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		test.log(Status.INFO,"Username entered");
		Thread.sleep(5000);
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		
		System.out.println("home page is displayed");
		Thread.sleep(5000);			
		
		bu.isElementVisible(createAccountPage.eAccountsTabLink);
		bu.clickOnElement(createAccountPage.eAccountsTabLink);

		bu.isElementVisible(createAccountPage.eNewAccBton);
		bu.clickOnElement(createAccountPage.eNewAccBton);

		bu.isElementVisible(createAccountPage.eNewAccName);
		bu.sendText(dataUtil.readAccounts("prod.newAccountName"), createAccountPage.eNewAccName);
		bu.clickOnElement(createAccountPage.eNewAccName);

		bu.isElementVisible(createAccountPage.eAccSave);
		bu.clickOnElement(createAccountPage.eAccSave);
	}

	@Test
	public void create_new_view_TC11() throws IOException, InterruptedException {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		test.log(Status.INFO,"Username entered");
		Thread.sleep(5000);
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		
		System.out.println("home page is displayed");
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccountsTabLink);
		bu.clickOnElement(createAccountPage.eAccountsTabLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccCreateNewView);
		bu.clickOnElement(createAccountPage.eAccCreateNewView);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccViewName);
		bu.clearText(createAccountPage.eAccViewName);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.accNewViewName1"), createAccountPage.eAccViewName);
		bu.clickOnElement(createAccountPage.eAccViewName);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eAccViewUniqueName);
		bu.clearText(createAccountPage.eAccViewUniqueName);
		Thread.sleep(9000);
		//bu.wait();
		bu.sendText(dataUtil.readAccounts("prod.accViewUniqueName1"), createAccountPage.eAccViewUniqueName);
		bu.clickOnElement(createAccountPage.eAccViewUniqueName);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccSave);
		bu.clickOnElement(createAccountPage.eAccSave);
		Thread.sleep(5000);
		
	}
	@Test
	public void Editview_TC12() throws IOException, InterruptedException {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		test.log(Status.INFO,"Username entered");
		Thread.sleep(5000);
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		
		System.out.println("home page is displayed");
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccountsTabLink);
		bu.clickOnElement(createAccountPage.eAccountsTabLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eViewNameToEdit);
		bu.clickOnElement(createAccountPage.eViewNameToEdit);
		Thread.sleep(9000);		

		bu.isElementVisible(createAccountPage.eEditLink);
		bu.clickOnElement(createAccountPage.eEditLink);
		Thread.sleep(5000);

		bu.isElementVisible(createAccountPage.eAccViewName);
		bu.clearText(createAccountPage.eAccViewName);
		bu.sendText(dataUtil.readAccounts("prod.accNewViewName2"), createAccountPage.eAccViewName);
		bu.clickOnElement(createAccountPage.eAccViewName);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eFilterfieldAccount);
		bu.clickOnElement(createAccountPage.eFilterfieldAccount);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eFilterAccNameOption);
		bu.clickOnElement(createAccountPage.eFilterAccNameOption);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eFilterfieldOperator);
		bu.clickOnElement(createAccountPage.eFilterfieldOperator);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eFilterOperatorContains);
		bu.clickOnElement(createAccountPage.eFilterOperatorContains);
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eFilterValue);
		bu.clearText(createAccountPage.eFilterValue);
		Thread.sleep(5000);
		bu.sendText(dataUtil.readAccounts("prod.operatorValue"), createAccountPage.eFilterValue);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eLastActivityTab);
		bu.clickOnElement(createAccountPage.eLastActivityTab);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAddBtn);
		bu.clickOnElement(createAccountPage.eAddBtn);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccSave);
		bu.clickOnElement(createAccountPage.eAccSave);
		Thread.sleep(5000);
	}

	@Test
	public void MergeAccounts_TC13() throws IOException, InterruptedException {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		test.log(Status.INFO,"Username entered");
		Thread.sleep(5000);
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		
		System.out.println("home page is displayed");
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccountsTabLink);
		bu.clickOnElement(createAccountPage.eAccountsTabLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eMergeAccLink);
		bu.clickOnElement(createAccountPage.eMergeAccLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eAccName1ToMerge);
		bu.sendText(dataUtil.readAccounts("prod.accNameToMerge"), createAccountPage.eAccName1ToMerge);
		// bu.clickOnElement();
		Thread.sleep(5000);

		bu.isElementVisible(createAccountPage.eFindAccBtn);
		bu.clickOnElement(createAccountPage.eFindAccBtn);
		Thread.sleep(5000);

		// bu.isElementVisible(createAccountPage.checkbox);no need bcos all come auto
		// chkd
		// bu.clickOnElement(createAccountPage.checkbox);

		bu.isElementVisible(createAccountPage.eNext);
		bu.clickOnElement(createAccountPage.eNext);
		Thread.sleep(5000);

		bu.isElementVisible(createAccountPage.eMergeBtn);// not clicking bcos it will happen and nxt time tc not
		Assert.assertTrue(createAccountPage.eMergeBtn.isDisplayed());													// exceutable
		// bu.clickOnElement(); isVisible is validating that TC has passed

		// bu.isElementVisible();
		// bu.clickOnElement();

	}
	@Test
		public void CreateAccountReport_TC14() throws IOException, InterruptedException {

		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		test.log(Status.INFO,"Username entered");
		Thread.sleep(5000);
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		
		System.out.println("home page is displayed");
		Thread.sleep(5000);
		
		
		bu.isElementVisible(createAccountPage.eAccountsTabLink);
		bu.clickOnElement(createAccountPage.eAccountsTabLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.AccWithLastActivityGrtr30days);
		bu.clickOnElement(createAccountPage.AccWithLastActivityGrtr30days);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eDatefieldDrpDwn);
		bu.clickOnElement(createAccountPage.eDatefieldDrpDwn);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eCreatedDate);
		bu.clickOnElement(createAccountPage.eFromCalendar);
		Thread.sleep(9000);
		
		bu.sendText(dataUtil.readAccounts("prod.accCreateStartsDate"), createAccountPage.eCreatedDate);
		//bu.clickOnElement(createAccountPage.eCreatedDate);
		//bu.clickOnElement(createAccountPage.eAccStartDt);
		Thread.sleep(5000);		
		
		bu.isElementVisible(createAccountPage.eToFieldEndDate);
		bu.clearText(createAccountPage.eToFieldEndDate);
		bu.clickOnElement(createAccountPage.eToCalendar);
		Thread.sleep(9000);
		
		
		bu.sendText(dataUtil.readAccounts("prod.accCreateEndDate"), createAccountPage.eToFieldEndDate);
		//bu.clickOnElement(createAccountPage.eToFieldEndDate);
		//bu.clickOnElement(createAccountPage.eAccStartDt);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eSaveBtn);
		bu.clickOnElement(createAccountPage.eSaveBtn);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eReportNamePopUpWindow);
		bu.sendText(dataUtil.readAccounts("prod.accReportName"), createAccountPage.eReportNamePopUpWindow);
		bu.clickOnElement(createAccountPage.eReportNamePopUpWindow);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eReportUniqueName);
		bu.clickOnElement(createAccountPage.eReportUniqueName);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eCreateAccSaveandRun);
		bu.clickOnElement(createAccountPage.eCreateAccSaveandRun);
		Thread.sleep(5000);
		
		bu.isElementVisible(createAccountPage.eReportDisplayPage);
		Thread.sleep(5000);
	}

	
}

/*
 * bu.isElementVisible(createAccountPage); bu.clickOnElement();
 * 
 * bu.isElementVisible(createAccountPage); bu.clickOnElement();
 * 
 * bu.isElementVisible(createAccountPage); bu.clickOnElement();
 * 
 * bu.isElementVisible(createAccountPage); bu.clickOnElement();
 * 
 * bu.isElementVisible(createAccountPage); bu.clickOnElement();
 * 
 * @Test public void createAccount_TC12() { //launchApp(); //loginApp();
 * //clickOnAccounts(); //createNewView();
 * Assert.assertNotNull(createAccountPage.clickOnAccounts());
 * createAccountPage.createNewView(); }
 */
