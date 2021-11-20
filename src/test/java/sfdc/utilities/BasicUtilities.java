package sfdc.utilities;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
//import org.apache.poi.hssf.usermodel.HSSFCell;
//import org.apache.poi.hssf.usermodel.HSSFSheet;
//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import com.relevantcodes.extentreports.ExtentReports;

import sfdc.tests.BaseTest;

public class BasicUtilities extends BaseTest {
static WebElement element;
	
	//public static void createreport() {
		//String filName = new SimpleDateFormat("'Currentdate_'YYYYMMddHHmm'.html'").format(new Date());
		//String path = "C:\\Users\\admin\\Desktop\\Report\\" + filName;
		//report = new ExtentReports(path);
	//}

	
//	public static ExtentTest CreateTestScriptReport(String TestScriptName) {
//		logger = report.startTest(TestScriptName);
//		return logger;
//	}	
	public static void enterText(WebElement element,String textval,String elementName) throws Exception

	{
		if(element.isDisplayed())
		{
			Thread.sleep(4000);
			element.sendKeys(textval);
			System.out.println("pass: "+textval+"value is entered in "+elementName+"field");
			//Call take screenshot function
//			logger.log(LogStatus.PASS,textval+"value is entered in "+elementName+"field");
			
		}
		else
		{
			System.out.println("fail:" +elementName+ "field does not exist please check application");
//			logger.log(LogStatus.FAIL,textval+elementName+"field does not exist please check application");
			
		}
	}
	
	
	public static void clickEle(WebElement element,String elementName)
	{
		if(element.isDisplayed())
		{
			element.click();
			System.out.println("pass :" +elementName + "button is clicked");
//			logger.log(LogStatus.PASS, elementName+ "button is displayed ,please check the application");
		}
		else
		{
			System.out.println("Fail:" +elementName+"button is not displayed ,please check the application");
//			logger.log(LogStatus.FAIL, elementName+ "button is not displayed ,please check the application");
		}
	}
	

public void selectCheckBox(WebElement element, String elementName) {
		
		if(element.isDisplayed()) {
			
			if(element.isSelected()) {
				System.out.println("Pass: "+elementName+" is already selected");
//				logger.log(LogStatus.INFO, elementName + "is already selected");
			}else{
				element.click();
			System.out.println("Pass: "+elementName+" is selected");
//			logger.log(LogStatus.PASS, elementName + "is selected");
		    }}
			else {
			System.out.println("Fail:"+elementName+" is not present.Please chk application");	
//			logger.log(LogStatus.FAIL, elementName+ " is not displayed ,please check the application");
		}	
	}
	
