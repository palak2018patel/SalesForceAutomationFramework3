package sfdc.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.util.List;
import java.util.TreeSet;

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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import sfdc.pages.HomePage;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.ListenersUtilities;
@Listeners(ListenersUtilities.class)
public class Home extends BaseTest{
				
			@BeforeSuite
			public void setUp() throws Exception  {		
				//initializeLogging();		
				 driver= getDriver("chrome");
				 initializeReport("HomePage");			
			}		
			@AfterSuite
			public void finishTest()
			{
				report.flush();
			}
			/*@BeforeMethod
			public void launchApp() throws IOException, InterruptedException {		
				
				driver= getDriver("chrome");
				driver.get(dataUtil.readAccounts("prod.url"));
				loginPage = new LoginPage(driver);	
				homePage = new HomePage(driver);			 
				driver.manage().window().maximize();				
				Thread.sleep(5000);
			}*/
			@BeforeMethod    ///removed from Login.java///this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
			public void loginToApp() throws IOException,InterruptedException{
				
				driver= getDriver("chrome");
				driver.get(dataUtil.readAccounts("prod.url"));
				loginPage = new LoginPage(driver);	
				homePage = new HomePage(driver);
				driver.manage().window().maximize();				
				Thread.sleep(5000);
			}	
				
				
			/*@AfterMethod 
			public void exit() throws InterruptedException {

				driver.quit();
				
			}*/
		
						
		@Test
		public void select_UserMenu_Dropdown_TC05() throws IOException, InterruptedException  {			
			
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
			bu.isElementVisible(loginPage.eHomepage);
			//System.out.println("home page is displayed");
			test.log(Status.INFO,"home page is displayed");
			//bu.isElementVisible(loginPage.eUserMenu);
			bu.clickOnElement(loginPage.eUserMenu);
			Thread.sleep(5000);
			
			
		    //WebElement dropdown = loginPage.eUserMenu;
			//Select div = new Select(dropdown);
			//List<WebElement> dropdownvalues = div.getOptions();
			//for (int i=0; i<dropdownvalues.size();i++)
			//{ 
				
				//Assert.assertEquals(exp[i], dropdownvalues.get(i).getText());
				//test.log(Status.INFO, "Dropdown values displayed are correct");			
			//}
			
			String[] exp= {"My Profile","My Settings","Developer Console","Switch to Lightning Experience", "Logout"};
			List<WebElement>  dropdownList= driver.findElements(By.xpath("//*[@id=\"userNav\"]")); 
			Thread.sleep(3000);
			
			boolean dropdownIsCorrect=true;
			
			for(int i=0; i<dropdownList.size(); i++)
				
			{		
				boolean expdropdownIsCorrect=((dropdownList.get(i).getText()).contains(exp[i])||(dropdownList.get(i).getText()).contains(exp[i+1])||(dropdownList.get(i).getText()).contains(exp[i+2])||(dropdownList.get(i).getText()).contains(exp[i+3])||(dropdownList.get(i).getText()).contains(exp[i+4]));
				Assert.assertEquals(dropdownIsCorrect, expdropdownIsCorrect);				
				test.log(Status.INFO, "Dropdown values displayed as expected");
				//Assert.assertEquals(exp[i],displayedTab.get(i).getText());					
			}			
				
		}
		
		@Test
		public void select_MyProfile_In_usermenu_TC06() throws IOException,InterruptedException {
			
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			Thread.sleep(3000);
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
			test.log(Status.INFO,"Username entered");
			Thread.sleep(3000);
			//WebElement password =driver.findElement(By.name("pw"));
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
			Thread.sleep(3000);
			//WebElement loginButton = driver.findElement(By.name("Login"));
			bu.isElementVisible(loginPage.eLoginButton);
			bu.clickOnElement(loginPage.eLoginButton);
			
			System.out.println("home page is displayed");
			Thread.sleep(3000);
			//bu.isElementVisible(loginPage.eHomepage);
			test.log(Status.INFO,"home page is displayed");
			Thread.sleep(3000);
			//bu.isElementVisible(loginPage.eUserMenu);
			bu.clickOnElement(loginPage.eUserMenu);
			Thread.sleep(3000);
			
		//bu.isElementVisible(homePage.eMyProfileButton);	
		bu.clickOnElement(homePage.eMyProfileButton);
		
		Thread.sleep(3000);
		//bu.isElementVisible(homePage.eEditButton);
		bu.clickOnElement(homePage.eEditButton);
		Thread.sleep(3000);
		bu.isElementVisible(homePage.eMyFrame1);
		bu.switchFrame(driver, homePage.eMyFrame1);
		Thread.sleep(5000);
		bu.isElementVisible(homePage.eAboutTab);
		bu.clickOnElement(homePage.eAboutTab);
		Thread.sleep(11000);
		bu.isElementVisible(homePage.eLastName)	;
		bu.clearText(homePage.eLastName);
		Thread.sleep(9000);
		bu.sendText(dataUtil.readAccounts("prod.lastName"),homePage.eLastName );
		Thread.sleep(9000);
		bu.isElementVisible(homePage.eSaveAllButton);
		bu.clickOnElement(homePage.eSaveAllButton);
		Thread.sleep(11000);
		bu.isElementVisible(homePage.ePostLinkButton);
		bu.clickOnElement(homePage.ePostLinkButton);
		Thread.sleep(9000);
		bu.switchFrame(driver, homePage.eMyFrame2);
		Thread.sleep(9000);
		bu.isElementVisible(homePage .eTextBox);
		bu.clickOnElement(homePage.eTextBox);
		bu.sendText(dataUtil.readAccounts("prod.textMessage"),homePage.eTextBox );
		Thread.sleep(9000);
		//driver.switchTo().parentFrame();	//driver.switch to parent or bu.default frame is same	
		bu.switchdefaultFrame(driver);
		Thread.sleep(9000);
		//bu.mouseOver(driver,homePage.eShare);//not needed
		//bu.switchFrame(driver, homePage.eMyFrame2);//not needed
		bu.isElementVisible(homePage.eShare);
		bu.clickOnElement(homePage.eShare);	
		Thread.sleep(5000);
		
		
		}	
		
