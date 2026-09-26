package tests;

import com.automation.base.BaseTest;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AddToCartTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyAddProductToCart() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user", "secret_sauce");

        ProductsPage products = new ProductsPage(driver);

        products.addBackpack();

        products.openCart();

        CartPage cart = new CartPage(driver);

        Assert.assertEquals(cart.getProductName(), "Sauce Labs Backpack", "Sauce Labs Backpack should be added to the cart");

    }

}