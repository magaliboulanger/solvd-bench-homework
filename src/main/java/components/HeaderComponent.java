package components;

import com.zebrunner.carina.webdriver.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.decorator.ExtendedWebElement;

import pages.ProductsListPage;
import pages.RegisterPage;

public class HeaderComponent extends AbstractUIObject {

    public HeaderComponent(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        // TODO Auto-generated constructor stub
    }

    @FindBy(css= "ul.nav.navbar-nav>li>a[href='/products']")
    private ExtendedWebElement productsLink;
    
    @FindBy(xpath= "//header[@id='header']//a[contains(text(), 'Signup')]")
    private ExtendedWebElement signUpLink;
    
    @FindBy(xpath = "//a[text()=' Delete Account']")
    private ExtendedWebElement deleteAccountLink;
    
    @FindBy(xpath=" //a[text()=' Logout']")
    private ExtendedWebElement logoutButton;
    
    @FindBy(xpath = "//b[contains(text(),'%s')]")
    private ExtendedWebElement loggedInMessage;
    
    public ProductsListPage clickProductsLink() {
        productsLink.click();
        return new ProductsListPage(driver);
    }
    
    public RegisterPage clickSignUpLink() {
        signUpLink.click();
        return new RegisterPage(driver);
    }
    
    public boolean isComponentPresent() {
        return productsLink.isElementPresent();
    }
    
    public void clickDeleteAccountLink() {
        deleteAccountLink.click();
    }
    
    public boolean isUserLogedIn() {
        return logoutButton.isElementPresent();
    }
    
    public boolean isNameDisplayed(String name) {
        return loggedInMessage.format(name).isElementPresent();
    }
    
    public void clickLogoutButon() {
        logoutButton.click();
    }
}
