package pages;

import utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {

    WebDriver driver;

    WaitUtility wait;

    public CartPage(WebDriver driver){

        this.driver=driver;

        wait=new WaitUtility(driver);

        PageFactory.initElements(driver,this);

    }

    @FindBy(id="checkout")
    private WebElement checkoutButton;

    @FindBy(className="inventory_item_name")
    private WebElement productName;

    public String getProductName(){

        wait.waitForVisibility(productName);

        return productName.getText();

    }

    public void clickCheckout(){

        checkoutButton.click();

    }

}