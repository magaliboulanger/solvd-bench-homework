package pages;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class HomePage extends BasePage{

    private String URL="";
    public HomePage(WebDriver driver) {
        super(driver);
        URL = "https://www.automationexercise.com";
        //setPageURL(url);
    }

    public HomePage openHomePage() {
        getDriver().get(URL);
        return new HomePage(getDriver());
    }
    
    public boolean isPageOpened() {
        return getHeaderComponent().isComponentPresent();
    }
}
