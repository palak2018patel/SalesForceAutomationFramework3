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
	
	@FindBy(xpath="//option[(@value=\"00B5f00000Bs10S\")]")
	public WebElement eTodaysLead;
	
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
	
	@FindBy(xpath="//*[@id=\"userNav\"]")
	public WebElement eUserMenu;

	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement eLogOut;
	
	@FindBy(xpath="//img[(@class='pageTitleIcon')]")
	public WebElement eLeadIcon ;
		
	@FindBy(xpath="//td[(@id='bodyCell')]")
		public WebElement eLeadsGoPage ;
			
	//@FindBy()
		//public WebElement  ;
		
	
	//@FindBy()
		//public WebElement  ;
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
