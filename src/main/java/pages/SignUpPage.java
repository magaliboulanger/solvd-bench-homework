package pages;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SignUpPage extends BasePage{

    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private ExtendedWebElement signupName;

    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private ExtendedWebElement signupEmail;

    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private ExtendedWebElement signupButton;

    public SignUpPage(WebDriver driver) {
        super(driver);
    }
    public AccountInfoPage fillRegisterForm() {
        signupName.type(R.TESTDATA.get("user.name"));
        signupEmail.type(R.TESTDATA.get("user.newEmail"));
        signupButton.click();
        return new AccountInfoPage(driver);
    }

    public boolean isPageOpened() {
        return signupButton.isElementPresent();
    }

    public boolean isAccountDeletedTitlePresent() {
        return accountDeletedTitle.isElementPresent();
    }



}


