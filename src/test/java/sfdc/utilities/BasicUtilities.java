package sfdc.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import sfdc.tests.BaseTest;

public class BasicUtilities extends BaseTest {

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
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public String getScreenCapture(WebDriver driver) throws IOException {

		DateFormat df = new SimpleDateFormat();
		java.util.Date date = Calendar.getInstance().getTime();
		String dateFormat = df.format(date);
		String path = System.getProperty("user.dir" + "//target//Reports//" + dateFormat + "PNG");
		System.out.println(path);
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		File source = screenshot.getScreenshotAs(OutputType.FILE);
		File destination = new File(path);
		FileUtils.copyFile(source, destination);
		System.out.println("Screen shot taken");
		return path;
		

	}
}
