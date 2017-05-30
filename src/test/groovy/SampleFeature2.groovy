import org.openqa.selenium.By
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import support.TestPlatform

/**
 * Created by jshearen on 5/29/17.
 */
class SampleFeature2 extends TestPlatform {

    @BeforeTest
    void getHeapWebDriver(){
        super.createStackWebDriver();
        webDriver.navigate().to("https://momentfeed.com/")
    }

    @AfterTest
    void closeWebDriver(){
        webDriver.close()
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
