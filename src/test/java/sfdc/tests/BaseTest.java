package sfdc.tests;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import freemarker.log.Logger;
import io.github.bonigarcia.wdm.WebDriverManager;
import sfdc.configs.TestConstants;
import sfdc.pages.AllTabPage;
import sfdc.pages.ContactsPage;
import sfdc.pages.CreateAccountPage;
import sfdc.pages.HomePage;
import sfdc.pages.HomeTabPage;
import sfdc.pages.LeadsPage;
import sfdc.pages.LoginPage;
import sfdc.pages.OpportunitiesPage;
import sfdc.utilities.BasicUtilities;
import sfdc.utilities.DataUtilities;
public class BaseTest {		
	
public static WebDriver driver;

public static BasicUtilities  bu= new BasicUtilities();
public  DataUtilities dataUtil=new DataUtilities();

public static ExtentReports report;
public static ExtentTest test;

public  CreateAccountPage createAccountPage;//= new CreateAccountPage(driver);
public static LoginPage loginPage;//new LoginPage(driver);

public   HomePage homePage;//new HomePage(driver);
public  LeadsPage leadsPage=null;//new LeadsPage(driver);
public  ContactsPage contactsPage=null;//new ContactsPage(driver);
public  HomeTabPage homeTabPage;//new HomeTabPage(driver);
public  AllTabPage allTabPage=null;//new AllTabPage(driver);
public  OpportunitiesPage optyPage=null;//new OpportunitiesPage(driver);

public  Logger logger = Logger.getLogger(getClass().getSimpleName());
//public   Logger logger = Logger.getLogger(BaseTest.class);


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

public void initializeReport(String Testcase) {
	String appendTimeToReport = new SimpleDateFormat("yymmddhhmm").format(new Date());
	report = new ExtentReports();
	String ReportPath= System.getProperty("user.dir")+"//target//Reports";
	ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(
			ReportPath + "//" + appendTimeToReport + "-" + Testcase + ".html");
	report.attachReporter(htmlReport);

}

public void initializeLogging() throws IOException {
	Properties prop = new Properties();
	FileInputStream file = new FileInputStream(TestConstants.Log4jpropertiesPath);
	prop.load(file);
	PropertyConfigurator.configure(prop);
}

/*public  void initializeReport()throws Exception {                //This also works!!!!!!!!!!!!!
	DateFormat df = new SimpleDateFormat();
	java.util.Date date = Calendar.getInstance().getTime();
	//String dateFormat = df.format(date);
	String filName = df.format( date);
	//String filName = new SimpleDateFormat("'Currentdate_'YYYYMMddHHmm'.html'").format( date);
	//String appendTimeToReport = new SimpleDateFormat("CurrentDate-'YYYYMMdd'.html").format(new Date());
	String appendTimeToReport = df.format(date);
	ExtentReports report = new ExtentReports();	
	ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(TestConstants.sReportPath+"//sfdc_report"+appendTimeToReport+".html");
	report.attachReporter(htmlReport);	
	//logger.info("extent html report configured");	*/
		
	/*DateFormat df = new SimpleDateFormat();
	java.util.Date date = Calendar.getInstance().getTime();
	String dateFormat = df.format(date);
	String path = System.getProperty("user.dir" + "//target//Reports//" + dateFormat + "PNG");
	System.out.println(path);*/
	
	}

/*public ChromeOptions enableHeadlessMode() {
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
	public void initializeReport() //(String sclassName)
	{
		String appendTimeToReport = new SimpleDateFormat("yymmddhhmm").format(new Date());
		 report = new ExtentReports();	
		ExtentHtmlReporter htmlReport = new ExtentHtmlReporter(TestConstants.sReportPath+"//sfdc_report"+appendTimeToReport+".html");
		report.attachReporter(htmlReport);
		
	}*/






