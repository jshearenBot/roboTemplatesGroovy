

import org.openqa.selenium.By
import org.testng.annotations.Test
import support.TestPlatform

/**
 * Created by jshearen on 5/28/17.
 */
class SampleFeature1 extends TestPlatform {

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
