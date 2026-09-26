package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.WaitUtility;

public class CheckoutPage {

    WebDriver driver;
    WaitUtility wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WaitUtility(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "first-name")
    private WebElement firstName;

    @FindBy(id = "last-name")
    private WebElement lastName;

    @FindBy(id = "postal-code")
    private WebElement postalCode;

    @FindBy(id = "continue")
    private WebElement continueButton;

    public void enterCheckoutDetails(String first, String last, String zip) {
    	wait.waitForVisibility(firstName);
        firstName.sendKeys(first);
        wait.waitForVisibility(lastName);
        lastName.sendKeys(last);
        wait.waitForVisibility(postalCode);
        postalCode.sendKeys(zip);
        wait.waitForClickable(continueButton);
        continueButton.click();
    }
}
