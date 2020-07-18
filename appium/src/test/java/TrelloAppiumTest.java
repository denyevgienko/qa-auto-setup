import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static driver.ConfigDriver.getAndroidDriver;
import static driver.ConfigDriver.getIOSDriver;

public class TrelloAppiumTest {
    private AppiumDriver driver;

    @Test
    public void androidTest() throws MalformedURLException {
        driver = getAndroidDriver();
        driver.get("https://trello.com/");
        driver.findElement(By.cssSelector("a[href='/login']")).isDisplayed();
        driver.close();
    }

    @Test
    public void IOSTest() throws MalformedURLException {
        driver = getIOSDriver();
        driver.get("https://trello.com/");
        driver.findElement(By.cssSelector("a[href='/login']")).isDisplayed();
        driver.close();
    }
}
