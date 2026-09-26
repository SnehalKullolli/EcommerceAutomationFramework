

package tests;

import com.automation.base.BaseTest;
import com.automation.base.DriverFactory;

import pages.LoginPage;
import pages.ProductsPage;
import utils.DataProviderUtility;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LoginTest extends BaseTest {
	private static final Logger logger =
	        LogManager.getLogger(LoginTest.class);
	
    @Test(groups = {"smoke", "regression"}, 
    		dataProvider = "loginData",
          dataProviderClass = DataProviderUtility.class)
    public void verifyLogin(String username,
                            String password,
                            String expectedResult) {
    	
    	 logger.info("Starting login test for user: {}", username);
         logger.info("Expected result: {}", expectedResult);

        LoginPage loginPage = new LoginPage(driver);
        logger.info("Entering login credentials");

        loginPage.login(username, password);
        logger.info("Login action completed");

        if (expectedResult.equalsIgnoreCase("success")) {
        	logger.info("Validating successful login");

            ProductsPage productsPage =
                    new ProductsPage(driver);

            Assert.assertEquals(
                    productsPage.getPageTitle(),
                    "Productswrong","Products page should be displayed after successful login"
            );
            logger.info("Login successful - Products page displayed");
        } else if (expectedResult.equalsIgnoreCase("error")) {
        	logger.info("Validating invalid login error");
            Assert.assertTrue(
                    loginPage.getErrorMessage()
                            .contains("Username and password do not match"),"Invalid login error should be displayed"
            );
            logger.info("Invalid login error validated successfully");
        } else if (expectedResult.equalsIgnoreCase("locked")) {
        	logger.info("Validating locked user error");
            Assert.assertTrue(
                    loginPage.getErrorMessage()
                            .contains("Sorry, this user has been locked out"),"Locked user error should be displayed"
            );
            logger.info("Locked user error validated successfully");
        }
    }
}