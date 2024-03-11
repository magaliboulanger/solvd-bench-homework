package pages;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.WebDriver;

@Slf4j
public class HomePage extends BasePage{

    public HomePage(WebDriver driver) {
        super(driver);
        final String url = "https://www.automationexercise.com";
        setPageURL(url);
    }

    public HomePage openHomePage() {
        this.open();
        return new HomePage(driver);
    }
    
    public boolean isPageOpened() {
        return getHeaderComponent().isComponentPresent();
    }
}
