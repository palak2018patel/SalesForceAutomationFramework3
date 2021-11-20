package sfdc.tests;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import sfdc.pages.HomeTabPage;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;
import sfdc.utilities.ListenersUtilities;
@Listeners(ListenersUtilities.class)
public class HomeTab extends BaseTest {
	//static HomeTabPage homeTabPage;
	
	@BeforeSuite
	public void setUp() throws Exception  {		
		//initializeLogging();		
		 driver= getDriver("chrome");
			 
		 initializeReport("HomeTab");			
	}		
	
	/*@BeforeClass
	public void launchApp() throws IOException {		
		// homeTabPage = new HomeTabPage(driver);			
		//WebElement userName =driver.findElement(By.name("username"));
		//bu.waitForElement(userName,driver);
	}*/
	
	@AfterMethod
	public void exit() throws InterruptedException {

		driver.quit();
		Thread.sleep(5000);
	}

	
	@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
	public void loginToApp() throws IOException{	
		driver= getDriver("chrome");
		driver.get(dataUtil.readAccounts("prod.url"));
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		homeTabPage= new HomeTabPage(driver);
		//bu.waitForElement(loginPage.eUserName,driver);
		
				
				}		
	@Test
	public void VerifyFirstLastNameDisplay_TC33() throws IOException, InterruptedException {
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);	
	
	bu.isElementVisible(homeTabPage.homeTab);
	bu.clickOnElement(homeTabPage.homeTab);
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.firstLastNameLink);
	bu.clickOnElement(homeTabPage.firstLastNameLink);	
	Thread.sleep(5000);
	}	
	
	@Test
	public  void VerifyFirstLastNameDisplay_TC34() throws IOException, InterruptedException {
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);	
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);		
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.homeTab);
	bu.clickOnElement(homeTabPage.homeTab);
	Thread.sleep(5000);
		
	bu.isElementVisible(homeTabPage.firstLastNameLink);
	bu.clickOnElement(homeTabPage.firstLastNameLink);	
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.editProfile);
	bu.clickOnElement(homeTabPage.editProfile);	
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.iframe);
	bu.switchFrame( driver,homeTabPage.iframe);
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.aboutTab);
	bu.clickOnElement(homeTabPage.aboutTab);
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.lastName);
	bu.clearText(homeTabPage.lastName);
	Thread.sleep(5000);
	bu.sendText(dataUtil.readAccounts("prod.Abcd"),homeTabPage.lastName );
	Thread.sleep(5000);
	
	bu.isElementVisible(homeTabPage.saveAll);
	bu.clickOnElement(homeTabPage.saveAll);
	Thread.sleep(5000);
	
	}	
	
	@Test
		public void BlockingEventInCalendar_TC36() throws IOException, InterruptedException {
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);	
		
		bu.isElementVisible(homeTabPage.homeTab);
		bu.clickOnElement(homeTabPage.homeTab);	
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eCurrentDateLink);
		bu.clickOnElement(homeTabPage.eCurrentDateLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eightpmLink);
		bu.clickOnElement(homeTabPage.eightpmLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eComboIcon);
		bu.clickOnElement(homeTabPage.eComboIcon);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eotherbox);
		bu.sendText(dataUtil.readAccounts("prod.Comboselect"), homeTabPage.eotherbox);
		Thread.sleep(5000);
		bu.clickOnElement(homeTabPage.eotherbox);
		
		bu.isElementVisible(homeTabPage.endTime);
		bu.clickOnElement(homeTabPage.endTime);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.ninepmLink);
		bu.clickOnElement(homeTabPage.ninepmLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eSave);
		bu.clickOnElement(homeTabPage.eSave);	
		Thread.sleep(5000);
		
		}		
	
	@Test
	public void BlockingEventInCalendarWithRecurrence_TC37() throws IOException, InterruptedException {
		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);	
		Thread.sleep(5000);
	
		bu.isElementVisible(homeTabPage.homeTab);
		bu.clickOnElement(homeTabPage.homeTab);	
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eCurrentDateLink);
		bu.clickOnElement(homeTabPage.eCurrentDateLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.fourpmLink);
		bu.clickOnElement(homeTabPage.fourpmLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eComboIcon);
		bu.clickOnElement(homeTabPage.eComboIcon);
		Thread.sleep(9000);
		
		bu.isElementVisible(homeTabPage.eotherbox);
		bu.sendText(dataUtil.readAccounts("prod.Comboselect"), homeTabPage.eotherbox);
		Thread.sleep(5000);
		bu.clickOnElement(homeTabPage.eotherbox);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.endTime);
		bu.clickOnElement(homeTabPage.endTime);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.sevenpmLink);
		bu.clickOnElement(homeTabPage.sevenpmLink);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.createRecurringSeries);
		bu.clickOnElement(homeTabPage.createRecurringSeries);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.weeklybutton);
		bu.clickOnElement(homeTabPage.weeklybutton);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.recurEnddate);
		//bu.clickOnElement(homeTabPage.recurEnddate);
		bu.clearText(homeTabPage.recurEnddate);
		Thread.sleep(5000);
		bu.clickOnElement(homeTabPage.recurEnddate);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.calMonthPickerDec);
		bu.clickOnElement(homeTabPage.calMonthPickerDec);
		
		Thread.sleep(5000);
		
		
		bu.isElementVisible(homeTabPage.twoWeeksLater);
		bu.clickOnElement(homeTabPage.twoWeeksLater);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.eSave);
		bu.clickOnElement(homeTabPage.eSave);	
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.monthViewIcon);
		bu.clickOnElement(homeTabPage.monthViewIcon);
		Thread.sleep(5000);
		
		bu.isElementVisible(homeTabPage.calendarDisplay);
		Thread.sleep(5000);
		
		//bu.clickOnElement(homeTabPage);
		
		}	
		
}


















	
	
	
	
	
	
	
	
	
	
	
	
	

