package onliner.page;

import java.util.List;
import java.util.Locale;
import onliner.framework.BaseElement;
import onliner.framework.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static onliner.framework.BaseTest.softAssert;
import static onliner.framework.Browser.driver;

public class TvPage extends BasePage {

  private String tvMakerXpath = "//ul//input[@type='checkbox' and @value='%s']";
  private By priceFieldXpath = By.xpath("//input[@placeholder='до']");
  private String tvResolutionxpath = "//input[@type='checkbox' and @value='%s']";
  private By minDiagonalFieldXpath = By.xpath("//select[contains(@data-bind, 'value: facet.value.from')]");
  private By maxDiagonalFieldXpath = By.xpath("//select[contains(@data-bind, 'value: facet.value.to')]");
  private By searchResults = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]");
  private By animationXpath = By.xpath("//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled schema-filter-button__state_control schema-filter-button__state_animated']");
  private By tvMakersXpath = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]");
  private By tvPriceXpath = By.xpath("//a[contains(@data-bind, 'attr: {href: $data.prices.html_url_with_region}')]/span");
  private By tvDescriptionXpath = By.xpath("//span[contains(@data-bind, 'html: product.description')]");
  private static By currentTitleXpath = By.xpath("//h1[@class='schema-header__title js-schema-header_title']");

  public TvPage(String title) {
    super(title, currentTitleXpath);
  }

  public TvPage selectTvMaker(String tvMaker) {
    By tvXpath = By.xpath(String.format(tvMakerXpath, tvMaker.toLowerCase(Locale.ROOT)));
    WebElement tvMakerCheckbox = driver.findElement(tvXpath);
    js.executeScript("arguments[0].click()", tvMakerCheckbox);
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    return this;
  }

  public TvPage writeTvPrice(String tvPrice) {
    driver.findElement(priceFieldXpath).sendKeys(tvPrice);
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    return this;
  }

  public TvPage selectTvResolution(String resolution) {
    By tvResolution = By.xpath(String.format(tvResolutionxpath, resolution));
    WebElement resolutionCheckbox = driver.findElement(tvResolution);
    js.executeScript("arguments[0].click()", resolutionCheckbox);
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    return this;
  }

  public TvPage selectTvDiagonal(String minDiagonal, String maxDiagonal) {
    driver
        .findElement(minDiagonalFieldXpath)
        .sendKeys(minDiagonal);
    driver
        .findElement(maxDiagonalFieldXpath)
        .sendKeys(maxDiagonal);
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    return this;
  }

  public TvPage vailidateTvMaker(String tvMaker) {
    BaseElement.waitUntilVisibilityOfAllElementsLocated(searchResults);
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    List<WebElement> currentTvMakers = driver.findElements(tvMakersXpath);
    for (WebElement currentTvMaker : currentTvMakers) {
      softAssert.assertTrue(
          currentTvMaker.getText().contains(tvMaker),
          "TvMaker is incorrect in case " + currentTvMakers.indexOf(currentTvMaker) + 1);
    }
    return this;
  }

  public TvPage vailidatePrice(String price) {
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    List<WebElement> productPrices = driver.findElements(tvPriceXpath);
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
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    List<WebElement> productDescriptions = driver.findElements(tvDescriptionXpath);
    for (WebElement productDescription : productDescriptions) {
      int diagonal =
          Integer.parseInt(
              productDescription.getText().substring(0, productDescription.getText().indexOf('"')));
      int minDiagonalInt = Integer.parseInt(minDiagonal);
      int maxDiagonalInt = Integer.parseInt(maxDiagonal);
      softAssert.assertTrue(
          diagonal >= minDiagonalInt || diagonal <= maxDiagonalInt, "tv diagonal is incorrect");
    }
    return this;
  }

  public TvPage vailidateResolution(String resolution) {
    BaseElement.waitUntilIsInvisibilityOfElement(animationXpath);
    List<WebElement> productDescriptions = driver.findElements(tvDescriptionXpath);
    for (WebElement productDescription : productDescriptions) {
      softAssert.assertTrue(
          productDescription.getText().contains(resolution),
          "tv resolution is incorrect");
    }
    return this;
  }
}
