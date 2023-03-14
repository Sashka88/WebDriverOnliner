package onliner.page;

import onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static onliner.framework.BaseElement.waitUntilIsDisplayed;
import static onliner.framework.Browser.driver;

public class CatalogPage extends BasePage {

  private String btnElectronicMenu = "//span[contains(text(), '%s')]";
  private String btnTv = "//div[@class='catalog-navigation-list__aside-title'][contains(text(), '%s')]";
  private String btnTvPage = "//div[@class='catalog-navigation-list__aside-item catalog-navigation-list__aside-item_active']" +
          "//span[contains(text(),'%s')]";
  private static By currentTitleXpath = By.xpath("//div[@class = 'catalog-navigation__title']");

  public CatalogPage(String title) {
    super(title, currentTitleXpath);
  }

  public CatalogPage navigateMenu(String menuName) {
    By btnMenu = By.xpath(String.format(btnElectronicMenu, menuName));
    WebElement buttonMenu = driver.findElement(btnMenu);
    waitUntilIsDisplayed(buttonMenu);
    buttonMenu.click();
    return this;
  }

  public CatalogPage navigateSubMenu(String subMenuName) {
    By btnSubMenu = By.xpath(String.format(btnTv, subMenuName));
    WebElement buttonSubMenu = driver.findElement(btnSubMenu);
    waitUntilIsDisplayed(buttonSubMenu);
    buttonSubMenu.click();
    return this;
  }

  public CatalogPage navigatePage(String pageName) {
    By btnPage = By.xpath(String.format(btnTvPage, pageName));
    WebElement buttonPage = driver.findElement(btnPage);
    waitUntilIsDisplayed(buttonPage);
    buttonPage.click();
    return this;
  }
}
