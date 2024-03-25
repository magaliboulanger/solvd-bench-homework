import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountInfoPage;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest{
    private final String userName= R.TESTDATA.get("user.name");
    @Test
    public void testRegisterUser() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage registerPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(registerPage.isPageOpened(), "Register Page is not opened.");
        AccountInfoPage infoPage= registerPage.getSignUpForm().fillSignUpForm(userName, R.TESTDATA.get("user.newEmail"));
        Assert.assertTrue(infoPage.isAccountInformationFormPresent(), "Account information form is not opened.");
        infoPage.fillAccountInformationForm();
        home = infoPage.clickContinueButton();
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed(userName), "The account was not created.");
        home.getHeaderComponent().clickDeleteAccountLink();
        Assert.assertTrue(registerPage.isAccountDeletedTitlePresent(), "The account was not deleted.");
    }
    

    //Test case 5

    @Test(description = "Register user with a existing email")
    public void testRegisterUserWithExistingEmail(){
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage registerPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(registerPage.isPageOpened(), "Register Page is not opened.");
        registerPage.getSignUpForm().fillSignUpForm(userName, R.TESTDATA.get("user.email"));
        Assert.assertTrue(registerPage.getSignUpForm().isEmailErrorPresent(), "The error was not present.");
    }


}
