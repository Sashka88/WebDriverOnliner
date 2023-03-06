package onliner.page;

import static onliner.test.WebDriverOnliner.browser;

import java.time.Duration;
import org.openqa.selenium.*;
import org.testng.Assert;

public abstract class AbstractPage {
  protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
  protected WebDriver driver;
  protected JavascriptExecutor js;

  public AbstractPage(String expectedTitle, By xpath) {
    this.driver = browser.driver;
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(
        driver.findElement(xpath).getText().contains(expectedTitle), "page is incorrect");
  }

  public AbstractPage(By xpath) {
    this.driver = browser.driver;
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(driver.findElement(xpath).isDisplayed(), "page is incorrect");
  }
}
