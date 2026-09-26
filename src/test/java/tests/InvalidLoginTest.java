package tests;

import com.automation.base.BaseTest;
import pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.automation.listeners.RetryAnalyzer;

public class InvalidLoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class,groups = {"regression"})
    public void verifyInvalidLogin() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login("invalid_user", "invalid_password");

        Assert.assertTrue(loginPage.getErrorMessage().contains("Username and password do not match"),"Invalid login error should be displayed");
    }
}
