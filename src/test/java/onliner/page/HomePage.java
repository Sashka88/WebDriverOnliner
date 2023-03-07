package onliner.page;

import static onliner.test.WebDriverOnliner.onlinerTvData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

  private By xpathCatalog =
      By.xpath(
          String.format(
              "//h2/a[contains(text(), '%s')]",
              onlinerTvData.getTestData("testdata.catalogtitle")));
  private static By validationLabel = By.xpath("//div[@class='adfox-banner-background']");

  public HomePage() {
    super(validationLabel);
  }

  public HomePage openCatalogPage() {
    WebElement buttonCatalog = driver.findElement(xpathCatalog);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> buttonCatalog.isDisplayed());
    buttonCatalog.click();
    return this;
  }
}
