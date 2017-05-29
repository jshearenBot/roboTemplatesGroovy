package support

import org.openqa.selenium.WebDriver
import org.testng.annotations.BeforeMethod

/**
 * Created by jshearen on 5/28/17.
 */

abstract class TestPlatform {
    WebDriver webDriver

    @BeforeMethod
    void setupWebBrowser(){
        webDriver = DriverFactory.get();
    }
}
