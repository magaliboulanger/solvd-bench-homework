import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.AccountInfoPage;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest{
    private final String validEmail = R.TESTDATA.get("user.email");
    private final String validPassword = R.TESTDATA.get("user.password");

    //Test case 1 TODO: connect with zebrunner
    @Test
    public void testRegisterUser() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage registerPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(registerPage.isPageOpened(), "Register Page is not opened.");
        AccountInfoPage infoPage= registerPage.fillRegisterForm();
        Assert.assertTrue(infoPage.isAccountInformationFormPresent(), "Account information form is not opened.");
        infoPage.fillAccountInformationForm();
        home = infoPage.clickContinueButton();
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed(R.TESTDATA.get("user.name")), "The account was not created.");

    
        home.getHeaderComponent().clickDeleteAccountLink();
        Assert.assertTrue(registerPage.isAccountDeletedTitlePresent(), "The account was not deleted.");
    }
    
    
    //Test case 2 and 3
    @DataProvider(name = "getUserData")
    public Object[][] getUserData() {
        return new Object[][]{
                {"ID:01 - Correct email and password", validEmail, validPassword, true},
                {"ID:02 - Incorrect email and password", R.TESTDATA.get("user.invalidEmail"), R.TESTDATA.get("user.invalidPassword"), false}
        };
    }
    @Test(dataProvider = "getUserData")
    public void testLogin(String ID, String email, String password, boolean valid) {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage loginPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page is not opened.");
        home = loginPage.fillLoginForm(email, password);
        if(valid){
            Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not logged.");
        } else {
            Assert.assertTrue(loginPage.isErrorPresent(), "The account was logged with invalid credentials.");

        }
    }
    
    @Test
    public void testLogout() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage loginPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page is not opened.");
        home = loginPage.fillLoginForm(validEmail, validPassword);
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not created.");
        home.getHeaderComponent().clickLogoutButon();
        Assert.assertFalse(home.getHeaderComponent().isNameDisplayed("Test Magali"), "User has not logged out.");
        
    }
   
}
