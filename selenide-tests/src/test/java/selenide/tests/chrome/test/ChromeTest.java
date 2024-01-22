package selenide.tests.chrome.test;

import com.codeborne.selenide.Selenide;
import config.MainConfig;
import io.qameta.allure.Allure;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChromeTest extends MainConfig {

    @AfterTest
    public void after() {
        System.out.println("==>>> test stopped");
    }

    @BeforeTest
    public void before() {
        System.out.println("==>>> test started");
    }

    @Test(description = "check google title")
    public void testTitleGoogle() {
        Allure.step("Open google page", () -> {
            Selenide.open("https://google.com");
        });
        System.out.println("Get google title result ==>>>" + Selenide.title());
        Selenide.sleep(5000);
        Allure.step("Check google title", () -> {
            Assert.assertEquals(Selenide.title(), "Google");
        });
    }

    @Test(description = "check google open")
    public void testOpenGoogle() {
        Allure.step("Open google page and wait few seconds", () -> {
            Selenide.open("https://google.com");
            Selenide.sleep(3000);
        });

    }
}
