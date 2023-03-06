package onliner.page;

import static onliner.test.WebDriverOnliner.onlinerTvData;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

  private static By searchCatalogBtn =
      By.xpath(
          "//h2/a[contains(text(),'" + onlinerTvData.getTestData("testdata.catalogtitle") + "')]");
  private static By validationLabel = By.xpath("//div[@class='adfox-banner-background']");

  public HomePage() {
    super(validationLabel);
  }

  public HomePage openCatalogPage() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> driver.findElement(searchCatalogBtn).isDisplayed());
    driver.findElement(searchCatalogBtn).click();
    return this;
  }
}
