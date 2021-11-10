package parallelTest;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.internal.thread.TestNGThread;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.pages.CreateAccountPage;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.DataUtilities;

public class CrossBrowserScript {
	
	public static WebDriver driver;
	public static BasicUtilities bu= new BasicUtilities();
	public static DataUtilities dataUtil=new DataUtilities();
	public static ExtentReports report=null;
	public static ExtentTest test=null;
	public CreateAccountPage accountPage= new CreateAccountPage();
	public static LoginPage loginPage= new LoginPage(driver);
	//public WebDriver getDriver(String browserName) {
		/*String sBrowserName = browserName.toLowerCase();
		switch (sBrowserName) {

		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver =new ChromeDriver();		
			break;		
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;
			case "edge":
				WebDriverManager.edgedriver().setup();
				driver= new EdgeDriver();
				break;
				default:
					driver = null;
		}
		return driver;
	}
	@BeforeSuite
	public void setup() throws IOException {		
		//initializeLogging();		 
		//initializeReport();
		 driver= getDriver("chrome");
		 
	}	
	//@Parameters("env name")
	@BeforeTest
	public void launchApp() throws IOException, InterruptedException {		
		driver.get(dataUtil.readAccounts("prod.url"));
		//WebElement userName =driver.findElement(By.name("username"));
		//bu.waitForElement(userName,driver);
		Thread.sleep(5000);
	}
	
	@Test
	public void loginToApp() {	
		WebElement userName = driver.findElement(By.name("username"));
		//Fill user name
		userName.sendKeys("palak@tekarch.com");
		//Find password
		WebElement password = driver.findElement(By.id("password"));
		//Fill password
		password.sendKeys("salesforce@12345");
				//Assert.assertTrue(loginPage.isLoginPageDisplayed());
				//bu.isElementVisible(loginPage.eUserName);
				//test.log(Status.INFO,"Username entered");
				//bu.sendText("palak@tekarch.com", loginPage.eUserName);	
				//bu.isElementVisible(loginPage.ePassword);
				//bu.sendText("salesforce@12345", loginPage.ePassword);		
				//bu.clickOnElement(loginPage.eLoginButton);					
	}	}*/


	//WebDriver driver;

	
	// * This function will execute before each Test tag in testng.xml
	// * @param browser
	// * @throws Exception
	 
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			System.setProperty("webdriver.gecko.driver", ".\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'Edge'
				else if(browser.equalsIgnoreCase("Edge")){
					//set path to Edge.exe
					System.setProperty("webdriver.edge.driver",".\\MicrosoftWebDriver.exe");
					//create Edge instance
					driver = new EdgeDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException
	{
		driver.get("http://login.salesforce.com");
		//Find user name
		WebElement userName = driver.findElement(By.name("username"));
		//Fill user name
		userName.sendKeys("palak@tekarch.com");
		//Find password
		WebElement password = driver.findElement(By.id("password"));
		//Fill password
		password.sendKeys("salesforce@12345");
	}}
