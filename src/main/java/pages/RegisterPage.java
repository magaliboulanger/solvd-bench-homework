package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class RegisterPage extends BasePage{

    //input[@name='name']
    @FindBy(xpath = "//input[@data-qa='signup-name']")
    private ExtendedWebElement signupName;
    
    @FindBy(xpath = "//input[@data-qa='signup-email']")
    private ExtendedWebElement signupEmail;
    
    @FindBy(xpath = "//button[@data-qa='signup-button']")
    private ExtendedWebElement signupButton;
    
    @FindBy(xpath = "//*[text()='Enter Account Information']")
    private ExtendedWebElement enterInformationTitle;
    
    @FindBy(css = ".clearfix")
    private List<WebElement> genderCheckboxList;
    
    @FindBy(css = "#password")
    private ExtendedWebElement passwordInput;
    
    @FindBy(css = "#days")
    private Select daySelect;
    
    @FindBy(css = "#months")
    private Select monthSelect;
    
    @FindBy(css = "#years")
    private Select yearSelect;
    
    @FindBy(css = "#first_name")
    private ExtendedWebElement firstNameAddressInput;
    
    @FindBy(css = "#last_name")
    private ExtendedWebElement lastNameAddressInput;
    
    @FindBy(css = "#address1")
    private ExtendedWebElement addressInput;
    
    @FindBy(css = "#country")
    private Select countrySelect;
    
    @FindBy(css = "#state")
    private WebElement stateInput;
    
    @FindBy(css = "#city")
    private ExtendedWebElement cityInput;
    
    @FindBy(css = "#zipcode")
    private ExtendedWebElement zipcodeInput;
    
    @FindBy(css = "#mobile_number")
    private ExtendedWebElement mobileNumberInput;
    
    @FindBy(xpath = "//button[@data-qa='create-account']")
    private ExtendedWebElement createAccountButton;
    
    @FindBy(xpath = "//*[@data-qa='account-created']")
    private ExtendedWebElement accountCreatedTitle;

    @FindBy(xpath = "//button[@data-qa='continue-button']")
    private ExtendedWebElement continueButton;
    
    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    private ExtendedWebElement accountDeletedTitle;
    
    @FindBy(xpath = "//input[@data-qa='login-email']")
    private ExtendedWebElement emailLoginInput;
    
    @FindBy(xpath = "//input[@data-qa='login-password']")
    private ExtendedWebElement passwordLoginInput;
    
    @FindBy(xpath = "//input[@data-qa='login-button']")
    private ExtendedWebElement loginButton;
    
    public RegisterPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    
    public boolean isPageOpened() {
        return signupButton.isElementPresent();
    }
    
    public AccountInfoPage fillRegisterForm() {
      //TODO: data provider
        signupName.type("Magali");
        signupEmail.type("mboulanger4@solvd.com");
        signupButton.click();
        return new AccountInfoPage(driver);
    }
 
    
    public boolean isAccountDeletedTitlePresent() {
        return accountDeletedTitle.isElementPresent();
    }

    public HomePage fillLoginForm() {
        //TODO: data provider
        emailLoginInput.type("testmagali@gmail.com");
        passwordLoginInput.type("1234");
        loginButton.click();
        return new HomePage(driver);
        
    }
}
