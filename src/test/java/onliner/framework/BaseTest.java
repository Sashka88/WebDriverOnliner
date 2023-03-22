package onliner.framework;

import static onliner.framework.DriverFactory.getWebDriver;
import static onliner.framework.PropertyReader.getProperty;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
  public static Browser browser;
  public static SoftAssert softAssert;

  @BeforeMethod(alwaysRun = true)
  public void setup() {
    browser = new Browser(getProperty("config", "testdata.browserName"));
    softAssert = new SoftAssert();
    browser.maximizeWindow();
    browser.navigatePage(getProperty("config", "testdata.url"));
  }

  @AfterMethod(alwaysRun = true)
  public void teardown() {
    browser.quitBrowser();
  }
}