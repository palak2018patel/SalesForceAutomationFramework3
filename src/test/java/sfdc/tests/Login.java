package sfdc.tests;
import java.io.IOException;
import java.lang.reflect.Method;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.aventstack.extentreports.Status;
import sfdc.pages.LoginPage;
import sfdc.utilities.ListenersUtilities;
import com.beust.jcommander.Parameters;
import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.ListenersUtilities;

@Listeners(ListenersUtilities.class)
public class Login extends BaseTest{
	
	//static LoginPage loginPage;

	@BeforeSuite
	public void setUp() throws Exception  {		
		//initializeLogging();		
		 driver= getDriver("chrome");
		 initializeReport("Login");
	}
	@BeforeClass
	public void initializePageObjects() {
		
	}
	
	
	@BeforeMethod
	public void launchApp() throws IOException, InterruptedException {		
	driver= getDriver("chrome");
	driver.get(dataUtil.readAccounts("prod.url"));
	driver.manage().window().maximize();	
	loginPage = new LoginPage(driver);		
	Thread.sleep(5000);
	}

				 
		//bu.waitForElement(loginPage.eUserName,driver);
	//Thread.sleep(3000);
		//WebElement userName =driver.findElement(By.name("username"));
		//bu.waitForElement(userName,driver);
	//}
	
/*	@BeforeMethod            ////////this will always execute then how will test cases be tested for forget pw or wrong pw??????? also change to refactor style
	public void loginToApp() throws IOException {	
		driver= getDriver("chrome");
		driver.get(dataUtil.readAccounts("prod.url"));
		loginPage = new LoginPage(driver);	
		driver.manage().window().maximize();
				Assert.assertTrue(loginPage.isLoginPageDisplayed());
				bu.isElementVisible(loginPage.eUserName);
				bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
				bu.isElementVisible(loginPage.ePassword);
				bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
				bu.isElementVisible(loginPage.eLoginButton);
				bu.clickOnElement(loginPage.eLoginButton);
				
				//test.log(Status.INFO,"Username entered");
				//bu.sendText("palak@tekarch.com", loginPage.eUserName);	
				//bu.isElementVisible(loginPage.ePassword);
				//bu.sendText("salesforce@1", loginPage.ePassword);		
	} */	
	@AfterMethod
	public void exit() throws InterruptedException {

		
		
		driver.quit();
		Thread.sleep(5000);
	}
	
	@Test()
	public void loginErrorMessage_TC1() throws IOException,InterruptedException{
		
		SoftAssert sa=new SoftAssert();		
		Assert.assertTrue(loginPage.isLoginPageDisplayed());
		//WebElement userName =driver.findElement(By.name("username"));
		//test.log(Status, null)	
		//bu.isElementVisible(userName);
		bu.isElementVisible(loginPage.eUserName);// bu.isElementVisible(userName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		Thread.sleep(5000);
		//	bu.sendText(dataUtil.readAccounts("prod.username"),userName)
		//WebElement password =driver.findElement(By.name("pw"));
		bu.isElementVisible(loginPage.ePassword); //bu.isElementVisible(password);
		bu.sendText(dataUtil.readAccounts("prod.wrongpassword"),loginPage.ePassword); 
		Thread.sleep(5000);//bu.sendText(dataUtil.readAccounts("prod.wrongpassword"), password);
		//WebElement loginButton = driver.findElement(By.name("Login")); //WebElement loginButton = driver.findElement(By.name("Login"));
		bu.clearText(loginPage.ePassword);
		Thread.sleep(5000);
		bu.clickOnElement(loginPage.eLoginButton);
		Thread.sleep(5000);//loginPage.eLoginButton
		///removed after///String expectedErrorMessage = "Please check your username and password";
		String actualErrorMessage= (loginPage.eErrorMessage.getText());//driver.findElement(By.id("error")).getText();
		sa.assertEquals(actualErrorMessage,dataUtil.readValidationText("enterPassword.error"));
		sa.assertAll();	
		Thread.sleep(5000);
		//driver.quit();
		
		}
	
	
	@Test()//(dataProvider="Expired Users")
	public void loginToSalesForce_TC2() throws IOException,InterruptedException {	
		SoftAssert sa=new SoftAssert();		
		//WebElement userName =driver.findElement(By.id("username"));
		//test.log(Status.INFO, "Username is entered");		
		//bu.isElementVisible(userName);
		//bu.sendText(username,userName);
		bu.isElementVisible(loginPage.eUserName);// bu.isElementVisible(userName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		Thread.sleep(5000);
		//test.log(Status.INFO,"Username entered");
		//WebElement password =driver.findElement(By.id("password"));
		//bu.isElementVisible(password);
		//bu.sendText(pass, password);
		bu.isElementVisible(loginPage.ePassword); //bu.isElementVisible(password);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		//bu.clickOnElement(loginButton);	
		bu.clickOnElement(loginPage.eLoginButton);
		Thread.sleep(5000);
		//WebElement homepage=driver.findElement(By.xpath("//div[(@title=\"Setup Home\")]"));
		//bu.isElementVisible(homepage);	
		bu.isElementVisible(loginPage.eHomepage);
		System.out.println("home page is displayed");
		
		Thread.sleep(5000);
		//driver.quit();
			}
	
