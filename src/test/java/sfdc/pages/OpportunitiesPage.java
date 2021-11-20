package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

public class OpportunitiesPage extends BaseTest{

	public OpportunitiesPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}
	
	//@FindBy()
	//public WebElement  ;
	
	//@FindBy()
	//public WebElement  ;
	
	
	@FindBy(xpath="//a[(@title='Opportunities Tab')]")
	public WebElement optyLink ;
	
	
	@FindBy(xpath="//select[(@id='fcf')]")
	public WebElement optyDropdown ;
	
	
	@FindBy(xpath="//input[(@title='New')]")
	public WebElement createnewoptyBtn  ;
	
	
	@FindBy(xpath="//input[(@id='opp3')]")
	public WebElement optyName ;
	
	
	@FindBy(xpath="//input[(@id='opp4')]")
	public WebElement AccName ;
	
	
	@FindBy(xpath="//input[(@id='opp9')]")
	public WebElement closeDate ;
	
	
	@FindBy(xpath="//select[(@name='calYearPicker')]")
	public WebElement yearDrpDown ;	
	
	@FindBy(xpath="//*[@id=\"ep\"]/div[2]/div[3]/table/tbody/tr[2]/td[4]/div/span/span/a")
	public WebElement yearselection;	
	
	@FindBy(xpath="//select[(@id='opp11')]")
	public WebElement stage;
	
	@FindBy(xpath="//option[(@value='Needs Analysis')]")
	public WebElement stageSelection;
	
	@FindBy(xpath="//input[(@id='opp12')]")
	public WebElement probability;
	
	@FindBy(xpath="//select[(@id='opp6')]")
	public WebElement leadSource;
	
	@FindBy(xpath="//input[(@id='opp17')]")
	public WebElement primaryCmpSrc;	
	
	@FindBy(xpath="//input[(@name='save')]")
	public WebElement Savebtn;
	
	@FindBy(xpath="//option[(@value='Partner Referral')]")
	public WebElement leadSourceSelect;
	
	@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[1]/a")
	public WebElement optyPipelineLink;
	
	@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[1]/div/div[1]/div[1]/ul/li[2]/a")
	public WebElement stuckOpty;
	
	@FindBy(xpath="//select[(@id='quarter_q')]")
	public WebElement   selectionIntervallist;
	
	@FindBy(xpath="//*[@id=\"quarter_q\"]/option[2]")
	public WebElement  CurrentNextFQfrominterval;
	
	@FindBy(xpath="//select[(@id='open')]")
	public WebElement   Includebox;
	
	@FindBy(xpath="//*[@id=\"open\"]/option[1]")
	public WebElement  intervalselection;
	
	@FindBy(xpath="//input[(@value='Run Report')]")
	public WebElement   runReport;
	
	/*@FindBy(xpath=)
	public WebElement         ;
	
	@FindBy(xpath=)
	public WebElement         ;
	
	@FindBy(xpath=)
	public WebElement         ;
	*/
	
}	
	
	
	

