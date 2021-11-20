package sfdc.tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
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
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;
import sfdc.pages.AllTabPage;
import sfdc.pages.HomeTabPage;
import sfdc.pages.LoginPage;
import sfdc.utilities.ListenersUtilities;
@Listeners(ListenersUtilities.class)

public class AllTab extends BaseTest{
	//static AllTabPage allTabPage;
		
	@BeforeSuite
	public void setUp() throws Exception  {		
		                             //initializeLogging();		
		 driver= getDriver("chrome");
		 initializeReport("AllTab");			
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
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		allTabPage = new AllTabPage(driver);			 
		bu.waitForElement(loginPage.eUserName,driver);
		Thread.sleep(3000);
		}*/
	
	@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
	public void loginToApp() throws IOException,InterruptedException{			
				
		    driver= getDriver("chrome");
			driver.get(dataUtil.readAccounts("prod.url"));
			driver.manage().window().maximize();
			loginPage = new LoginPage(driver);
			allTabPage = new AllTabPage(driver);			 
			Thread.sleep(3000);
								
				}	
	
	@AfterMethod
	public void exit() {

		driver.quit();
	}

	
	@Test
	public  void VerifyTabCustomization_TC35() throws IOException,InterruptedException{
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		bu.isElementVisible(loginPage.eUserName);
		bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.ePassword);
		bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);	
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);
		
		
	bu.isElementVisible(allTabPage.eAllTab);
	bu.clickOnElement(allTabPage.eAllTab);
	Thread.sleep(5000);
	
	bu.isElementVisible(allTabPage.eCustomizeMyTab);
	bu.clickOnElement(allTabPage.eCustomizeMyTab);
	Thread.sleep(5000);
	
	bu.isElementVisible(allTabPage.eSelectionTab);
	bu.clickOnElement(allTabPage.eSelectionTab);
	Thread.sleep(5000);
	
	bu.isElementVisible(allTabPage.eRemove);
	bu.clickOnElement(allTabPage.eRemove);
	Thread.sleep(5000);
	
	bu.isElementVisible(allTabPage.eSave);
	bu.clickOnElement(allTabPage.eSave);
	Thread.sleep(5000);
	
	bu.isElementVisible(loginPage.eUserMenu);
	bu.clickOnElement(loginPage.eUserMenu);
	Thread.sleep(5000);
	
	bu.isElementVisible(loginPage.eLogOut);
	bu.clickOnElement(loginPage.eLogOut);
	Thread.sleep(5000);
	
	Assert.assertTrue(loginPage.isLoginPageDisplayed());
	bu.isElementVisible(loginPage.eUserName);
	bu.sendText(dataUtil.readAccounts("prod.username"), loginPage.eUserName);
	Thread.sleep(5000);
	bu.isElementVisible(loginPage.ePassword);
	bu.sendText(dataUtil.readAccounts("prod.password1"), loginPage.ePassword);
	Thread.sleep(5000);
	bu.clickOnElement(loginPage.eLoginButton);
	Thread.sleep(5000);
	//Assert.assertFalse(bu.isElementInVisible(allTabPage.eChatterTabOnBar));
	//assertEquals(bu.isElementVisible(allTabPage.eChatterTabOnBar), false);
	//List<WebElement> ele = driver.findElements(By.xpath(path));
	
	//String path = "//div[(@class='zen-inlineList zen-tabMenu') and (@id='tabBar')]/a";
	
	//String[] expTabBar= {"home_Tab","Workspace_Tab","ContentSearch_Tab","Account_Tab","Opportunity_Tab","Lead_Tab","Contact_Tab","report_Tab","AllTab_Tab"};
	//List select=new List(displayedTab);
		//List<WebElement> tabBarValues = select.getOptions();
	
	List<WebElement>  displayedTab= driver.findElements(By.xpath("//ul[(@id='tabBar')]")); 
	Thread.sleep(3000);
	boolean tabBarIsCorrect=true;
	
	for(int i=0; i<displayedTab.size(); i++)
	{		
		boolean exptabBarIsCorrect=(!displayedTab.get(i).getText().contains("Chatter"));
		 assertEquals(tabBarIsCorrect, exptabBarIsCorrect);
		//Assert.assertEquals(expTabBar[i],displayedTab.get(i).getText());
		test.log(Status.INFO, "TabBar values displayed as expected");
			
	}
				
	Thread.sleep(5000);	 
	 
	//SoftAssert a1=new SoftAssert();
		//String actualErrorMsg= (contactsPage.eViewNameErrorMsg.getText());//driver.findElement(By.id("error")).getText();
		//a1.assertFalse(bu.isElementVisible(allTabPage.eSelectionTab));
		//a1.assertAll();	
	
	}
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

