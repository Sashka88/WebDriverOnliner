package onliner.page;

import static onliner.test.WebDriverOnliner.softAssert;
import static onliner.utils.PropertyReader.getTestData;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TvPage extends AbstractPage {

  private By tvMakerXpath = By.xpath("//ul//input[@type='checkbox' and @value='"
              + getTestData("testdata.tvMaker").toLowerCase(Locale.ROOT) + "']");
  private By priceFieldXpath = By.xpath("//input[@placeholder='до']");
  private By tvResolutionxpath = By.xpath("//input[@type='checkbox' and @value='"
              + getTestData("testdata.resolution") + "']");
  private By minDiagonalFieldXpath = By.xpath("//select[contains(@data-bind, 'value: facet.value.from')]");
  private By maxDiagonalFieldXpath = By.xpath("//select[contains(@data-bind, 'value: facet.value.to')]");
  private By searchResults = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]");
  private By animationXpath = By.xpath("//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled schema-filter-button__state_control schema-filter-button__state_animated']");
  private By tvMakersXpath = By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]");
  private By tvPriceXpath = By.xpath("//a[contains(@data-bind, 'attr: {href: $data.prices.html_url_with_region}')]/span");
  private By tvDescriptionXpath = By.xpath("//span[contains(@data-bind, 'html: product.description')]");
  private static By currentTitleXpath = By.xpath("//h1[@class='schema-header__title js-schema-header_title']");

  public TvPage() {
    super(getTestData("testdata.tvtitle"), currentTitleXpath);
  }

  public TvPage selectTvMaker() {
    WebElement tvMakerCheckbox = driver.findElement(tvMakerXpath);
    js.executeScript("arguments[0].click()", tvMakerCheckbox);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    return this;
  }

  public TvPage writeTvPrice() {
    driver.findElement(priceFieldXpath).sendKeys(getTestData("testdata.price"));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    return this;
  }

  public TvPage selectTvResolution() {
    WebElement resolutionCheckbox = driver.findElement(tvResolutionxpath);
    js.executeScript("arguments[0].click()", resolutionCheckbox);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    return this;
  }

  public TvPage selectTvDiagonal() {
    driver
        .findElement(minDiagonalFieldXpath)
        .sendKeys(getTestData("testdata.mindiagonal"));
    driver
        .findElement(maxDiagonalFieldXpath)
        .sendKeys(getTestData("testdata.maxdiagonal"));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    return this;
  }

  public TvPage vailidateTvMaker() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    List<WebElement> currentTvMakers = driver.findElements(tvMakersXpath);
    for (WebElement currentTvMaker : currentTvMakers) {
      softAssert.assertTrue(
          currentTvMaker.getText().contains(getTestData("testdata.tvMaker")),
          "TvMaker is incorrect in case " + currentTvMakers.indexOf(currentTvMaker) + 1);
    }
    return this;
  }

  public TvPage vailidatePrice() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    List<WebElement> productPrices = driver.findElements(tvPriceXpath);
    for (WebElement productPrice : productPrices) {
      int currentPrice =
          Integer.parseInt(
              productPrice.getText().substring(0, productPrice.getText().indexOf(',')));
      int maxPrice = Integer.parseInt(getTestData("testdata.price"));
      softAssert.assertTrue(maxPrice >= currentPrice, "price is more than " + maxPrice);
    }
    return this;
  }

  public TvPage vailidateDiagonal() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    List<WebElement> productDescriptions = driver.findElements(tvDescriptionXpath);
    for (WebElement productDescription : productDescriptions) {
      int diagonal =
          Integer.parseInt(
              productDescription.getText().substring(0, productDescription.getText().indexOf('"')));
      int minDiagonal = Integer.parseInt(getTestData("testdata.mindiagonal"));
      int maxDiagonal = Integer.parseInt(getTestData("testdata.maxdiagonal"));
      softAssert.assertTrue(
          diagonal >= minDiagonal || diagonal <= maxDiagonal, "tv diagonal is incorrect");
    }
    return this;
  }

  public TvPage vailidateResolution() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(animationXpath));
    List<WebElement> productDescriptions = driver.findElements(tvDescriptionXpath);
    for (WebElement productDescription : productDescriptions) {
      softAssert.assertTrue(
          productDescription.getText().contains(getTestData("testdata.resolution")),
          "tv resolution is incorrect");
    }
    return this;
  }
}
