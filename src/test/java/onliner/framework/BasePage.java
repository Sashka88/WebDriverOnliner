package onliner.framework;

import static onliner.framework.Browser.driver;

import org.openqa.selenium.*;
import org.testng.Assert;

public abstract class BasePage {
  protected JavascriptExecutor js;

  public BasePage(String expectedTitle, By xpathTitle) {
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(driver.findElement(xpathTitle).getText().contains(expectedTitle),
        "Incorrect page is opened, expected page is - " + expectedTitle);
  }

  public BasePage(By xpathElement) {
    this.js = (JavascriptExecutor) driver;
    Assert.assertTrue(driver.findElement(xpathElement).isDisplayed(), "Incorrect page is opened");
  }
}