package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;

public class ConfigDriver {
    private static final String SERVER_URL = "http://127.0.0.1:4723/wd/hub";

    public static AppiumDriver getAndroidDriver() throws MalformedURLException {
        URL serverUrl = new URL(SERVER_URL);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 3 API 29");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

        AppiumDriver driver = new AndroidDriver(serverUrl, desiredCapabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 15000);

        return driver;
    }

    public static AppiumDriver getIOSDriver() throws MalformedURLException {
        URL serverUrl = new URL(SERVER_URL);
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iOS");
        desiredCapabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13.3");
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPad mini 4 ");
        desiredCapabilities.setCapability(MobileCapabilityType.UDID, "96296D9B-C328-49C7-A813-9886A3E4EA20");
        desiredCapabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
        desiredCapabilities.setCapability(MobileCapabilityType.FULL_RESET, "true");
        desiredCapabilities.setCapability("showXcodeLog", "true");
        desiredCapabilities.setCapability("autoAcceptAlerts", "true");

        AppiumDriver driver = new IOSDriver(serverUrl, desiredCapabilities);
//        WebDriverWait wait = new WebDriverWait(driver, 15000);
        return driver;
    }
}
