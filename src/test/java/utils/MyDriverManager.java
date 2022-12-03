package utils;

import com.codeborne.selenide.Configuration;
import io.github.bonigarcia.wdm.managers.ChromeDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static com.codeborne.selenide.Configuration.browser;

public class MyDriverManager {
    @Step("Init Chrome driver")
    public static WebDriver initChromeDriver() {
        browser = "chrome";
        Configuration.browserVersion = "107.0";
        Configuration.browserSize = "1920x1080";


        ChromeDriverManager.getInstance().setup();
        DesiredCapabilities browser = new DesiredCapabilities();
        browser.setBrowserName("chrome");
        browser.setCapability("enableVNC", true);
        browser.setCapability("enableVideo", true);
        RemoteWebDriver driver = null;
        try {
            driver = new RemoteWebDriver(
                    URI.create("http://localhost:4444/wd/hub").toURL(),
                    browser
            );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }


//    public static void configure() throws MalformedURLException {
//        browser = Project.config.browser();
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
//        capabilities.setCapability("enableVNC", true);
//        capabilities.setCapability("enableVideo", true);
//        RemoteWebDriver driver  = new RemoteWebDriver(URI.create("http://localhost:4444/wd/hub").toURL());
//        Configuration.remote = Project.config.remoteDriverUrl();
//
//        if (Project.isRemoteWebDriver()) {
//            capabilities.setCapability("enableVNC", true);
//            capabilities.setCapability("enableVideo", true);
//            Configuration.remote = Project.config.remoteDriverUrl();
//        }
//
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
//        Configuration.browserCapabilities = capabilities;
//        Configuration.timeout = 10000;
//    }
public static WebDriver configure () throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", "107.0");
        capabilities.setCapability("browserSize", "1920x1080");
//        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
//                "enableVNC", true,
//                "enableVideo", true
//        ));
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        RemoteWebDriver driver = new RemoteWebDriver(
                URI.create("http://selenoid:4444/wd/hub").toURL(),
                capabilities
        );
        return driver;

    }
}
