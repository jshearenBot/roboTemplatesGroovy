import org.openqa.selenium.By
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeMethod
import org.testng.annotations.BeforeTest
import org.testng.annotations.Test
import support.TestPlatform

/**
 * Created by jshearen on 5/29/17.
 */
class SteamCommunityScenarios extends TestPlatform {

    @BeforeTest (groups = "sanity")
    void getHeapWebDriver(){
        super.createStackWebDriver();
        webDriver.navigate().to("http://steamcommunity.com/")
    }

    @AfterTest (groups = "sanity")
    void quitWebDriver(){
        super.quitWebDriver()
    }

    @Test(groups = "sanity")
    void verifyFooter(){
        webDriver.findElement(By.cssSelector("#footer > div"))
    }

    @Test
    void verifyStoreNavElement(){
        webDriver.findElement(By.cssSelector("#global_header > div > div.supernav_container > a:nth-child(1)")).click()
    }

    @Test
    void verifyCommunityNavElement(){
        webDriver.findElement(By.cssSelector("#global_header > div > div.supernav_container > a:nth-child(3)")).click()
    }
}
