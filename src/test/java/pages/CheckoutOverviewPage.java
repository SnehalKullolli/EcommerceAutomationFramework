package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtility;

public class CheckoutOverviewPage {

    WebDriver driver;
    WaitUtility wait;

    public CheckoutOverviewPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtility(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "finish")
    private WebElement finishButton;

    public void finishOrder() {
        wait.waitForClickable(finishButton);
        finishButton.click();
    }
}