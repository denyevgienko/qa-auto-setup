package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.MutableCapabilities;

import java.util.Map;

public class MainConfig {
    static {
        Configuration.remote = "http://localhost:4444/wd/hub";
        Configuration.browserCapabilities = capabilities();
    }

    public static MutableCapabilities capabilities() {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", false,
                "enableVideo", false,
                "name", "aqa-setup-test"
        ));
        return mutableCapabilities;
    }
}
