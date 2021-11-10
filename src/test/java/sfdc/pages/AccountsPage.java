package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountsPage {
	public AccountsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}	

}
