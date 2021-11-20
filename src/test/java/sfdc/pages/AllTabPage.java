package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

public class AllTabPage extends BaseTest{
	
	public AllTabPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}

	@FindBy(xpath="//img[(@class='allTabsArrow')]")
	public WebElement eAllTab ;
	
	
	@FindBy(xpath="//input[(@name='customize')]")
	public WebElement eCustomizeMyTab ;
	
	@FindBy(xpath="//option[(@value='Chatter')]")
	public WebElement eSelectionTab ;
	
	@FindBy(xpath="//img[(@class='leftArrowIcon')]")
	public WebElement eRemove ;
	
	@FindBy(xpath="//input[(@name='save')]")
	public WebElement eSave ;
									
	@FindBy(xpath="//*[@id=\"ptBody\"]/div/div[2]/span[2]/a")
    public WebElement eCurrentDateLink;
	
	@FindBy(xpath="//img[(@class='comboboxIcon')]")
	public WebElement eComboIcon ;
	
	@FindBy(xpath="//input[(@id='EndDateTime_time')]")
	public WebElement eEndDateTime ;
	
	@FindBy(xpath="//input[(@id='IsRecurrence')]")
	public WebElement eIsRecurrence ;
	
	@FindBy(xpath="//input[(@id='rectypeftw')]")
	public WebElement eWeeklyBtn ;
	
	@FindBy(xpath="//input[(@id='RecurrenceEndDateOnly')]")
	public WebElement eEndDate ;	
	
	@FindBy(xpath="//img[(@class='monthViewIcon')]")
	public WebElement eMonthView;
	
	@FindBy(xpath="//a[(@title='Chatter Tab')]")
	public WebElement eChatterTabOnBar;
	
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


