package pages;

import components.ContactUsForm;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage{

    @FindBy(css="#contact-page")
    private ContactUsForm contactForm;
    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    public ContactUsForm getContactUsForm(){
        return contactForm;
    }
}
