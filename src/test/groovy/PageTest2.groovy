import org.testng.annotations.AfterMethod
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import pages.SeleniumConfBasePage
import support.TestPlatform

/**
 * Created by jshearen on 5/29/17.
 */
class PageTest2 extends TestPlatform {

    @BeforeTest (groups = "sanity")
    void startUpWebBrowser(){
        super.startUpWebBrowser();
    }

    @AfterTest (groups = "sanity")
    void closeWebBrowser(){
        super.quitWebDriver()
    }

    @Test
    void testHomePage1(){
        def seleniumConfBasePage = new SeleniumConfBasePage(webDriver)
        .verifyEmbededMediaPresent()
        .clickBuyNow()
        .navigateBack()
    }

    @Test
    void testHomePage2(){
        def seleniumConfBasePage = new SeleniumConfBasePage(webDriver)
        .clickBuyNow()
        .navigateBack()
        .verifyEmbededMediaPresent()
    }

    @Test(groups = "sanity")
    void sanityCheck(){
        def seleniumConfBasePage = new SeleniumConfBasePage(webDriver)
        .verifyNavBarPresent()
        .verifyAvatarCountEquals(4)
    }
}
