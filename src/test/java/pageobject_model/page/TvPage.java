package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import pageobject_model.test.WebDriverOnliner;

import java.util.List;
import java.util.Locale;

import static org.testng.AssertJUnit.assertTrue;
import static pageobject_model.page.PropertyReader.*;
import static pageobject_model.test.WebDriverOnliner.*;

public class TvPage extends AbstractPage {

    private static By chbxTvMaker = By.xpath("//ul//input[@type='checkbox' and @value='" + tv.toLowerCase(Locale.ROOT) + "']");
    private static By fieldPrice = By.xpath("//input[@placeholder='до']");
    private static By chbxResolution = By.xpath("//input[@type='checkbox' and @value='" + resolution + "']");
    private static By fieldDiagonalFrom = By.xpath("//select[contains(@data-bind, 'value: facet.value.from')]");
    private static By fieldDiagonalTo = By.xpath("//select[contains(@data-bind, 'value: facet.value.to')]");
    private static By searchResults = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]");
    private static By btnAnimation = By.xpath("//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled schema-filter-button__state_control schema-filter-button__state_animated']");
    private static By findTvMakers = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]");
    private static By findTvPrice = By.xpath("//a[contains(@data-bind, 'attr: {href: $data.prices.html_url_with_region}')]/span");
    private static By findTvDescription = By.xpath("//span[contains(@data-bind, 'html: product.description')]");

    public TvPage(WebDriver driver) {
        super(driver);
    }

    public TvPage selectTvMaker() {
        findAndJsClick(chbxTvMaker);
        waitUntilInvisibile(btnAnimation);
        return this;
    }

    public TvPage writePrice() {
        sendValue(fieldPrice, price);
        waitUntilInvisibile(btnAnimation);
        return this;
    }

    public TvPage selectResolution() {
        findAndJsClick(chbxResolution);
        waitUntilInvisibile(btnAnimation);
        return this;
    }

    public TvPage selectDiagonal() {
        sendValue(fieldDiagonalFrom, diagonalfrom);
        sendValue(fieldDiagonalTo, diagonalto);
        waitUntilInvisibile(btnAnimation);
        return this;
    }

    public TvPage vailidateTvMaker() {
        SoftAssert softAssert = new SoftAssert();
        waitUntilAllVisible(searchResults);
        waitUntilInvisibile(btnAnimation);
        List<WebElement> currentTvMakers = findTvElements(findTvMakers);
        for (WebElement currentTvMaker : currentTvMakers) {
            softAssert.assertTrue(currentTvMaker.getText().contains(tv), "TvMaker is incorrect in case " + currentTvMakers.indexOf(currentTvMaker)+1 );
            softAssert.assertAll();
        }
        return this;
    }

    public TvPage vailidatePrice() {
        SoftAssert softAssert = new SoftAssert();
        waitUntilInvisibile(btnAnimation);
//        waitUntilAllVisible(searchResults);
        List<WebElement> productPrices = findTvElements(findTvPrice);
        for (WebElement productPrice : productPrices) {
            int currentPrice = Integer.parseInt(productPrice.getText().substring(0, productPrice.getText().indexOf(',')));
            int maxPrice = Integer.parseInt(price);
            softAssert.assertTrue(maxPrice >= currentPrice, "price is more than " + maxPrice);
            softAssert.assertAll();
        }
        return this;
    }

    public TvPage vailidateDiagonal() {
        SoftAssert softAssert = new SoftAssert();
        waitUntilInvisibile(btnAnimation);
//        waitUntilAllVisible(searchResults);
        List<WebElement> productDescriptions = findTvElements(findTvDescription);
        for (WebElement productDescription : productDescriptions) {
            int diagonal = Integer.parseInt(productDescription.getText().substring(0, productDescription.getText().indexOf('"')));
            int minDiagonal = Integer.parseInt(diagonalfrom);
            int maxDiagonal = Integer.parseInt(diagonalto);
            softAssert.assertTrue(diagonal >= minDiagonal || diagonal <= maxDiagonal, "tv diagonal is incorrect");
            softAssert.assertAll();
            System.out.println(diagonal);
        }
        return this;
    }

    public TvPage vailidateResolution() {
        SoftAssert softAssert = new SoftAssert();
        waitUntilInvisibile(btnAnimation);
//        waitUntilAllVisible(searchResults);
        List<WebElement> productDescriptions = findTvElements(findTvDescription);
        for (WebElement productDescription : productDescriptions) {
            softAssert.assertTrue(productDescription.getText().contains(resolution), "tv resolution is incorrect");
            softAssert.assertAll();
            System.out.println(resolution);
        }
        return this;
    }
}

