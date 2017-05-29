package support

import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver

import java.util.concurrent.TimeUnit

/**
 * Created by jshearen on 5/28/17.
 */
class DriverFactory {

    private static final ThreadLocal<WebDriver> DRIVER_HOLDER = new ThreadLocal<WebDriver>() {
        protected WebDriver initialValue() {
            createNewDriver()
        }
    }

    static WebDriver get() {
        DRIVER_HOLDER.get()
    }

    private static WebDriver createNewDriver() {
        String property = System.getProperty("driver", "firefox")
        def capabilities
        if (property == "chrome") {
            capabilities = DesiredCapabilities.chrome()
        } else if (property == "firefox") {
            System.setProperty("webdriver.gecko.driver", "/usr/local/Cellar/geckodriver/0.16.1/bin/geckodriver")
            capabilities = DesiredCapabilities.firefox()
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
