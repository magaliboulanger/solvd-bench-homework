import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.TestCasesPage;

public class TestCasesTest extends BaseTest{

    private final String TEST_CASES_URL = "/test_cases";
    @Test(description = "Verify Test Cases Page")
    public void verifyTestCasesPage(){
        HomePage home = new HomePage(getDriver());
        home.openHomePage();
        Assert.assertTrue(home.isPageOpened(), "HomePage is not opened.");
        TestCasesPage tcPage = home.getHeaderComponent().clickTestCasesLink();
        Assert.assertTrue(getDriver().getCurrentUrl().contains(TEST_CASES_URL));
    }
}
