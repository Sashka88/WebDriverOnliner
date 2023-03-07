package onliner.page;

import static onliner.utils.PropertyReader.getTestData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CatalogPage extends AbstractPage {

  private By electronicMenuXpath = By.xpath("//span[contains(text(),'Электроника')]");
  private By tvXpath = By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(), 'Телевидение')]");
  private By tvMenuXpath = By.xpath("//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
          "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(),'Телевизоры')]");
  private static By currentTitleXpath = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage() {
    super(getTestData("testdata.catalogtitle"), currentTitleXpath);
  }

  public CatalogPage openElectronicMenu() {
    WebElement buttonElectronic = driver.findElement(electronicMenuXpath);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
        .until(condition -> buttonElectronic.isDisplayed());
    buttonElectronic.click();
    return this;
  }

  public CatalogPage openTvMenu() {
    WebElement buttonTv = driver.findElement(tvXpath);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> buttonTv.isDisplayed());
    buttonTv.click();
    return this;
  }

  public CatalogPage openTvPage() {
    WebElement buttonTvMenu = driver.findElement(tvMenuXpath);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> buttonTvMenu.isDisplayed());
    buttonTvMenu.click();
    return this;
  }
}
