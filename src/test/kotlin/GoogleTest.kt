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
import com.codeborne.selenide.WebDriverRunner
//import org.junit.Before
//import org.junit.Test
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
//        Configuration.headless = false
        Configuration.remote = "http://localhost:4444/wd/hub"
        Configuration.driverManagerEnabled = true
        Configuration.holdBrowserOpen = true
        val browser = DesiredCapabilities()
        browser.browserName = "chrome"
        browser.version = "77.0"
                browser.setCapability("enableVideo", true)
                browser.setCapability("enableLog", true)
                browser.setCapability("enableVNC", true)
        driver = RemoteWebDriver(URL(
                "http://localhost:4444/wd/hub"
        ), browser)
//        open("https://google.com/ncr")
        WebDriverRunner.setWebDriver(driver)

    }


//    @Test
//    fun duckDuck() {
//        open("http://duckduckgo.com/")
//        `$`(By.name("q")).setValue("selenide").pressEnter()
//        `$$`("span.st").shouldHave(sizeGreaterThan(3))
//        `$`("span.st").shouldHave(text("concise ui tests in Java"))
//    }
//
//    @Test
//    fun usingDollarsWithBackticks() {
//        open("https://google.com/")
//        `$`(By.name("q")).setValue("selenide").pressEnter()
//        `$$`("span.st").shouldHave(size(0))
//        `$`("span.st").shouldHave(text("concise ui tests in Java"))
//    }
//
//    @Test
//    fun notUsingDollars() {
//        open("https://google.com/")
//        element(By.name("q")).setValue("selenide").pressEnter()
//        element(By.linkText("q")).setValue("selenide").pressEnter()
//        elements(By.cssSelector("span.st")).shouldHave(size(9))
//        element(By.cssSelector("span.st")).shouldHave(text("concise ui tests in Java"))
//    }

    @Test
    fun instagram() {
        open("https://www.instagram.com")
//        element(By.name("q")).setValue("selenide").pressEnter()
        element(By.linkText("Поиск")).setValue("semenanion").pressEnter()
//        elements(By.cssSelector("span.st")).shouldHave(size(9))
//        element(By.cssSelector("span.st")).shouldHave(text("concise ui tests in Java"))
    }

//    @Test
//    fun usingAliases() {
//        open("https://google.com/")
//        get("[name=q]").setValue("selenide").pressEnter()
//        all("span.st").shouldHave(size(9))
//        get("span.st").shouldHave(text("concise ui tests in Java"))
//    }

    fun get(selector: String): SelenideElement {
        return `$`(selector)
    }

    fun all(selector: String): ElementsCollection {
        return `$$`(selector)
    }
}
