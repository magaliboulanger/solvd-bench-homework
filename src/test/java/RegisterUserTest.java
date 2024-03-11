import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AccountInfoPage;
import pages.HomePage;
import pages.RegisterPage;

public class RegisterUserTest extends BaseTest{
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
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Magali"), "The account was not created.");
        //TODO: data provider
        home = infoPage.clickContinueButton();
    
        home.getHeaderComponent().clickDeleteAccountLink();
        Assert.assertTrue(registerPage.isAccountDeletedTitlePresent(), "The account was not deleted.");
    }
    
    
    //Test case 2 
    //Test case 3 (with data provider - use the same with wrong data)
    @Test
    public void testLogin() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage loginPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page is not opened.");
        home = loginPage.fillLoginForm();
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not created.");
       
        //home.getHeaderComponent().clickDeleteAccountLink();
        //Assert.assertTrue(loginPage.isAccountDeletedTitlePresent(), "The account was not created.");
    }
    
    @Test
    public void testLogout() {
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        RegisterPage loginPage = home.getHeaderComponent().clickSignUpLink();
        Assert.assertTrue(loginPage.isPageOpened(), "Login Page is not opened.");
        home = loginPage.fillLoginForm();
        Assert.assertTrue(home.getHeaderComponent().isNameDisplayed("Test Magali"), "The account was not created.");
        home.getHeaderComponent().clickLogoutButon();
        Assert.assertFalse(home.getHeaderComponent().isNameDisplayed("Test Magali"), "User has not logged out.");
        
    }
   
}
