package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactsPage extends BasePage{
	
	public ContactsPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}
	
	@FindBy(xpath="//a[(@title='Contacts Tab')]")
	public WebElement  eContactsTab;	

	@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
	public WebElement eNewView;
	
	@FindBy(xpath="//input[(@name=\"name_lastcon2\")]")
			public WebElement eLastName;	
	
	@FindBy(xpath="//input[(@id='fname')]")
	public WebElement eViewName;
	
	@FindBy(xpath="//input[(@id='devname')]")
	public WebElement eViewUniqueName ;	
	
	@FindBy(xpath="//input[(@title='Save')]")
	public WebElement eSave ;			
	
	@FindBy(xpath="//select[(@id='hotlist_mode')]")
	public WebElement ERecent;	
	
	@FindBy(xpath="//*[@id=\"hotlist_mode\"]/option[1]")
	public WebElement eRecentlyCreated ;
	
	@FindBy(xpath="//select[(@id='fcf')]")
	public WebElement eVIewDropDown ;
	
	@FindBy(xpath="//option[(@value=\"00B5f00000Bs119\")]")
	public WebElement eMyContacts;
	
	@FindBy(xpath="//a[(@href='/0035f000007YIUK')]")
	public WebElement eContactName;
	
	@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
	public WebElement eCreateNewView;
	
	@FindBy(xpath="//div[(@class=\"errorMsg\")]")
	public WebElement eViewNameErrorMsg;
	@FindBy(xpath="//div[(@class=\"pbError\")]")
	public WebElement invalidEntryErr;
	@FindBy(xpath="//div[(@class=\"errorMsg\")]")
	public WebElement invalidEntryError;
	
	@FindBy(xpath="//input[(@title='Cancel')]")
	public WebElement eCancel;
	
	@FindBy(xpath="//input[(@id='con4')]")
	public WebElement eAccountName;
	
	@FindBy(xpath="//input[(@title='Save & New')]")
	public WebElement eSaveAndNew;
	
	@FindBy(xpath="//input[(@title='New')]")
	public WebElement eNew;
}
	