	public  void selectDropdown(WebElement element, String elementName) {
						
				if(element.isDisplayed()) {
					System.out.println("Pass: "+elementName+" is  selected");
					element.click();
				}else
				{
				
					System.out.println("Fail:"+elementName+" is not present.Please chk application");	
//				
			    }}		
	public static void validateErrormsg(String actualmsg, String errormsg) {
		
		if(actualmsg.equals(errormsg))
		{
			System.out.println("TestCase is passed");
//			logger.log(LogStatus.PASS,  "TestCase is passed" );
		}else
	    {
		System.out.println("TestCase is failed");
//		logger.log(LogStatus.FAIL,  "TestCase is failed" );
	    }
	}
public void switchFrame( WebDriver driver,WebElement element) {
	 
    if(element.isDisplayed()) {
     driver.switchTo().frame(element);
     System.out.println("Pass: we can switch to the "+element+ " frame");
//     logger.log(LogStatus.PASS,  "Switch to frame" );
     
    }else {
     System.out.println("fail: we can't switch to the "+element+ " frame");
//     logger.log(LogStatus.FAIL,  "Cannot Switch to frame" );
    }
}


public static void switchFrameid( WebDriver driver,String element) {
	 
     driver.switchTo().frame(element);
     System.out.println("Pass: we can switch to the "+element+ " frame");
//     logger.log(LogStatus.PASS,  "we can switch to the frame" );
     
    }


public void switchdefaultFrame( WebDriver driver)
{
driver.switchTo().defaultContent();
System.out.println("Pass: we can switch to the "+ driver + " back to frame");
//logger.log(LogStatus.PASS,  "we can switch back to the frame" );
}

 

public  void mouseOver(WebDriver driver,WebElement element) {
	if(element.isDisplayed()) {
   Actions action=new Actions(driver);
   action.moveToElement(element).build().perform();
	System.out.println("Pass: "+element+" is present");
//	logger.log(LogStatus.PASS,  "element is present" );
	}
 else {
		System.out.println("Fail:"+element+" is not present.Please chk application");
//		logger.log(LogStatus.FAIL,  "element is not present.Please chk application" );
	}
}


public void SelectbyText(WebElement we, String VisibleText){
	   if(we.isDisplayed())
	   {
		   Select selElement=new Select(we);
           selElement.selectByVisibleText(VisibleText);
	           System.out.println("Pass: "+VisibleText+ " is Selected by VisibleText" );
//	           logger.log(LogStatus.PASS, " is Selected by VisibleText" );
	           
	   } 
	   else
	   {
	    System.out.println("Fail: "+VisibleText+ " is not available");
//	    logger.log(LogStatus.FAIL, " is not Selected by VisibleText" );
	    
	   }
	   
	   
}


public void SelectByValue(WebElement element, String val) {
	  //if(element.isSelected()) {
	if(element.isDisplayed()) {
	   Select selElement=new Select(element);
	    
	   selElement.selectByValue(val);
	  System.out.println("pass:"+val + " is selected from drop down ");
//	  logger.log(LogStatus.PASS, " is selected from drop down " );
	 
	  }else {
	   System.out.println("Fail:"+val+"is not selected");
//	   logger.log(LogStatus.FAIL, " is not selected from drop down " );
	  }
	 }	  



public void selectByIndex(WebElement element, int index) {
	  if(element.isDisplayed()) {
	   Select selelement=new Select(element);
	  selelement.selectByIndex(index);
	  
	  System.out.println("pass:"+index + " is selected from drop down ");
//	  logger.log(LogStatus.PASS, " is selected from drop down " );
	  }else {
	   System.out.println("Fail:"+index+"is not selected");
//	   logger.log(LogStatus.FAIL, " is not selected from drop down " );
	  }
	 }

public void selectByVisibleText(WebElement element, String Name) {
	if(element.isDisplayed()) {
		 Select drop = new Select(element);
		 drop.selectByVisibleText(Name);
	 System.out.println("Pass: dropdown is selected");
	 }else {
	 System.out.println("Fail: dropdown is not available check your application");
	 }
	 }


public  void Radiobutton(WebElement element, String elementName) {
	
	if(element.isDisplayed() ){
		element.click();
		System.out.println("Pass: "+elementName+" is clicked");
	}else {
		System.out.println("Fail:"+elementName+" is not displayed .Please check your application");			
	}
}


public void switchtoAlert(WebDriver driver) {
	 driver.switchTo().alert().accept();
	 System.out.println("Pass: alert is present and accept");
}

	
	/*public static String[][] readXlData(String path, String string) throws IOException{
		FileInputStream fs=new FileInputStream(new File(path));
		HSSFWorkbook wb=new HSSFWorkbook(fs);
		HSSFSheet sheet=wb.getSheet("Sheet1");
		int rowCount=sheet.getLastRowNum()+1;
		int colCount=sheet.getRow(0).getLastCellNum();
		String[][] data=new String[rowCount][colCount];
		for(int i=0;i<rowCount;i++){
			for(int j=0;j<colCount;j++){
				int cellType=sheet.getRow(i).getCell(j).getCellType();
				if(cellType==HSSFCell.CELL_TYPE_NUMERIC){
					int val=(int)sheet.getRow(i).getCell(j).getNumericCellValue();
					data[i][j]=String.valueOf(val);
				}
				else
					data[i][j]=sheet.getRow(i).getCell(j).getStringCellValue();
					
			}
		}
		return (data);
	} */
	public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{

        //Convert web driver object to TakeScreenshot

        TakesScreenshot scrShot =((TakesScreenshot)webdriver);

        //Call getScreenshotAs method to create image file

                File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

            //Move image file to new destination

                File DestFile=new File(fileWithPath);

                //Copy file at destination

                FileUtils.copyFile(SrcFile, DestFile);

    }
	