		//STOP!!Run this one before TC2 and then all other TCS will run new pw2 which you have to change first as dataUtil.readAcc(prod.pw2)
	/*@Test//STOP!!!!!Dont run this one before 4 and 5 because you did 5 before 3 and 4 in real sequence of tcs///Only run once because you will need to set the new password2=salesforce@12 it will cause error next time
	public void forgotPassword_TC3() throws IOException {	
		SoftAssert sa=new SoftAssert();		
		//WebElement forgotPassword =driver.findElement(By.id("forgot_password_link"));
		bu.isElementVisible(loginPage.eforgotPasswordLink);
		bu.clickOnElement(loginPage.eforgotPasswordLink);
		//test.log(Status.INFO, "Username is entered");		
		//bu.isElementVisible(userName);
		//bu.sendText(username,userName);
		//test.log(Status.INFO,"Username entered");
		bu.isElementVisible(loginPage.eUserName);// bu.isElementVisible(userName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		bu.isElementVisible(loginPage.eContinueButton);
		bu.clickOnElement(loginPage.eContinueButton);
		String actualForgotPasswordMsg= (loginPage.eForgotPasswordMessage.getText());//driver.findElement(By.id("error")).getText();
		sa.assertEquals(actualForgotPasswordMsg,dataUtil.readValidationText("forgotPasswordMessage"));
		sa.assertAll();			
		test.log(Status.INFO, "forgotPassword message read");	
	}	*/
	
	@Test()
	public void validateLoginErrorMessage_TC4() throws IOException,InterruptedException {	
		SoftAssert sa=new SoftAssert();		
				//WebElement userName =driver.findElement(By.id("username"));
				//test.log(Status.INFO, "Username is entered");		
				//bu.isElementVisible(userName);
				//bu.sendText(username,userName);
				bu.isElementVisible(loginPage.eUserName);// bu.isElementVisible(userName);
				bu.sendText(dataUtil.readAccounts("prod.wrongUserName"),loginPage.eUserName);
				Thread.sleep(5000);
				//test.log(Status.INFO,"Username entered");
				//WebElement password =driver.findElement(By.id("password"));
				//bu.isElementVisible(password);
				//bu.sendText(pass, password);
				bu.isElementVisible(loginPage.ePassword); //bu.isElementVisible(password);
				bu.sendText(dataUtil.readAccounts("prod.wrongPassword"),loginPage.ePassword);
				Thread.sleep(5000);
				//WebElement loginButton = driver.findElement(By.name("Login"));
				//bu.clickOnElement(loginButton);	
				bu.clickOnElement(loginPage.eLoginButton);
				Thread.sleep(5000);
				String actualErrorMessage= (loginPage.eErrorMessage.getText());  //driver.findElement(By.id("error")).getText();
				sa.assertEquals(actualErrorMessage,dataUtil.readValidationText("password.error"));
				sa.assertAll();	
				Thread.sleep(5000);
				//driver.quit();
	}
	
	
	@Test()
	public void rememberUsername_TC5() throws IOException,InterruptedException {	
		SoftAssert sa=new SoftAssert();		
		//WebElement userName =driver.findElement(By.id("username"));
		//test.log(Status.INFO, "Username is entered");		
		//bu.isElementVisible(userName);
		//bu.sendText(username,userName);
		bu.isElementVisible(loginPage.eUserName);// bu.isElementVisible(userName);
		bu.sendText(dataUtil.readAccounts("prod.username"),loginPage.eUserName);
		Thread.sleep(5000);
		//test.log(Status.INFO,"Username entered");
		//WebElement password =driver.findElement(By.id("password"));
		//bu.isElementVisible(password);
		//bu.sendText(pass, password);
		bu.isElementVisible(loginPage.ePassword); //bu.isElementVisible(password);
		bu.sendText(dataUtil.readAccounts("prod.password1"),loginPage.ePassword);
		Thread.sleep(5000);
		//WebElement loginButton = driver.findElement(By.name("Login"));
		//bu.clickOnElement(loginButton);
		bu.isElementVisible(loginPage.eRememberMe);
		bu.clickOnElement(loginPage.eRememberMe);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eLoginButton);
		bu.clickOnElement(loginPage.eLoginButton);
		Thread.sleep(5000);
		//WebElement homepage=driver.findElement(By.xpath("//div[(@title=\"Setup Home\")]"));
		//bu.isElementVisible(homepage);	
		bu.isElementVisible(loginPage.eHomepage);
		System.out.println("home page is displayed");
		test.log(Status.INFO,"home page is displayed");
		bu.isElementVisible(loginPage.eUserMenu);
		bu.clickOnElement(loginPage.eUserMenu);
		Thread.sleep(5000);
		bu.isElementVisible(loginPage.eLogOut);
		bu.clickOnElement(loginPage.eLogOut);
		Thread.sleep(9000);
		
		String displayedName=bu.readTextFromElement(loginPage.eUserNameId);
		
		Thread.sleep(9000);
		sa.assertEquals(displayedName,dataUtil.readAccounts("prod.username"));		
		sa.assertAll();	
		Thread.sleep(5000);
		//driver.quit();
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
	

