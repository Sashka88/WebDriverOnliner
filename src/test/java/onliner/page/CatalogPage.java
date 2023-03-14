package onliner.page;

import onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static onliner.framework.BaseElement.waitUntilIsDisplayed;
import static onliner.framework.Browser.driver;

public class CatalogPage extends BasePage {

  private String btnMenu = "//span[contains(text(), '%s')]";
  private String btnSubMenu = "//div[@class='catalog-navigation-list__aside-title'][contains(text(), '%s')]";
  private String btnPage = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']//span[contains(text(),'%s')]";
  private static By currentTitle = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage(String title) {
    super(title, currentTitle);
  }

  public CatalogPage navigateMenu(String menuName) {
    By buttonNavMenu = By.xpath(String.format(btnMenu, menuName));
    WebElement buttonMenu = driver.findElement(buttonNavMenu);
    waitUntilIsDisplayed(buttonMenu);
    buttonMenu.click();
    return this;
  }

  public CatalogPage navigateSubMenu(String subMenuName) {
    By buttonNavSubMenu = By.xpath(String.format(btnSubMenu, subMenuName));
    WebElement buttonSubMenu = driver.findElement(buttonNavSubMenu);
    waitUntilIsDisplayed(buttonSubMenu);
    buttonSubMenu.click();
    return this;
  }

  public CatalogPage navigatePage(String pageName) {
    By btnNavPage = By.xpath(String.format(btnPage, pageName));
    WebElement buttonPage = driver.findElement(btnNavPage);
    waitUntilIsDisplayed(buttonPage);
    buttonPage.click();
    return this;
  }
}
