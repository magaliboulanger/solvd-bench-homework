package components;

import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsForm extends AbstractUIObject {

    @FindBy(xpath="//h2[contains(@class, 'title') and text()='Get In Touch']")
    private ExtendedWebElement getInTouchTitle;

    @FindBy(xpath="//input[@data-qa='name']")
    private ExtendedWebElement nameInput;

    @FindBy(xpath="//input[@data-qa='email']")
    private ExtendedWebElement emailInput;

    @FindBy(xpath="//input[@data-qa='subject']")
    private ExtendedWebElement subjectInput;

    @FindBy(xpath="#message")
    private ExtendedWebElement messageInput;

    @FindBy(xpath="//input[@type='file']")
    private WebElement uploadFileInput;

    @FindBy(xpath="//input[@data-qa='submit-button']")
    private ExtendedWebElement submitButton;

    protected ContactUsForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isGetInTouchTitlePresent(){
        return getInTouchTitle.isElementPresent();
    }

    public void fillContactForm(){
        nameInput.type(R.TESTDATA.get("ContactForm.name"));
        emailInput.type(R.TESTDATA.get("ContactForm.email"));
        subjectInput.type(R.TESTDATA.get("ContactForm.subject"));
        messageInput.type(R.TESTDATA.get("ContactForm.messag"));
        uploadFileInput.sendKeys(R.TESTDATA.get("ContactForm.filePath"));
        submitButton.click();
    }
}
