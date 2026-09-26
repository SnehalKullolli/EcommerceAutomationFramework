package tests;



import com.automation.base.BaseTest;
import pages.LoginPage;
import pages.MenuPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyLogout() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");

        MenuPage menu = new MenuPage(driver);

        menu.logout();
        LoginPage loginPage = new LoginPage(driver);

        Assert.assertTrue(
            loginPage.isLoginButtonDisplayed(),
            "Login button should be displayed after logout"
        );

    }

}