package onliner.page;

import java.util.List;
import java.util.Locale;
import onliner.framework.BaseElement;
import onliner.framework.BasePage;
import org.openqa.selenium.*;
import static onliner.framework.BaseTest.softAssert;
import static onliner.framework.Browser.driver;

public class TvPage extends BasePage {

  private String cbxMaker = "//ul//input[@type='checkbox' and @value='%s']";
  private By fieldPrice = By.xpath("//input[@placeholder='до']");
  private String cbxResolution = "//input[@type='checkbox' and @value='%s']";
  private By fieldMinDiagonal = By.xpath("//select[contains(@data-bind, 'value: facet.value.from')]");
  private By fieldMaxDiagonal = By.xpath("//select[contains(@data-bind, 'value: facet.value.to')]");
  private By searchResults = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]");
  private By animation = By.xpath("//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled schema-filter-button__state_control schema-filter-button__state_animated']");
  private By makerResults = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]");
  private By priceResults = By.xpath("//a[contains(@data-bind, 'attr: {href: $data.prices.html_url_with_region}')]/span");
  private By descriptionResults = By.xpath("//span[contains(@data-bind, 'html: product.description')]");
  private static By currentTitle = By.xpath("//h1[@class='schema-header__title js-schema-header_title']");

  public TvPage(String title) {
    super(title, currentTitle);
  }

  public TvPage selectMaker(String tvMaker) {
    By checkboxMaker = By.xpath(String.format(cbxMaker, tvMaker.toLowerCase(Locale.ROOT)));
    WebElement tvMakerCheckbox = driver.findElement(checkboxMaker);
    js.executeScript("arguments[0].click()", tvMakerCheckbox);
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    return this;
  }

  public TvPage writePrice(String tvPrice) {
    driver.findElement(fieldPrice).sendKeys(tvPrice);
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    return this;
  }

  public TvPage selectResolution(String resolution) {
    By checkboxResolution = By.xpath(String.format(cbxResolution, resolution));
    WebElement resolutionCheckbox = driver.findElement(checkboxResolution);
    js.executeScript("arguments[0].click()", resolutionCheckbox);
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    return this;
  }

  public TvPage selectDiagonal(String minDiagonal, String maxDiagonal) {
    driver
        .findElement(fieldMinDiagonal)
        .sendKeys(minDiagonal);
    driver
        .findElement(fieldMaxDiagonal)
        .sendKeys(maxDiagonal);
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    return this;
  }

  public TvPage vailidateMaker(String tvMaker) {
    BaseElement.waitUntilVisibilityOfAllElementsLocated(searchResults);
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    List<WebElement> currentTvMakers = driver.findElements(makerResults);
    for (WebElement currentTvMaker : currentTvMakers) {
      softAssert.assertTrue(
          currentTvMaker.getText().contains(tvMaker),
          "TvMaker is incorrect in case " + currentTvMakers.indexOf(currentTvMaker) + 1);
    }
    return this;
  }

  public TvPage vailidatePrice(String price) {
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    List<WebElement> productPrices = driver.findElements(priceResults);
    for (WebElement productPrice : productPrices) {
      int currentPrice =
          Integer.parseInt(
              productPrice.getText().substring(0, productPrice.getText().indexOf(',')));
      int maxPrice = Integer.parseInt(price);
      softAssert.assertTrue(maxPrice >= currentPrice, "price is more than " + maxPrice);
    }
    return this;
  }

  public TvPage vailidateDiagonal(String minDiagonal, String maxDiagonal) {
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    List<WebElement> productDescriptions = driver.findElements(descriptionResults);
    for (WebElement productDescription : productDescriptions) {
      int diagonal = Integer.parseInt(productDescription.getText().substring(0, productDescription.getText().indexOf('"')));
      int minDiagonalInt = Integer.parseInt(minDiagonal);
      int maxDiagonalInt = Integer.parseInt(maxDiagonal);
      softAssert.assertTrue(
          diagonal >= minDiagonalInt || diagonal <= maxDiagonalInt, "tv diagonal is incorrect");
    }
    return this;
  }

  public TvPage vailidateResolution(String resolution) {
    BaseElement.waitUntilIsInvisibilityOfElement(animation);
    List<WebElement> productDescriptions = driver.findElements(descriptionResults);
    for (WebElement productDescription : productDescriptions) {
      softAssert.assertTrue(
          productDescription.getText().contains(resolution),
          "tv resolution is incorrect");
    }
    return this;
  }
}
