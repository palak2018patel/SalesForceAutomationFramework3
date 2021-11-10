package sfdc.tests;

import org.testng.Assert;

public class CreateAccount extends BaseTest{
@Test
public void createAccount_TC12() {
	//launchApp();
	//loginApp();
	//clickOnAccounts();
	//createNewView();
	Assert.assertNotNull(accountPage.clickOnAccounts());
	accountPage.createNewView();
	
	
}
}
