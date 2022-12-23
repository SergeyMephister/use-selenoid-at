package helpers;

import com.codeborne.selenide.Configuration;
import config.Project;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.HashMap;
import java.util.Map;

public class DriverSettings {
//    public static void configure() {
//        Configuration.browser = Project.config.browser();
//        Configuration.browserVersion = Project.config.browserVersion();
//        Configuration.browserSize = Project.config.browserSize();
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        ChromeOptions chromeOptions = new ChromeOptions();
//
//        chromeOptions.addArguments("--no-sandbox");
//        chromeOptions.addArguments("--disable-infobars");
//        chromeOptions.addArguments("--disable-popup-blocking");
//        chromeOptions.addArguments("--disable-notifications");
//        chromeOptions.addArguments("--lang=en-en");
//
//        if (Project.isRemoteWebDriver()) {
////            capabilities.setCapability("enableVideo", true);
////            capabilities.setCapability("enableVNC", true);
////            capabilities.setCapability("enableLog", true);
////
////            capabilities.setCapability("videoName","test_video.mp4");
//            Map<String, Object> options = new HashMap<>();
//            options.put("enableVNC", true);
//            options.put("enableVideo", true);
//            capabilities.setCapability("selenoid:options", options);
//
//
//            Configuration.remote = Project.config.remoteDriverUrl();
//        }
//
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.timeout = 10000;
//    }
//    public static void configure() {
//        Configuration.browser = "firefox";
//        Configuration.browserVersion = "105.0";
//        Configuration.browserSize = Project.config.browserSize();
//
//        DesiredCapabilities capabilities = new DesiredCapabilities();
//        FirefoxOptions firefoxOptions = new FirefoxOptions();
//
////        firefoxOptions.addArguments("--no-sandbox");
////        firefoxOptions.addArguments("--disable-infobars");
////        firefoxOptions.addArguments("--disable-popup-blocking");
////        firefoxOptions.addArguments("--disable-notifications");
////        firefoxOptions.addArguments("--lang=en-en");
//
//        if (Project.isRemoteWebDriver()) {
//            capabilities.setCapability("enableVideo", true);
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableLog", true);
//
//            capabilities.setCapability("videoName","test_video.mp4");
////            Map<String, Object> options = new HashMap<>();
////            options.put("enableVNC", true);
////            options.put("enableVideo", true);
////            capabilities.setCapability("selenoid:options", options);
//
//
//            Configuration.remote = Project.config.remoteDriverUrl();
//        }
//
//        //capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.timeout = 10000;
//    }
    //Доработка метода под разные браузеры
    public static void configure() {
        Configuration.browser = Project.config.browser();
        Configuration.browserVersion = Project.config.browserVersion();
        Configuration.browserSize = Project.config.browserSize();

        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Project.config.browser().equals("chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-popup-blocking");
            chromeOptions.addArguments("--disable-notifications");
            chromeOptions.addArguments("--lang=en-en");
            capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
        }
        else if (Project.config.browser().equals("firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--no-sandbox");
            firefoxOptions.addArguments("--disable-infobars");
            firefoxOptions.addArguments("--disable-popup-blocking");
            firefoxOptions.addArguments("--disable-notifications");
            firefoxOptions.addArguments("--lang=en-en");
            capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, firefoxOptions);
        }
        if (Project.isRemoteWebDriver()) {
            capabilities.setCapability("enableVideo", true);
            capabilities.setCapability("enableVNC", true);
            capabilities.setCapability("enableLog", true);

            Configuration.remote = Project.config.remoteDriverUrl();
        }
        Configuration.browserCapabilities = capabilities;
        Configuration.timeout = 10000;

    }
}
