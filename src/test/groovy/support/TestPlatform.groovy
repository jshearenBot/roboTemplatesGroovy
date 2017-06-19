package support

import org.openqa.selenium.WebDriver
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest

/**
 * Created by jshearen on 5/28/17.
 */

abstract class TestPlatform {
    WebDriver webDriver

    void startUpWebBrowser(){
        webDriver = DriverFactory.createStackWebDriver()
    }

    void getStaticWebBrowser(){
        webDriver = DriverFactory.getHeapWebDriver()
    }

    void quitWebDriver(){
        webDriver.quit()
    }
}
