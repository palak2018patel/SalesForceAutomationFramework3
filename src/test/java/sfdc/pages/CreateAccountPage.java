package sfdc.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sfdc.tests.BaseTest;

public class CreateAccountPage extends BaseTest {
	
	public CreateAccountPage(WebDriver driver) {
		PageFactory.initElements(driver,this);//constructor
	}
	
public String clickOnAccounts() {
	return "Accounts Tab";
}

public void createNewView() {		
	
}
@FindBy(xpath="//a[(@title=\"Accounts Tab\")]")
public WebElement eAccountsTabLink ;

@FindBy(xpath="//input[(@title=\"New\")]")
public WebElement eNewAccBton ;


@FindBy(xpath="//input[(@id=\"acc2\")]")
public WebElement eNewAccName  ;


@FindBy(xpath="//input[(@title=\"Save\")]")
public WebElement eAccSave ;


@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[2]/a[2]")
public WebElement eAccCreateNewView ;


@FindBy(xpath="//input[@id=\"fname\"]")
public WebElement eAccViewName ;


@FindBy(xpath="//input[@id=\"devname\"]")
public WebElement eAccViewUniqueName;


@FindBy(xpath="//select[(@title='View:')]")
public WebElement eViewNameToEdit ;


@FindBy(xpath="//*[@id=\"filter_element\"]/div/span/span[2]/a[1]")
public WebElement eEditLink ;


@FindBy(xpath="//select[(@id=\"fcol1\")]")
public WebElement eFilterfieldAccount ;


@FindBy(xpath="//option[(@value=\"ACCOUNT.NAME\")]")
public WebElement eFilterAccNameOption ;


@FindBy(xpath="//select[(@id=\"fop1\")]")
public WebElement eFilterfieldOperator;

@FindBy(xpath="//option[(@value='c')]")
public WebElement eFilterOperatorContains ;

@FindBy(xpath="//input[(@id=\"fval1\")]")
public WebElement eFilterValue ;

@FindBy(xpath="//*[@id=\"colselector_select_0\"]/option[31]")
public WebElement eLastActivityTab ;

@FindBy(xpath="//img[(@class=\"rightArrowIcon\")]")
public WebElement eAddBtn ;

@FindBy(xpath="//input[(@name=\"save\")]")
public WebElement eEditAccSaveBtn;

@FindBy(xpath="//*[@id=\"toolsContent\"]/tbody/tr/td[2]/div/div/div/ul/li[4]/span/a")
public WebElement eMergeAccLink ;

@FindBy(xpath="//input[(@id='srch')]")
public WebElement eAccName1ToMerge;

@FindBy(xpath="//*[@id=\"stageForm\"]/div/div[2]/div[4]/input[2]")
public WebElement eFindAccBtn ;

@FindBy(xpath="//input[(@value=\" Merge \")]")
public WebElement eMergeBtn;


@FindBy(linkText="Accounts with last activity > 30 days")
public WebElement AccWithLastActivityGrtr30days ;

@FindBy(xpath="//input[(@name='dateColumn')]")
public WebElement eDatefieldDrpDwn ;

@FindBy(xpath="//*[@id=\"ext-gen265\"]/div[3]")
public WebElement eCreatedDate ;

@FindBy(xpath="//input[(@name='startDate')]")
public WebElement eFromFieldTodaysDate ;

@FindBy(xpath="//input[(@name='endDate')]")
public WebElement eToFieldEndDate ;

@FindBy(xpath="//button[(@id='ext-gen49')]")
public WebElement eSaveBtn ;

@FindBy(xpath="//input[(@name='reportName')]")
public WebElement eReportNamePopUpWindow ;

@FindBy(xpath="//input[(@name='reportDevName')]")
public WebElement  eReportUniqueName;

@FindBy(xpath="//button[(@id='ext-gen286')]")
public WebElement eCreateAccSaveandRun;

@FindBy(xpath="//input[(@id=\"cid0\")]")
public WebElement  checkbox;

@FindBy(xpath="//input[(@name=\"goNext\")]")
public WebElement eNext ;

@FindBy(xpath="//*[@id=\"thePage:sectionHeader\"]/div/div/div[1]")
public WebElement eReportDisplayPage ;


@FindBy(xpath="//*[@id='ext-gen290']/tbody/tr[2]/td/table/tbody/tr[5]/td[7]/a/em/span")
public WebElement eAccStartDt ;


@FindBy(xpath="//*[@id=\"ext-gen152\"]")
public WebElement eFromCalendar ;


@FindBy(xpath="//*[@id=\"ext-gen154\"]")
public WebElement eToCalendar ;





//@FindBy(xpath=)
//public WebElement  ;

}

