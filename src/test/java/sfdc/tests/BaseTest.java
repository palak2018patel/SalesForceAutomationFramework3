package sfdc.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.log.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.configs.TestConstants;
import sfdc.pages.CreateAccountPage;
import sfdc.pages.LoginPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.DataUtilities;

public class BaseTest {	
		
public static WebDriver driver;
public static BasicUtilities bu= new BasicUtilities();
public static DataUtilities dataUtil=new DataUtilities();
public static ExtentReports report=null;
public static ExtentTest test=null;
public CreateAccountPage accountPage= new CreateAccountPage();
public static LoginPage loginPage= new LoginPage(driver);
public  Logger logger = Logger.getLogger(getClass().getSimpleName());

public WebDriver getDriver(String browserName) {
	String sBrowserName = browserName.toLowerCase();
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
public static void initializeReport(String sclassName) {
	//String filName = new SimpleDateFormat("'Currentdate_'YYYYMMddHHmm'.html'").format(new Date());
	String appendTimeToReport = new SimpleDateFormat("CurrentDate-'YYYYMMdd'.html").format(new Date(0));
	ExtentReports report = new ExtentReports();	
	ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(TestConstants.sReportPath+"//sfdc_report"+appendTimeToReport+".html");
	report.attachReporter(htmlReport);
	try {
		logger.info("extent html report configured");
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
public ChromeOptions enableHeadlessMode() {
	ChromeOptions options = new ChromeOptions();
	options.addArguments("--headless", "--diable-gpu", "--window-size=1920,1080");
	return options;
}
	public void initializeLogging()throws IOException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(TestConstants.sLog4jpropertiesPath);
		prop.load(fis);
		PropertyConfigurator.configure(prop);
	}

				
				
		//extent = new ExtentReports();
		
	}

	





