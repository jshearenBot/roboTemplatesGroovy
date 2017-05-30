package support

import org.openqa.selenium.WebDriver
import org.openqa.selenium.phantomjs.PhantomJSDriverService
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

/**
 * Created by jshearen on 5/28/17.
 */
class DriverFactory {

    private static final ThreadLocal<WebDriver> HEAP_WEB_DRIVER = new ThreadLocal<WebDriver>() {
        protected WebDriver initialValue() {
            createWebDriver()
        }
    }

    static WebDriver getHeapWebDriver() {
        HEAP_WEB_DRIVER.get()
    }

    static final WebDriver createStackWebDriver(){
        ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>(){
            protected WebDriver initialValue(){
                createWebDriver()
            }
        }
        webDriver.get()
    }

    private static WebDriver createWebDriver() {
        String property = System.getProperty("driver", "chrome")
        def capabilities

        if (property == "chrome") {
            capabilities = DesiredCapabilities.chrome()

        } else if (property == "firefox") {
            System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.1/bin/geckodriver")
            capabilities = DesiredCapabilities.firefox()

        } else if (property == "phantomjs"){
            def cliArgsCap = new ArrayList<String>()
            cliArgsCap.add("--web-security=false")
            cliArgsCap.add("--ssl-protocol=any")
            cliArgsCap.add("--ignore-ssl-errors=true")
            capabilities = DesiredCapabilities.phantomjs()
            capabilities.setCapability("takesScreenshot", true);
            capabilities.setCapability(PhantomJSDriverService.PHANTOMJS_CLI_ARGS, cliArgsCap);
        }

        def url = System.getProperty("seleniumServerUrl", "http://localhost:4444/wd/hub")

        if (!url) {
            throw new IllegalStateException("No 'seleniumServerUrl' system property set")
        }

        def webDriver = new RemoteWebDriver(new URL(url), capabilities)

        Runtime.addShutdownHook {
            try {
                webDriver.quit()
            } catch (ignore) {
            }
        }
        webDriver
    }
}
