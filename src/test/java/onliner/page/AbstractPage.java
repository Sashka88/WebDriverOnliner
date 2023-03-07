package onliner.page;

import static onliner.test.WebDriverOnliner.browser;

import java.time.Duration;
import org.openqa.selenium.*;
import org.testng.Assert;

public abstract class AbstractPage {
  protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);
  protected WebDriver driver;
  protected JavascriptExecutor js;

  public AbstractPage(String expectedTitle, By xpathTitle) {
    this.driver = browser.driver;
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(
        driver.findElement(xpathTitle).getText().contains(expectedTitle),
        "Incorrect page is opened, expected page is - " + expectedTitle);
  }

  public AbstractPage(By xpathElement) {
    this.driver = browser.driver;
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(driver.findElement(xpathElement).isDisplayed(), "Incorrect page is opened");
  }
}
