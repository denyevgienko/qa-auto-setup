import driver.manager.WebDriverManager;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class DockerChromeTest {


    @Test
    public void test() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.driver;
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test1 ");
        driver.quit();
    }

    @Test
    public void test2() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.getDriver(DesiredCapabilities.firefox());
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test2 ");
        driver.quit();
    }

    @Test
    public void test3() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.getDriver(DesiredCapabilities.firefox());
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test3 ");
        driver.quit();
    }

    @Test
    public void test4() throws MalformedURLException {
        RemoteWebDriver driver = WebDriverManager.driver;
        driver.get("https://google.com");
        System.out.printf(driver.getTitle() + " test4 ");
    }

}
