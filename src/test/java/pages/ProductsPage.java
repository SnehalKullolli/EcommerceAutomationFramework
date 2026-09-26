package pages;

import utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

    WebDriver driver;

    WaitUtility wait;

    public ProductsPage(WebDriver driver){

        this.driver=driver;

        wait=new WaitUtility(driver);

        PageFactory.initElements(driver,this);

    }

    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElement backpack;

    @FindBy(className="shopping_cart_link")
    private WebElement cart;

    @FindBy(className="title")
    private WebElement title;
    
    @FindBy(id="remove-sauce-labs-backpack")
    private WebElement removeButton;

    public void removeBackpack() {

        removeButton.click();

    }

    public String getPageTitle(){

        wait.waitForVisibility(title);

        return title.getText();

    }
    public boolean isBackpackAddButtonDisplayed() {
        return backpack.isDisplayed();
    }

    public void addBackpack(){

        wait.waitForClickable(backpack);

        backpack.click();

    }

    public void openCart(){

        cart.click();

    }

}
