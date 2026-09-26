package tests;


import com.automation.base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test(groups = {"smoke", "regression"})
    public void verifyCheckout() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");

        ProductsPage product = new ProductsPage(driver);

        product.addBackpack();

        product.openCart();

        CartPage cart = new CartPage(driver);

        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.enterCheckoutDetails(
                "John",
                "Doe",
                "411001");

        CheckoutOverviewPage overview =
                new CheckoutOverviewPage(driver);

        overview.finishOrder();

        CheckoutCompletePage complete =
                new CheckoutCompletePage(driver);

        Assert.assertEquals(
                complete.getSuccessMessage(),
                "Thank you for your order!");

    }

}