	public void clickOnElement(WebElement element) {
		element.click();
	}

	public void sendText(String text, WebElement element) {
		element.sendKeys(text);
		test.log(Status.INFO, "Entered text as:" + text);
	}

	public String readTextFromElement(WebElement element) {
		test.log(Status.INFO, "Fetching the  text as:" + element.getText());
		return element.getText();
	}

	public void clearText(WebElement element) {
		element.clear();
	}
	
	public void sendKey( String date, WebElement element) {
		
		DateFormat d = new SimpleDateFormat();
		//java.util.Date date = Calendar.getInstance().getTime();
	//df.format(date);
		element.sendKeys(d.format(date));
		
	}

	public boolean isElementVisible(WebElement element) {

		try {
			element.isDisplayed();
			test.log(Status.INFO, "Element is visible");
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Exception encountered" + e.getMessage());
			test.log(Status.INFO, "Element is not visible");
			return false;
		}
	}

	public void selectElementFromDropdown(WebElement element, int dropdownValue) {
		Select s = new Select(element);
		s.selectByIndex(dropdownValue);
		test.log(Status.INFO, "Element is visible in dropdown");
		System.out.println("ELement is selected");

	}

	public void moveFocusOnToElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public void waitForElement(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));

	}
	public String getScreenCapture(WebDriver driver) throws IOException {

		//DateFormat df = new SimpleDateFormat();
		//java.util.Date date = Calendar.getInstance().getTime();
		//String dateFormat = df.format(date);		
		//String path = System.getProperty("user.dir" + "//target//Reports//" + dateFormat + "PNG");
		
		String appendTimeToPath = new SimpleDateFormat("yymmddhhmm").format(new Date());
		String path =System.getProperty("user.dir")+"//target//Reports//"+appendTimeToPath+ ".PNG";	
		System.out.println(path);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		System.out.println("Screen shot taken");
		return path;
	}
	public void alertPopup()
	{
	
		driver.switchTo().alert().accept();		
	}
	
	public void Tabout(WebElement element)
	{
		element.sendKeys(Keys.TAB);
	}
	
	public void dropdownValueVerification()
	{
		String[] exp = {"All Opportunities","Closing Next Month","Closing This Month","My Opportunities","New Last Week","New This Week","Opportunity Pipeline","Private","Recently Viewed Opportunities","Won"};
		 WebElement dropdown = driver.findElement(By.xpath("//*[@id=\"fcf\"]"));  
		 Select select = new Select(dropdown);  

		 List<WebElement> options = select.getOptions();  
		 for(WebElement we:options)  
		 {  
		  boolean match = false;
		  for (int i=0; i<exp.length; i++){
		      if (we.getText().equals(exp[i]))
		    		  {
		        match = true;
		      }
		    }
		  Assert.assertTrue(match,we.getText());
		  test.log(Status.INFO, "Fetching the text as : "+ we.getText());
		  
		 }  
	}


	public boolean isElementInVisible(WebElement element) {

		 

			try {
				element.isDisplayed();
				test.log(Status.INFO, "Element is visible");
				return false;
			} catch (NoSuchElementException e) {
				System.out.println("Exception encountered" + e.getMessage());
				test.log(Status.INFO, "Element is not visible");
				return true;
			}
		}
	}

