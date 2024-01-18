package chrome.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.FileDownloadMode;
import org.openqa.selenium.MutableCapabilities;

import java.util.Map;

public class BaseTest {


    public static void setUp() {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserCapabilities = capabilities();
        Configuration.headless = false;
        Configuration.fileDownload = FileDownloadMode.HTTPGET;
        Configuration.proxyEnabled = false;
    }

    public static MutableCapabilities capabilities() {
        String browserVersion = "119.0";

        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.setCapability("browserVersion", browserVersion);
        mutableCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true,
                "name", "trello",
                "sessionTimeout", "1m"
        ));
        return mutableCapabilities;
    }
}
