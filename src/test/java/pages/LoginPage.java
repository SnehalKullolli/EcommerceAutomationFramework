package pages;

import utils.WaitUtility;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;
    WaitUtility wait;

    public LoginPage(WebDriver driver){

        this.driver=driver;
        wait=new WaitUtility(driver);

        PageFactory.initElements(driver,this);

    }

    @FindBy(id="user-name")
    private WebElement username;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(id="login-button")
    private WebElement loginButton;

    @FindBy(css=".error-message-container")
    private WebElement errorMessage;

    public void login(String user,String pass){

        wait.waitForVisibility(username);

        username.clear();
        username.sendKeys(user);

        password.clear();
        password.sendKeys(pass);

        loginButton.click();

    }

    public String getErrorMessage(){

        return errorMessage.getText();

    }
    public boolean isLoginButtonDisplayed() {
        return loginButton.isDisplayed();
    }

}