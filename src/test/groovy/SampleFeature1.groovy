import org.openqa.selenium.By
import org.testng.annotations.BeforeMethod
import org.testng.annotations.Test
import support.TestPlatform

/**
 * Created by jshearen on 5/28/17.
 */
class SampleFeature1 extends TestPlatform {

    @BeforeMethod(groups ="sanity")
    void getHeapWebDriver(){
        super.getHeapWebDriver();
        webDriver.navigate().to("https://momentfeed.com/")
    }

    @Test(groups = "sanity")
    void clickSolutions(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/solutions/\"]"))
    }

    @Test(groups = "sanity")
    void clickPartners(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/partners/\"]"))
    }

    @Test(groups = "sanity")
    void clickProducts(){
        webDriver.findElement(By.cssSelector("a[href=\"https://momentfeed.com/products/mobile-customer-experience-platform/\"]"))
    }
}
