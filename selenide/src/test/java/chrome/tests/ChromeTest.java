package chrome.tests;

import com.codeborne.selenide.Selenide;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import static chrome.tests.BaseTest.setUp;


public class ChromeTest {


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("==>>> test started");
    }

    @Test
    public void test() {
        setUp();
        Selenide.open("https://google.com");
        System.out.print("test result ==>>>" + Selenide.title());
        Selenide.sleep(15000);
        Selenide.title().contains("google");
    }
}