		@Test
		public void select_MySettings_In_usermenu_TC07()throws IOException,InterruptedException {
			
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
			test.log(Status.INFO,"Username entered");
			Thread.sleep(9000);
			//WebElement password =driver.findElement(By.name("pw"));
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
			Thread.sleep(9000);
			//WebElement loginButton = driver.findElement(By.name("Login"));
			bu.isElementVisible(loginPage.eLoginButton);
			bu.clickOnElement(loginPage.eLoginButton);
			
			System.out.println("home page is displayed");
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eHomepage);
			test.log(Status.INFO,"home page is displayed");
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eUserMenu);
			bu.clickOnElement(loginPage.eUserMenu);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eMysettings);
			bu.clickOnElement(homePage.eMysettings);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.ePersonalLink);
			bu.clickOnElement(homePage.ePersonalLink);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eLoginHistory);
			bu.clickOnElement(homePage.eLoginHistory);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eDownLoadLoginHistoryLink);
			bu.clickOnElement(homePage.eDownLoadLoginHistoryLink);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eDisplayAndLayoutLink);
			bu.clickOnElement(homePage.eDisplayAndLayoutLink);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eCustomizeTab);
			bu.clickOnElement(homePage.eCustomizeTab);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eChatter);
			bu.clickOnElement(homePage.eChatter);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eReportTabOption);
			bu.clickOnElement(homePage.eReportTabOption);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eRemoveButton);
			bu.clickOnElement(homePage.eRemoveButton);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eCustomizeTab);
			bu.clickOnElement(homePage.eCustomizeTab);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eChatter);
			bu.clickOnElement(homePage.eChatter);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eReportTabOption);
			bu.clickOnElement(homePage.eReportTabOption);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eAddButton);
			bu.clickOnElement(homePage.eAddButton);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eEmailLink);
			bu.clickOnElement(homePage.eEmailLink);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eEmailSettings);
			bu.clickOnElement(homePage.eEmailSettings);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eEmailName);
			bu.clearText(homePage.eEmailName);
			Thread.sleep(5000);
			bu.sendText(dataUtil.readAccounts("prod.eEmailName"), homePage.eEmailName);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eEmailAddress);
			bu.clearText(homePage.eEmailAddress);
			Thread.sleep(5000);
			bu.sendText(dataUtil.readAccounts("prod.eEmailAddress"),homePage.eEmailAddress);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eAutomaticBCC);
			bu.clickOnElement(homePage.eAutomaticBCC);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eSaveButton);
			bu.clickOnElement(homePage.eSaveButton);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eCalendarReminder);
			bu.clickOnElement(homePage.eCalendarReminder);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eActivityReminder);
			bu.clickOnElement(homePage.eActivityReminder);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.eTestReminder);
			bu.clickOnElement(homePage.eTestReminder);	
			Thread.sleep(5000);
			
		}
		
		@Test
		public void select_DevelopersConsole_In_usermenu_TC08() throws IOException, InterruptedException  {
			
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
			test.log(Status.INFO,"Username entered");
			Thread.sleep(9000);
			//WebElement password =driver.findElement(By.name("pw"));
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
			Thread.sleep(9000);
			//WebElement loginButton = driver.findElement(By.name("Login"));
			bu.isElementVisible(loginPage.eLoginButton);
			bu.clickOnElement(loginPage.eLoginButton);
			
			System.out.println("home page is displayed");
			Thread.sleep(5000); 
			bu.isElementVisible(loginPage.eHomepage);
			//System.out.println("home page is displayed");
			test.log(Status.INFO,"home page is displayed");
			bu.isElementVisible(loginPage.eUserMenu);
			bu.clickOnElement(loginPage.eUserMenu);	
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eDeveloperConsole);
			bu.clickOnElement(homePage.eDeveloperConsole);
			Thread.sleep(5000);
			//bu.isElementVisible(homePage.ePersonalLink);
			//bu.clickOnElement(homePage.ePersonalLink);
			//Thread.sleep(5000);
		}
		
		@Test
		public void select_Logout_In_usermenu_TC09()  throws IOException, InterruptedException  {
			Assert.assertTrue(loginPage.isLoginPageDisplayed());
			Thread.sleep(5000);
			bu.isElementVisible(loginPage.eUserName);
			bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
			test.log(Status.INFO,"Username entered");
			Thread.sleep(9000);
			//WebElement password =driver.findElement(By.name("pw"));
			bu.isElementVisible(loginPage.ePassword);
			bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
			Thread.sleep(9000);
			//WebElement loginButton = driver.findElement(By.name("Login"));
			bu.isElementVisible(loginPage.eLoginButton);
			bu.clickOnElement(loginPage.eLoginButton);
			
			System.out.println("home page is displayed");
			Thread.sleep(5000);
			
			bu.isElementVisible(loginPage.eHomepage);
			//System.out.println("home page is displayed");
			test.log(Status.INFO,"home page is displayed");
			bu.isElementVisible(loginPage.eUserMenu);
			bu.clickOnElement(loginPage.eUserMenu);
			Thread.sleep(5000);
			bu.isElementVisible(homePage.eLogOut);
			bu.clickOnElement(homePage.eLogOut);
			Thread.sleep(5000);
			
		}
			
		}
		//@Test
		//public void () {
			
			
		//}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		


