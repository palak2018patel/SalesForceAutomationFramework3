package sfdc.pages;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.Status;

import sfdc.tests.BaseTest;

//pageFactory---->define Webelements and reusable methods

public class LoginPage extends BaseTest{
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}	
	
@FindBy(name="username")
public WebElement eUserName;

@FindBy(xpath="//span[(@id='idcard-identity')]")
public WebElement eUserNameId;

@FindBy(name="pw")
public WebElement ePassword;

@FindBy(id="Login")
public WebElement eLoginButton;

@FindBy(id="error")
public WebElement eErrorMessage;

public boolean isLoginPageDisplayed() {
	return true;	
}
@FindBy(id="forgot_password_link")
public WebElement eforgotPasswordLink;

@FindBy(id="continue")
public WebElement eContinueButton ;

@FindBy(xpath="//*[@id=\"login_form\"]/div[3]/label")
public WebElement eRememberMe;

@FindBy(id="ForceCom_font")
public  WebElement eHomepage ;

//@FindBy
//public WebElement ;
@FindBy(xpath="//div[(@class=\"message\")]")
public WebElement eForgotPasswordMessage;

@FindBy(xpath="//*[@id=\"userNav\"]")
public WebElement eUserMenu;

@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
public WebElement eLogOut;


//public void loginToApp() {
public void loginToApp() throws IOException{			
	//Assert.assertTrue(loginPage.isLoginPageDisplayed());					
	//test.log(Status.INFO,"Username entered");
	//bu.sendText("palak@tekarch.com", homePage.eUserName);	
	//bu.isElementVisible(homePage.ePassword);
	//bu.sendText("salesforce@1", loginPage.ePassword);		
	//bu.clickOnElement(homePage.eLoginButton);	
	WebElement userName =driver.findElement(By.name("username"));	
	bu.isElementVisible(userName);
	bu.sendText(dataUtil.readAccounts("prod.username"),userName);
	test.log(Status.INFO,"Username entered");
	WebElement password =driver.findElement(By.name("pw"));
	bu.isElementVisible(password);
	bu.sendText(dataUtil.readAccounts("prod.password1"), password);
	WebElement loginButton = driver.findElement(By.name("Login"));
	bu.clickOnElement(loginButton);
	System.out.println("home page is displayed");
	
}		
//}

}
