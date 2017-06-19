package pages

import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.testng.Assert
import support.TestPlatform

/**
 * Created by jshearen on 6/7/17.
 */
class SeleniumConfBasePage {
    WebDriver webDriver
    def baseUrl = "http://seleniumconf.de/"

    SeleniumConfBasePage (WebDriver webDriver){
        this.webDriver = webDriver
        navigateToBaseUrl()
    }

    SeleniumConfBasePage navigateToBaseUrl(){
        webDriver.navigate().to(baseUrl)
        return this
    }

    SeleniumConfBasePage verifyEmbededMediaPresent(){
        webDriver.findElement(By.cssSelector("div.embed-responsive"))
        return this
    }

    SeleniumConfBasePage clickBuyNow(){
        webDriver.findElement(By.cssSelector("a.btn.btn--primary")).click()
        return this
    }

    SeleniumConfBasePage navigateBack(){
        webDriver.navigate().back()
        return this
    }

    SeleniumConfBasePage verifyNavBarPresent(){
        webDriver.findElement(By.cssSelector("ul.navbar-nav"))
        return this
    }

    SeleniumConfBasePage verifyAvatarCountEquals(int expectedCount){
        List<WebElement> elementList = webDriver.findElements(By.cssSelector("img.avatar__image"))
        int elementCount = elementList.size()
        Assert.assertEquals(elementCount,expectedCount)
        return this
    }
}
