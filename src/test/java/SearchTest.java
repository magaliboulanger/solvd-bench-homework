import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class SearchTest extends BaseTest {

    
    //TestCase 9
    @Test
    public void testSearch() {
        HomePage home = openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        home.getHeaderComponent().clickProductsLink();
        
        //TO DO
        
    }
}
