package components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.HomePage;

public class LoginFormComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@data-qa='login-email']")
    private ExtendedWebElement emailLoginInput;

    @FindBy(xpath = "//input[@data-qa='login-password']")
    private ExtendedWebElement passwordLoginInput;

    @FindBy(xpath = "//button[@data-qa='login-button']")
    private ExtendedWebElement loginButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private ExtendedWebElement errorMessageLogin;
    protected LoginFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
    public boolean isPageOpened() {
        return loginButton.isElementPresent();
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

}
