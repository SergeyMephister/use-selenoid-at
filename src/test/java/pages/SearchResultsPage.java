package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class SearchResultsPage {
    private final SelenideElement results =  $("[id=search]");

    @Step("Проверка присутствия нужного текста в результатах поиска")
    public void checkingResults(String search) {
        //TODO: Сделать проверку на то что элемент существует
        results.shouldHave(text(search));
    }
}
