package onliner.page;

import onliner.framework.BaseElement;
import onliner.framework.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static onliner.framework.Browser.driver;

public class MainPage extends BasePage {

  private String btnNavigation = "//span[@class='b-main-navigation__text'][contains(text(), '%s')]";
  private static By validationLabelXpath = By.xpath("//nav[@class='b-top-navigation']");

  public MainPage() {
    super(validationLabelXpath);
  }

  public MainPage navigateSection(String sectionName) {
    By sectionXpath = By.xpath(String.format(btnNavigation, sectionName));
    WebElement buttonSection = driver.findElement(sectionXpath);
    BaseElement.waitUntilIsDisplayed(buttonSection);
    buttonSection.click();
    return this;
  }
}
