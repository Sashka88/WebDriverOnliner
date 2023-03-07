package onliner.test;

import onliner.browser.Browser;
import onliner.page.CatalogPage;
import onliner.page.HomePage;
import onliner.page.TvPage;
import onliner.utils.OnlinerTvData;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class WebDriverOnliner {
  public static Browser browser;
  public static SoftAssert softAssert;
  public static OnlinerTvData onlinerTvData;
  public static String url;

  @BeforeMethod(alwaysRun = true)
  public void setup() {
    url = "https://www.onliner.by/";
    browser = new Browser();
    softAssert = new SoftAssert();
    onlinerTvData = new OnlinerTvData();
    browser.maximizeWindow();
    browser.getBasePage();
  }

  @Test
  public void onlinerTvTest() {
    new HomePage().openCatalogPage();
    new CatalogPage().openElectronicMenu().openTvMenu().openTvPage();
    new TvPage()
        .selectTvMaker()
        .writeTvPrice()
        .selectTvResolution()
        .selectTvDiagonal()
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
