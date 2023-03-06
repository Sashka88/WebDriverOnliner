package onliner.page;

import java.util.List;
import java.util.Locale;
import onliner.services.OnlinerTvData;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;import static onliner.test.WebDriverOnliner.onlinerTvData;

public class TvPage extends AbstractPage {

  private static By chbxTvMaker =
      By.xpath(
          "//ul//input[@type='checkbox' and @value='"
              + onlinerTvData.getTestData("testdata.tvMaker").toLowerCase(Locale.ROOT)
              + "']");
  private static By fieldPrice = By.xpath("//input[@placeholder='до']");
  private static By chbxResolution =
      By.xpath(
          "//input[@type='checkbox' and @value='"
              + onlinerTvData.getTestData("testdata.resolution")
              + "']");
  private static By fieldDiagonalFrom =
      By.xpath("//select[contains(@data-bind, 'value: facet.value.from')]");
  private static By fieldDiagonalTo =
      By.xpath("//select[contains(@data-bind, 'value: facet.value.to')]");
  private static By searchResults =
      By.xpath(
          "//span[contains(@data-bind, 'html: product.extended_name || product.full_name')][contains(text(), 'Телевизор')]");
  private static By btnAnimation =
      By.xpath(
          "//div[@class='schema-filter-button__state schema-filter-button__state_initial schema-filter-button__state_disabled schema-filter-button__state_control schema-filter-button__state_animated']");
  private static By findTvMakers =
      By.xpath("//span[contains(@data-bind, 'html: product.extended_name || product.full_name')]");
  private static By findTvPrice =
      By.xpath("//a[contains(@data-bind, 'attr: {href: $data.prices.html_url_with_region}')]/span");
  private static By findTvDescription =
      By.xpath("//span[contains(@data-bind, 'html: product.description')]");
  private static By currentTitle =
      By.xpath("//h1[@class='schema-header__title js-schema-header_title']");

  public TvPage() {
    super(onlinerTvData.getTestData("testdata.tvtitle"), currentTitle);
  }

  public TvPage selectTvMaker() {
    driver.findElement(chbxTvMaker);
    js.executeScript("arguments[0].click()", driver.findElement(chbxTvMaker));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    return this;
  }

  public TvPage writePrice() {
    driver.findElement(fieldPrice).sendKeys(onlinerTvData.getTestData("testdata.price"));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    return this;
  }

  public TvPage selectResolution() {
    driver.findElement(chbxResolution);
    js.executeScript("arguments[0].click()", driver.findElement(chbxResolution));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    return this;
  }

  public TvPage selectDiagonal() {
    driver
        .findElement(fieldDiagonalFrom)
        .sendKeys(onlinerTvData.getTestData("testdata.diagonalfrom"));
    driver.findElement(fieldDiagonalTo).sendKeys(onlinerTvData.getTestData("testdata.diagonalto"));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    return this;
  }

  public TvPage vailidateTvMaker() {
    SoftAssert softAssert = new SoftAssert();
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(StaleElementReferenceException.class)
        .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(searchResults));
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    List<WebElement> currentTvMakers = driver.findElements(findTvMakers);
    for (WebElement currentTvMaker : currentTvMakers) {
      softAssert.assertTrue(
          currentTvMaker.getText().contains(onlinerTvData.getTestData("testdata.tvMaker")),
          "TvMaker is incorrect in case " + currentTvMakers.indexOf(currentTvMaker) + 1);
    }
    return this;
  }

  public TvPage vailidatePrice() {
    SoftAssert softAssert = new SoftAssert();
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    List<WebElement> productPrices = driver.findElements(findTvPrice);
    for (WebElement productPrice : productPrices) {
      int currentPrice =
          Integer.parseInt(
              productPrice.getText().substring(0, productPrice.getText().indexOf(',')));
      int maxPrice = Integer.parseInt(onlinerTvData.getTestData("testdata.price"));
      softAssert.assertTrue(maxPrice >= currentPrice, "price is more than " + maxPrice);
    }
    return this;
  }

  public TvPage vailidateDiagonal() {
    SoftAssert softAssert = new SoftAssert();
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    List<WebElement> productDescriptions = driver.findElements(findTvDescription);
    for (WebElement productDescription : productDescriptions) {
      int diagonal =
          Integer.parseInt(
              productDescription.getText().substring(0, productDescription.getText().indexOf('"')));
      int minDiagonal = Integer.parseInt(onlinerTvData.getTestData("testdata.diagonalfrom"));
      int maxDiagonal = Integer.parseInt(onlinerTvData.getTestData("testdata.diagonalto"));
      softAssert.assertTrue(
          diagonal >= minDiagonal || diagonal <= maxDiagonal, "tv diagonal is incorrect");
    }
    return this;
  }

  public TvPage vailidateResolution() {
    SoftAssert softAssert = new SoftAssert();
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .ignoring(NoSuchElementException.class)
        .until(ExpectedConditions.invisibilityOfElementLocated(btnAnimation));
    List<WebElement> productDescriptions = driver.findElements(findTvDescription);
    for (WebElement productDescription : productDescriptions) {
      softAssert.assertTrue(
          productDescription.getText().contains(onlinerTvData.getTestData("testdata.resolution")),
          "tv resolution is incorrect");
    }
    return this;
  }
}
