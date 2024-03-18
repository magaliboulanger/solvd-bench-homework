package pages;

import java.util.List;

import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

public class RegisterPage {


    
    @FindBy(xpath = "//*[@data-qa='account-deleted']")
    private ExtendedWebElement accountDeletedTitle;
    

    public RegisterPage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }
    


 
    


  }
