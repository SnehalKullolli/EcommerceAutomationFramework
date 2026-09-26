package tests;



import com.automation.base.BaseTest;
import pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EndToEndTest extends BaseTest {

    @Test(groups = {"regression"})
    public void verifyCompletePurchaseFlow() {

        LoginPage login = new LoginPage(driver);

        login.login("standard_user","secret_sauce");

        ProductsPage products = new ProductsPage(driver);

        products.addBackpack();

        products.openCart();

        CartPage cart = new CartPage(driver);

        cart.clickCheckout();

        CheckoutPage checkout = new CheckoutPage(driver);

        checkout.enterCheckoutDetails(
                "Snehal",
                "Tester",
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
