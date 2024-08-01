package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtils;

public class LoginPage {
    WebDriver driver;

    @FindBy(xpath = "//input[@autocomplete='username']")
    private WebElement loginInput;
    @FindBy(xpath = "//input[@autocomplete='current-password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//button[text()='Log in']")
    private WebElement logInBtn;

    @FindBy(xpath = "//p[@class='sc-lbVpMG cebUWf']")
    private WebElement role;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public void enterLogin(String login){
        loginInput.sendKeys(login);
    }
    public void enterPassword(String password){
        passwordInput.sendKeys(password);
    }
    public void clickLogin(){
        logInBtn.click();
    }


    public WebElement getRoleWebElement(){
        return role;
    }

    public void logIn(String login, String password){
        enterLogin(login);
        enterPassword(password);
        clickLogin();
        SeleniumUtils.waitForElementTobeVisible(role,driver,10);
    }
}
