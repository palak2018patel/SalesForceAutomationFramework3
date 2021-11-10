package sfdc.tests;
import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import com.beust.jcommander.Parameters;
import com.github.dockerjava.transport.DockerHttpClient.Request.Method;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.ListenersUtilities;

@Listeners(ListenersUtilities.class)
public class Login extends BaseTest{
	
LoginPage loginPage= new LoginPage(driver);

	//@Parameters("browser name")
	@BeforeSuite
	public void setUp(String browserName) throws IOException {		
		//initializeLogging();		 
		 initializeReport();
		 driver= getDriver("browserName");
		 loginPage = new LoginPage(driver);		 
	}	
	
	//@Parameters("env name")
	@BeforeTest
	public void launchApp() throws IOException {		
		driver.get(dataUtil.readAccounts("prod.url"));
		WebElement userName =driver.findElement(By.name("username"));
		bu.waitForElement(userName,driver);
	}
	
	@BeforeMethod
	public void loginToApp() {			
				Assert.assertTrue(loginPage.isLoginPageDisplayed());
				bu.isElementVisible(loginPage.eUserName);
				//test.log(Status.INFO,"Username entered");
				bu.sendText("palak@tekarch.com", loginPage.eUserName);	
				bu.isElementVisible(loginPage.ePassword);
				bu.sendText("salesforce@12345", loginPage.ePassword);		
				bu.clickOnElement(loginPage.eLoginButton);					
	}	
	
	@Test()
	public void loginTC01(Method name) throws IOException {
		
		SoftAssert sa=new SoftAssert();		
		WebElement userName =driver.findElement(By.name("username"));
		//test.log(Status, null)	
		bu.isElementVisible(userName);
		bu.sendText(dataUtil.readAccounts("prod.username"),userName);
		
		WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(password);
		bu.sendText(dataUtil.readAccounts("prod.password"), password);
		WebElement loginButton = driver.findElement(By.name("Login"));
		bu.clickOnElement(loginButton);	
		///removed after///String expectedErrorMessage = "Please check your username and password";
		String actualErrorMessage=driver.findElement(By.id("error")).getText();
		sa.assertEquals(actualErrorMessage,dataUtil.readValidationText("password.error"));
		sa.assertAll();		
		}
	
	@Test(dataProvider="Expired Users")
	public void loginTC2(String username, String pass) throws IOException {	
		SoftAssert sa=new SoftAssert();		
		WebElement userName =driver.findElement(By.name("username"));
		test.log(Status.INFO, "Username is entered");		
		bu.isElementVisible(userName);
		bu.sendText(username,userName);
		test.log(Status.INFO,"Username entered");
		WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(password);
		bu.sendText(pass, password);
		WebElement loginButton = driver.findElement(By.name("Login"));
		bu.clickOnElement(loginButton);	
		////////////String expectedErrorMessage = "Please check your username and password";
		String actualErrorMessage=driver.findElement(By.id("error")).getText();
		sa.assertEquals(actualErrorMessage, dataUtil.readValidationText("password.error"));
		sa.assertAll();
	}
			
	@AfterSuite
	public void finishTest() {
		report.flush();
		logger.info("extent report flushed");
	}			
	}		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	/*@Test(priority =1)
	public void launchApp() {
		System.out.println("AppLaunch function");
		//throw new ElementNotInteractableException("This element is not visible");
	}	
	
	@Test(priority =0, enabled=false)
	public void loginToApp_TC1() {
		System.out.println("Logged in to App");
	}
	@Test(priority =0, enabled=false)
	public void loginToApp_TC2() {
		System.out.println("Logged in to App");
	}
	@Test(priority =0, enabled=false)
	public void loginToApp_TC3() {
		System.out.println("Logged in to App");
	}
	@Test(priority =0, enabled=false)
	public void loginToApp_TC4A() {
		System.out.println("Logged in to App");
	}
	@Test(priority =0, enabled=false)
	public void loginToApp_TC4B() {
		System.out.println("Logged in to App");
	}	
	
	@Test(priority =-1, dependsOnMethods="loginToApp",enabled=false)
	public void goToHomePage() {
		System.out.println("Logged in to App");
	}
	@Test(priority =3)
	public void logOutApp() {
		System.out.println("Logged in to App");
	}
	*/
	

