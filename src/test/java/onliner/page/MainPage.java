package onliner.page;

import onliner.framework.BaseElement;
import onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static onliner.framework.Browser.driver;

public class MainPage extends BasePage {

  private String btnNavigation = "//span[@class='b-main-navigation__text'][contains(text(), '%s')]";
  private static By pageLocator = By.xpath("//nav[@class='b-top-navigation']");

  public MainPage() {
    super(pageLocator);
  }

  public MainPage navigateSection(String sectionName) {
    WebElement buttonSection = driver.findElement(By.xpath(String.format(btnNavigation, sectionName)));
    BaseElement.waitUntilIsDisplayed(buttonSection);
    buttonSection.click();
    return this;
  }
}