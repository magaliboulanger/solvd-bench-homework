package pages;

import java.util.List;

import com.zebrunner.carina.utils.R;
import components.LoginFormComponent;
import components.SignUpFormComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class RegisterPage extends BasePage{
    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    private ExtendedWebElement accountDeletedTitle;

    @FindBy(css=".login-form")
    private LoginFormComponent loginForm;

    @FindBy(css=".signup-form")
    private SignUpFormComponent signUpForm;

    public RegisterPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    public LoginFormComponent getLoginForm(){
        return loginForm;
    }
    public SignUpFormComponent getSignUpForm(){
        return signUpForm;
    }
    

    

 
    
    public boolean isAccountDeletedTitlePresent() {
        return accountDeletedTitle.isElementPresent();
    }



}
