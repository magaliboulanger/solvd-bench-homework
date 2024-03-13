package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class AccountInfoPage extends BasePage{

    
    @FindBy(xpath = "//*[text()='Enter Account Information']")
    private ExtendedWebElement enterInformationTitle;
    
    @FindBy(css = ".clearfix")
    private List<ExtendedWebElement> genderCheckboxList;
    
    @FindBy(css = "#password")
    private ExtendedWebElement passwordInput;
    
    @FindBy(css = "#days")
    private ExtendedWebElement daySelect;
    
    @FindBy(css = "#months")
    private ExtendedWebElement monthSelect;
    
    @FindBy(css = "#years")
    private ExtendedWebElement yearSelect;
    
    @FindBy(css = "#first_name")
    private ExtendedWebElement firstNameAddressInput;
    
    @FindBy(css = "#last_name")
    private ExtendedWebElement lastNameAddressInput;
    
    @FindBy(css = "#address1")
    private ExtendedWebElement addressInput;
    
    @FindBy(css = "#country")
    private ExtendedWebElement countrySelect;
    
    @FindBy(css = "#state")
    private ExtendedWebElement stateInput;
    
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
    
    
    public AccountInfoPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    
    public boolean isAccountInformationFormPresent() {
        return enterInformationTitle.isElementPresent();
    }
    
    public void fillAccountInformationForm() {
        //TO DO: Put data on config file
        genderCheckboxList.get(0).click();
        passwordInput.type("p@ssw0rd");
        daySelect.select("1");
        monthSelect.select("May");
        yearSelect.select("1980");
        firstNameAddressInput.type("Magali");
        lastNameAddressInput.type("Boulanger");
        addressInput.type("Street 53 1234, Asdfg, Qwerty");
        countrySelect.select("Canada");
        stateInput.type("Asdfg");
        cityInput.type("qwerty");
        zipcodeInput.type("123456");
        mobileNumberInput.type("1234567890");
        createAccountButton.click();
    }
    
    public boolean isAccountCreatedTitlePresent() {
        return accountCreatedTitle.isElementPresent();
    }
    
    public HomePage clickContinueButton() {
        continueButton.click();
        return new HomePage(driver);
    }
    
   
    
    

}
