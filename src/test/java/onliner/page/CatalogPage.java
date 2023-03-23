package onliner.page;

import onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static onliner.framework.BaseElement.waitUntilIsDisplayed;
import static onliner.framework.Browser.driver;

public class CatalogPage extends BasePage {

  private String btnMenu = "//span[contains(text(), '%s')]";
  private String btnSubMenu = "//div[@class='catalog-navigation-list__aside-title'][contains(text(), '%s')]";
  private String btnPage = "//div[contains(@class, 'catalog-navigation-list__aside-item_active')]//span[contains(text(),'%s')]";
  private static By pageLocator = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage(String title) {
    super(title, pageLocator);
  }

  public CatalogPage navigateMenu(String menuName) {
    WebElement buttonMenu = driver.findElement(By.xpath(String.format(btnMenu, menuName)));
    waitUntilIsDisplayed(buttonMenu);
    buttonMenu.click();
    return this;
  }

  public CatalogPage navigateSubMenu(String subMenuName) {
    WebElement buttonSubMenu = driver.findElement(By.xpath(String.format(btnSubMenu, subMenuName)));
    waitUntilIsDisplayed(buttonSubMenu);
    buttonSubMenu.click();
    return this;
  }

  public CatalogPage navigatePage(String pageName) {
    WebElement buttonPage = driver.findElement(By.xpath(String.format(btnPage, pageName)));
    waitUntilIsDisplayed(buttonPage);
    buttonPage.click();
    return this;
  }
}