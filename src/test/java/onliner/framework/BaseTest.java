package onliner.framework;

import static onliner.framework.Browser.getWebDriver;
import static onliner.framework.PropertyReader.getTestData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

public class BaseTest {
  public static Browser browser;
  public static SoftAssert softAssert;

  @BeforeMethod(alwaysRun = true)
  public void setup() {
    browser = new Browser(getWebDriver(getTestData("tvFilterTestData", "testdata.browserName")));
    softAssert = new SoftAssert();
    browser.maximizeWindow();
    browser.navigatePage(getTestData("tvFilterTestData", "testdata.url"));
  }

  @AfterMethod(alwaysRun = true)
  public void stopBrowser() {
    browser.quitBrowser();
  }
}
