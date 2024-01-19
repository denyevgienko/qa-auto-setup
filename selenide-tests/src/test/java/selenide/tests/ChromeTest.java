package selenide.tests;

import com.codeborne.selenide.Selenide;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ChromeTest {


    @BeforeSuite
    public void beforeSuite(){
        BaseTest.setUp();
        System.out.println("==>>> suite started");
    }

    @AfterTest
    public void after(){
        System.out.println("==>>> test stopped");
    }

    @BeforeTest
    public void before(){
        System.out.println("==>>> test started");
    }

    @Test(description = "check google title")
    public void testTitleGoogle() {
        Selenide.open("https://google.com");
        System.out.println("Get google title result ==>>>" + Selenide.title());
        Selenide.sleep(5000);
        Assert.assertTrue(Selenide.title().equals("Google"));
    }

    @Test(description = "check google open")
    public void testOpenGoogle() {
        Selenide.open("https://google.com");
        Selenide.sleep(3000);
    }
}
