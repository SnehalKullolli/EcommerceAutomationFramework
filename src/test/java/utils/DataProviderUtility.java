
package utils;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	    @DataProvider(name = "loginData")
	    public static Object[][] loginData() {

	        return ExcelUtility.getExcelData("LoginData");
	    }
	}
