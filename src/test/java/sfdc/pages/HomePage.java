package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

public class HomePage extends BaseTest{
	
	public HomePage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}	

	@FindBy(xpath="//*[@id=\"userNav\"]")
	public WebElement eUserMenuDropDown ;
	
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[5]")
	public WebElement eLogOutLink ;
		
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[1]")
	public WebElement eMyProfileButton;
	
	@FindBy(xpath="//*[@id=\"chatterTab\"]/div[2]/div[2]/div[1]/h3/div")
	public WebElement eEditButton;
	
	@FindBy(xpath="//iframe[(@id='contactInfoContentId')]")
	public WebElement eMyFrame1;
	
	@FindBy(xpath="//*[@id=\"aboutTab\"]/a")
	public WebElement eAboutTab;
	
	@FindBy(id="lastName")
	public WebElement eLastName;
	
	@FindBy(xpath="//*[@id=\"TabPanel\"]/div/div[2]/form/div/input[1]")
	public WebElement eSaveAllButton;
	
	@FindBy(xpath="//*[@id=\"publisherAttachTextPost\"]/span[1]")
	public WebElement ePostLinkButton;	
	
	@FindBy(xpath="//iframe[(@class='cke_wysiwyg_frame cke_reset')]")
	public WebElement eMyFrame2;
	
	@FindBy(xpath="/html/body")
	public WebElement eTextBox;
	
	@FindBy(xpath="//input[(@id='publishersharebutton')]")
	public WebElement eShare;
	
	@FindBy(xpath="//*[@id=\"publisherAttachContentPost\"]/span[1]")
	public WebElement eFileLinkbutton ;
	
	@FindBy(xpath="//*[@id=\"chatterUploadFileAction\"]")
	public WebElement eUploadAFileButton ;
	
	@FindBy(xpath="//span[@class='moderatorBadge']")
	public WebElement eUploadProfilePice;
	
	@FindBy(id="uploadPhotoContentId")
	public WebElement ephotoFrame;
	
	@FindBy(xpath="//input[@class='fileInput']")
	public WebElement eUploadImg;
	
	@FindBy(xpath="//input[contains(@id,'uploadBtn')]")
	public WebElement eUploadButton;
	
	@FindBy(xpath="//input[@type='submit']")
	public WebElement eSubmitButton;
	
	@FindBy(xpath="//*[@id=\"userNav-menuItems\"]/a[2]")
	public WebElement eMysettings ;
	
	
	@FindBy(xpath="//span[(@id=\"PersonalInfo_font\")]")
	public WebElement ePersonalLink;
	
	
	@FindBy(xpath="//a[(@id=\"LoginHistory_font\")]")
	public WebElement eLoginHistory;
	
	@FindBy(xpath="//*[@id=\"RelatedUserLoginHistoryList_body\"]/div/a")
	public WebElement eDownLoadLoginHistoryLink;
			
	@FindBy(xpath="//span[(@id=\"DisplayAndLayout_font\")]")
	public WebElement eDisplayAndLayoutLink;
					
	@FindBy(xpath="//span[(@id=\"CustomizeTabs_font\")]")
	public WebElement eCustomizeTab;
							
	@FindBy(xpath="//option[(@value=\"Chatter\")]")
	public WebElement eChatter;
	
	@FindBy(xpath="//option[(@value=\"Chatter\")]")
	public WebElement eChatterOption;
	
	@FindBy(xpath="//option[(@value=\"report\")]")
	public WebElement eReportTabOption;
	
	@FindBy(xpath="//img[(@class=\"leftArrowIcon\")]")
	public WebElement eRemoveButton;
	
	@FindBy(xpath="//img[(@class=\"rightArrowIcon\")]")
	public WebElement eAddButton;
	
	@FindBy(xpath="//span[(@id=\"EmailSetup_font\")]")
	public WebElement eEmailLink;
	
	
	@FindBy(xpath="//span[(@id=\"EmailSettings_font\")]")
	public WebElement eEmailSettings;
	
	@FindBy(id="sender_name")
	public WebElement eEmailName;
	
	@FindBy(id="sender_email")
	public WebElement eEmailAddress;
	
	@FindBy(xpath="//input[(@id=\"auto_bcc1\")]")
	public WebElement eAutomaticBCC;
	
	@FindBy(xpath="//input[(@name=\"save\")]")
	public WebElement eSaveButton;
	
	@FindBy(xpath="//span[(@id=\"CalendarAndReminders_font\")]")
	public WebElement eCalendarReminder;
	
	@FindBy(xpath="//span[(@id=\"Reminders_font\")]")
	public WebElement eActivityReminder;
	
	@FindBy(xpath="//input[(@id=\"testbtn\")]")
	public WebElement eTestReminder;
	
	@FindBy(xpath="//a[(@class=\"debugLogLink menuButtonMenuLink\")]")
	public WebElement eDeveloperConsole;
	
	@FindBy(xpath="//a[(@title=\"Logout\")]")
	public WebElement eLogOut ;
	
	public boolean isHomePageDisplayed() {
		return true;
		
	}
	}
	
	

									
	
	
	
	
	
	
	
	
	
	
	
	
	

