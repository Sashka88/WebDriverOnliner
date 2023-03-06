package onliner.page;

import onliner.services.OnlinerTvData;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import static onliner.test.WebDriverOnliner.onlinerTvData;

public class CatalogPage extends AbstractPage {

  private static By searchElectroBtn = By.xpath("//span[contains(text(),'Электроника')]");
  private static By searchTvBtn =
      By.xpath(
          "//div[@class='catalog-navigation-list__aside-title'][contains(text(), 'Телевидение')]");
  private static By searchTvMenuBtn =
      By.xpath(
          "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'Телевизоры')]");
  private static By currentTitle = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage() {
    super(onlinerTvData.getTestData("testdata.catalogtitle"), currentTitle);
  }

  public CatalogPage openElectronicMenu() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> driver.findElement(searchElectroBtn).isDisplayed());
    driver.findElement(searchElectroBtn).click();
    return this;
  }

  public CatalogPage openTvMenu() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> driver.findElement(searchTvBtn).isDisplayed());
    driver.findElement(searchTvBtn).click();
    return this;
  }

  public CatalogPage openTvPage() {
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> driver.findElement(searchTvMenuBtn).isDisplayed());
    driver.findElement(searchTvMenuBtn).click();
    return this;
  }
}
