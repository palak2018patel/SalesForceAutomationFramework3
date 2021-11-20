package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

public class HomeTabPage extends BaseTest {
	
	public HomeTabPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}
	
	@FindBy(xpath="//a[(@title='Home Tab')]")
	public WebElement homeTab ;
	
	@FindBy(xpath="//*[@id=\"ptBody\"]/div/div[2]/span[1]/h1/a")
	public WebElement firstLastNameLink ;
	
	@FindBy(xpath="//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div")
	public WebElement editProfile ;
	
	@FindBy(xpath="//iframe[(@id='contactInfoContentId')]")
	public WebElement iframe ;
	
	@FindBy(xpath="//*[@id=\"aboutTab\"]/a")
	public WebElement aboutTab ;
	
	@FindBy(id="lastName")
	public WebElement lastName ;
	
	@FindBy(xpath="//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
	public WebElement saveAll ;
	
	@FindBy(xpath="//*[@id=\"ptBody\"]/div/div[2]/span[2]/a")
	public WebElement eCurrentDateLink ;
	
	@FindBy(xpath="//*[@id=\"p:f:j_id25:j_id61:28:j_id64\"]/a")
	public WebElement eightpmLink ;
	
	@FindBy(xpath="//*[@id=\"p:f:j_id25:j_id61:20:j_id64\"]/a")
	public WebElement fourpmLink;
	
	@FindBy(xpath="//div[(@id='timePickerItem_38')]")
	public WebElement sevenpmLink;
	
	@FindBy(xpath="//input[(@id='IsRecurrence')]")
	public WebElement createRecurringSeries;
	
	@FindBy(xpath="//input[(@id='rectypeftw')]")
	public WebElement weeklybutton;
	
	@FindBy(xpath="//input[(@id='RecurrenceEndDateOnly')]")
	public WebElement recurEnddate;
	
	@FindBy(xpath="//*[@id=\"calMonthPicker\"]/option[12]")
	public WebElement calMonthPickerDec;
	
	
		
	@FindBy(xpath="//*[@id=\"calRow1\"]/td[4]")
	public WebElement twoWeeksLater;
	
	@FindBy(xpath="//img[(@class='monthViewIcon')]")
	public WebElement monthViewIcon;

	
	//@FindBy()
	//public WebElement
	@FindBy(xpath="//img[(@class='comboboxIcon')]")
	public WebElement eComboIcon ;	
	
	@FindBy(xpath="//input[(@name='evt5')]")
	public WebElement  eotherbox;	
	
	@FindBy(xpath="//input[(@id='EndDateTime_time')]")
	public WebElement endTime ;
	
	@FindBy(xpath="//div[(@id='timePickerItem_42')]")
	public WebElement ninepmLink;
	
	@FindBy(xpath="//input[(@name='save')]")
	public WebElement eSave;
	
	@FindBy(xpath="//td[(@id=\"bodyCell\")]")
	public WebElement calendarDisplay;
}
	
	
	
	
	
	
	
	
	
	

