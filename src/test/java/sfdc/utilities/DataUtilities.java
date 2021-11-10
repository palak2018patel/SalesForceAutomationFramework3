package sfdc.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import sfdc.configs.TestConstants;
public class DataUtilities {
	
	
public String readAccounts(String provideKey) throws IOException {
	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(TestConstants.sAccountProperitesPath);
	prop.load(fis);
	return prop.getProperty(provideKey);	
}

public String readValidationText(String provideKey) throws IOException {
Properties prop = new Properties();
FileInputStream fis = new FileInputStream(TestConstants.sValidationTextProperitesPath);
prop.load(fis);
return prop.getProperty(provideKey);
}
}