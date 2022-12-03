package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.junit5.AllureJunit5;
import io.qameta.allure.selenide.AllureSelenide;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import utils.DriverSettings;
import utils.MyDriverManager;

import java.net.MalformedURLException;

@ExtendWith({AllureJunit5.class})
public class BaseSelenideTest {

//    @BeforeEach
//    public void setup() throws MalformedURLException {
//
//        WebDriverRunner.setWebDriver(configure());
//
//    }
    @BeforeAll
    public static void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        DriverSettings.configure();
    }

    @AfterEach
    public void tearDown() {
        Selenide.closeWebDriver();
    }
}
