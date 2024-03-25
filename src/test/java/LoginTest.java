import com.zebrunner.carina.utils.R;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.RegisterPage;

public class LoginTest extends BaseTest{

    private final String validEmail = R.TESTDATA.get("user.email");
    private final String validPassword = R.TESTDATA.get("user.password");
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
        home = loginPage.getLoginForm().fillLoginForm(email, password);
        if(valid){
            Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not logged.");
        } else {
            Assert.assertTrue(loginPage.getLoginForm().isErrorPresent(), "The account was logged with invalid credentials.");

        }
    }

    @Test
    public void testLogout() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage loginPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page is not opened.");
        home = loginPage.getLoginForm().fillLoginForm(validEmail, validPassword);
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not created.");
        home.getHeaderComponent().clickLogoutButton();
        Assert.assertFalse(home.getHeaderComponent().isNameDisplayed("Test Magali"), "User has not logged out.");

    }
}
