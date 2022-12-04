package tests;

import io.qameta.allure.Description;
import io.qameta.allure.Issue;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.GoogleMainPage;
import pages.SearchResultsPage;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class UiTest extends BaseSelenideTest {
    @Test
    @Owner("Sergey Mephister")
    @Description("Search for one word and checking results")
    @DisplayName("Search for one word and checking results")
    public void searchBySelenide() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.openGoogleMainPage("https://google.com");
        sleep(50000);
        googleMainPage.fillInputSearch("Selenide");
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.checkingResults("selenide.org");
    }

    @Test
    @Owner("Sergey Mephister")
    @Description("Search false")
    @DisplayName("Search falses")
    @Issue("QS-7")
    public void searchBySelenideTestError() {
        GoogleMainPage googleMainPage = new GoogleMainPage();
        googleMainPage.openGoogleMainPage("https://google.com");
        googleMainPage.fillInputSearch("Selenide");
        SearchResultsPage searchResultsPage = new SearchResultsPage();
        searchResultsPage.checkingResults("selenide.orger");
    }
}
