package helpers;

import com.codeborne.selenide.Configuration;
import config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DriverSettings {
//    public static void configure() {
//        Configuration.browser = "chrome";
//        Configuration.browserVersion = "107.0";
//        Configuration.browserSize = "1920x1080";
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-infobars");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--lang=en-en");
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        Configuration.remote = "http://192.168.1.64:4444/wd/hub";
//
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.timeout = 10000;
//    }
    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-infobars");
        chromeOptions.addArguments("--disable-popup-blocking");
        chromeOptions.addArguments("--disable-notifications");
        chromeOptions.addArguments("--lang=en-en");

        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableVideo", true);
            Configuration.remote = Project.config.remoteDriverUrl();
        }

        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10000;
    }
}
