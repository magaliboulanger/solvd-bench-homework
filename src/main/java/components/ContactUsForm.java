package components;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
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

    @FindBy(xpath="//input[@name='upload_file']")
    private ExtendedWebElement uploadFileButton;

    @FindBy(xpath="//input[@data-qa='submit-button']")
    private ExtendedWebElement submitButton;

    protected ContactUsForm(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public boolean isGetInTouchTitlePresent(){
        return getInTouchTitle.isElementPresent();
    }

    public void fillContactForm(){
        nameInput.type("magali");
        emailInput.type("test@test.com");
        subjectInput.type("test");
        messageInput.type("this is a test");
        uploadFileButton.click();
        submitButton.click();
    }
}
