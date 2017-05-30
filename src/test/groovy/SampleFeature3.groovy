import org.openqa.selenium.By
import org.testng.annotations.AfterMethod
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import support.TestPlatform

/**
 * Created by jshearen on 5/29/17.
 */
class SampleFeature3 extends TestPlatform{

    @BeforeMethod
    void getHeapWebDriver(){
        super.createStackWebDriver();
        webDriver.navigate().to("https://momentfeed.com/partners/mobile-networks/")
    }

    @AfterMethod
    void quitWebDriver(){
        super.quitWebDriver()
    }

    @Test
    void clickSolutions(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/solutions/\"]")).click()
    }

    @Test
    void clickPartners(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/partners/\"]")).click()
    }

    @Test
    void clickProducts(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/products/mobile-customer-experience-platform/\"]")).click()
    }
}
