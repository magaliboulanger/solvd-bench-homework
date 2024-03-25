package components;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import pages.AccountInfoPage;

public class SignUpFormComponent extends AbstractUIObject {

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private ExtendedWebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private ExtendedWebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private ExtendedWebElement signupButton;

    @FindBy(xpath = "//p[text()='Email Address already exist!']")
    private ExtendedWebElement existingEmailError;

    protected SignUpFormComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isPageOpened() {
        return signupButton.isElementPresent();
    }
    public AccountInfoPage fillSignUpForm(String name, String email) {
        signupName.type(name);
        signupEmail.type(email);
        signupButton.click();
        return new AccountInfoPage(driver);
    }

    public boolean isEmailErrorPresent() {
        return existingEmailError.isElementPresent();
    }
}
