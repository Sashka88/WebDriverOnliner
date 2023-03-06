package onliner.test;

import onliner.browser.Browser;
import onliner.page.CatalogPage;
import onliner.page.HomePage;
import onliner.page.TvPage;
import onliner.services.OnlinerTvData;import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebDriverOnliner {
  public static Browser browser;
  public static SoftAssert softAssert;
  public static OnlinerTvData onlinerTvData;

  @BeforeMethod(alwaysRun = true)
  public void setup() {
    browser = new Browser();
    softAssert = new SoftAssert();
    onlinerTvData = new OnlinerTvData();
  }

  @Test
  public void onlinerTvTest() throws InterruptedException {
    browser.getBasePage();
    new HomePage().openCatalogPage();
    new CatalogPage().openElectronicMenu().openTvMenu().openTvPage();
    new TvPage()
        .selectTvMaker()
        .writePrice()
        .selectResolution()
        .selectDiagonal()
        .vailidateTvMaker()
        .vailidatePrice()
        .vailidateDiagonal()
        .vailidateResolution();
    softAssert.assertAll();
  }

  @AfterMethod(alwaysRun = true)
  public void stopBrowser() {
    browser.driver.quit();
  }
}
