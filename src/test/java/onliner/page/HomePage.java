package onliner.page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import static onliner.utils.PropertyReader.getTestData;

public class HomePage extends AbstractPage {

  private By catalogButtonXpath = By.xpath(String.format("//h2/a[contains(text(), '%s')]", getTestData("testdata.catalogtitle")));
  private static By validationLabelXpath = By.xpath("//div[@class='adfox-banner-background']");

  public HomePage() {
    super(validationLabelXpath);
  }

  public HomePage openCatalogPage() {
    WebElement catalogButton = driver.findElement(catalogButtonXpath);
    new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(condition -> catalogButton.isDisplayed());
    catalogButton.click();
    return this;
  }
}
