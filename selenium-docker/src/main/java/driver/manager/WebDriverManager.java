package driver.manager;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverManager {

    public static RemoteWebDriver driver = getDriver();

    private static RemoteWebDriver getDriver() {
        try {
            return driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new DesiredCapabilities(DesiredCapabilities.chrome()));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static RemoteWebDriver getDriver(DesiredCapabilities cap) {
        try {
            return driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), new DesiredCapabilities(cap));
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
