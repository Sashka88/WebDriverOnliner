package onliner.page;

import static onliner.test.WebDriverOnliner.onlinerTvData;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage {

  private By xpathElectronicMenu = By.xpath("//span[contains(text(),'Электроника')]");
  private By xpathTv =
      By.xpath(
          "//div[@class='catalog-navigation-list__aside-title'][contains(text(), 'Телевидение')]");
  private By xpathTvMenu =
      By.xpath(
          "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'Телевизоры')]");
  private static By currentTitle = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage() {
    super(onlinerTvData.getTestData("testdata.catalogtitle"), currentTitle);
  }

  public CatalogPage openElectronicMenu() {
    WebElement buttonElectronic = driver.findElement(xpathElectronicMenu);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> buttonElectronic.isDisplayed());
    buttonElectronic.click();
    return this;
  }

  public CatalogPage openTvMenu() {
    WebElement buttonTv = driver.findElement(xpathTv);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> buttonTv.isDisplayed());
    buttonTv.click();
    return this;
  }

  public CatalogPage openTvPage() {
    WebElement buttonTvMenu = driver.findElement(xpathTvMenu);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> buttonTvMenu.isDisplayed());
    buttonTvMenu.click();
    return this;
  }
}
