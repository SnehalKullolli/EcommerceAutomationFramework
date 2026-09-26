package tests;

import com.automation.base.BaseTest;
import pages.LoginPage;
import pages.ProductsPage;

import org.testng.Assert;
import org.testng.annotations.Test;

public class RemoveFromCartTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyRemoveProduct() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");

        ProductsPage products = new ProductsPage(driver);

        products.addBackpack();

        products.removeBackpack();
        Assert.assertTrue(
                products.isBackpackAddButtonDisplayed(),
                "Add to Cart button should be displayed after removing the product"
            );

    }

}
