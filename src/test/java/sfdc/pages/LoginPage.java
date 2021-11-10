package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

//pageFactory---->define Webelements and reusable methods

public class LoginPage extends BaseTest{
	
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}	
	
	
@FindBy(name="username")
public WebElement eUserName;

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

//@FindBy
//public  WebElement ;

//@FindBy
//public WebElement ;



public void loginToApp() {

}

}
