package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.Collections;
import java.util.List;

import static io.netty.util.internal.SystemPropertyUtil.contains;
import static java.awt.SystemColor.text;
import static org.testng.AssertJUnit.assertTrue;

public class TvPage extends AbstractPage {
    //    Actions builder = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    private int selectedFiltersNumber = 0;


    @FindBy(xpath = "//ul//input[@type='checkbox' and @value='samsung']")
    private WebElement searchSamsungChbx;

    @FindBy(xpath = "//input[@placeholder='до']")
    private WebElement searchPriceInput;

    @FindBy(xpath = "//input[@type='checkbox' and @value='1920x1080']")
    private WebElement searchResolutionChbx;

    @FindBy(xpath = "//select[contains(@data-bind, 'value: facet.value.from')]")
    private WebElement searchDiagonalFrom;

    @FindBy(xpath = "//select[contains(@data-bind, 'value: facet.value.to')]")
    private WebElement searchDiagonalTo;

    @FindBy(xpath = "//div[@class='schema-product']")
    private List<WebElement> products;

    @FindBy(xpath = "//span[@class='schema-tags__text']")
    private List<WebElement> tags;

//    @FindBy(xpath = "//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]")
//    private List<WebElement> searchResults;

    public TvPage(WebDriver driver) {
        super(driver);
    }

    public TvPage selectTvMaker() {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(ExpectedConditions.elementToBeClickable(searchSamsungChbx));
        js.executeScript("arguments[0].click();", searchSamsungChbx);
        selectedFiltersNumber++;
        return this;
    }

    public TvPage writePrice() {
        searchPriceInput.sendKeys("1500");
        selectedFiltersNumber++;
        return this;
    }

    public TvPage selectResolution() {
        js.executeScript("arguments[0].click();", searchResolutionChbx);
        selectedFiltersNumber++;
        return this;
    }

    public TvPage selectDiagonal() {
        searchDiagonalFrom.sendKeys("40");
        searchDiagonalTo.sendKeys("50");
        selectedFiltersNumber++;
        return this;
    }

    public int countSearchResults() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//span[@class='schema-tags__text']"), selectedFiltersNumber));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(products));
        List<WebElement> searchResults = driver.findElements(By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]"));
        System.out.println("Search results number for requested terms: " + searchResults.size() + " and tags: " + tags.size());
        return searchResults.size();
    }

    public TvPage vailidateTvMaker() {
        SoftAssert softAssert = new SoftAssert();
        List<WebElement> currentTvMakers = driver.findElements(By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]"));
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElements(products));
        for (WebElement currentTvMaker : currentTvMakers) {
            softAssert.assertTrue(currentTvMaker.getText().contains("Samsung"), "TvMaker is incorrect in case " + currentTvMaker);
            softAssert.assertAll();
        }
        return this;
    }
}