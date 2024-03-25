import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.RegisterPage;

public class ContactUsTest extends BaseTest{

    //Test Case 6
    @Test(description = "Verify Contact Us Form behavior")
    public void testContactUsForm(){
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        ContactUsPage contactPage = home.getHeaderComponent().clickContactUsLink();
        Assert.assertTrue(contactPage.getContactUsForm().isGetInTouchTitlePresent(), "Get In Touch title is not visible");
        contactPage.getContactUsForm().fillContactForm();

    }
}
