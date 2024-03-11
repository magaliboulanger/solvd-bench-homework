package pages;

import groovy.util.logging.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import com.zebrunner.carina.webdriver.gui.AbstractPage;

import components.HeaderComponent;

@Slf4j
public class BasePage extends AbstractPage{
    protected BasePage(WebDriver driver) {
        super(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(css=".header-middle")
    private HeaderComponent header;
    
    public HeaderComponent getHeaderComponent(){
        return header;
    }

}
