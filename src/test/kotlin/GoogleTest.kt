import com.codeborne.selenide.CollectionCondition.size
import com.codeborne.selenide.CollectionCondition.sizeGreaterThan
import com.codeborne.selenide.Condition.text
import com.codeborne.selenide.Configuration
import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.open
import com.codeborne.selenide.Selenide.`$`
import com.codeborne.selenide.Selenide.`$$`
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import org.junit.jupiter.api.BeforeAll

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.openqa.selenium.By
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import java.net.URL


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class GoogleTest {

    private var driver: RemoteWebDriver? = null

    @BeforeAll
    fun setUp() {

        val browser = DesiredCapabilities()
        browser.browserName = "chrome"
        browser.version = "75.0"
        //        browser.setCapability("enableVideo", true);
        //        browser.setCapability("enableLog", true);
                browser.setCapability("enableVNC", true);
        driver = RemoteWebDriver(URL(
                "http://localhost:4444/wd/hub" //Replace with correct host and port
        ), browser)
        open("https://google.com/ncr")
    }


    @Test
    fun usingDollarsWithBackticks() {
        `$`(By.name("q")).setValue("selenide").pressEnter()
        `$$`("span.st").shouldHave(sizeGreaterThan(3))
        `$`("span.st").shouldHave(text("concise ui tests in Java"))
    }

    @Test
    fun notUsingDollars() {
        element(By.name("q")).setValue("selenide").pressEnter()
        elements(By.cssSelector("span.st")).shouldHave(size(10))
        element(By.cssSelector("span.st")).shouldHave(text("concise ui tests in Java"))
    }

    @Test
    fun usingAliases() {
        get("[name=q]").setValue("selenide").pressEnter()
        all("span.st").shouldHave(size(10))
        get("span.st").shouldHave(text("concise ui tests in Java"))
    }

    fun get(selector: String): SelenideElement {
        return `$`(selector)
    }

    fun all(selector: String): ElementsCollection {
        return `$$`(selector)
    }
}
