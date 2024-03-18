package pages;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private ExtendedWebElement emailLoginInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private ExtendedWebElement passwordLoginInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private ExtendedWebElement errorMessageLogin;

    protected LoginPage(WebDriver driver) {
        super(driver);
    }
    public HomePage fillLoginForm(String email, String password) {
        emailLoginInput.type(email);
        passwordLoginInput.type(password);
        loginButton.click();
        return new HomePage(driver);
    }
    public boolean isErrorPresent() {
        return errorMessageLogin.isElementPresent();
    }

    public boolean isPageOpened() {
        return signupButton.isElementPresent();
    }


}
