package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeadsPage extends BasePage{
	public LeadsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}
	
	@FindBy(xpath="//a[(@title='Leads Tab')]")
	public WebElement  eLeadsTab;
	
	@FindBy(xpath="//select[(@title='View:')]")
	public WebElement  eViewLeads;
	
	@FindBy(xpath="//input[(@title='Go!')]")
	public WebElement eGOLeads ;
	
	@FindBy(xpath="//input[(@title='New')]")
	public WebElement eNewLeads ;
	
	@FindBy(xpath="//input[(@id='name_lastlea2')]")
	public WebElement eLastName ;
	
	@FindBy(xpath="//input[(@id='lea3')]")
	public WebElement eCompanyName ;
	
	@FindBy(xpath="//input[(@name='save')]")
	public WebElement esave ;
	
	@FindBy(xpath="//input[(@id='con4')]")
	public WebElement eAccountName ;
	
	//@FindBy()
	//public WebElement  ;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
