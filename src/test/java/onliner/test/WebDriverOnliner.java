package onliner.test;

import onliner.framework.BaseTest;
import onliner.page.CatalogPage;
import onliner.page.MainPage;
import onliner.page.TvPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class WebDriverOnliner extends BaseTest {

  @Parameters({"tvMaker", "price", "minDiagonal", "maxDiagonal", "resolution"})
  @Test
  public void onlinerTvTest(String tvMaker, String price, String minDiagonal, String maxDiagonal, String resolution) {
    new MainPage().navigateSection("Каталог");
    new CatalogPage("Каталог")
        .navigateMenu("Электроника")
        .navigateSubMenu("Телевидение")
        .navigatePage("Телевизоры");
    new TvPage("Телевизоры")
        .selectMaker(tvMaker)
        .writePrice(price)
        .selectResolution(resolution)
        .selectDiagonal(minDiagonal, maxDiagonal)
        .vailidateMaker(tvMaker)
        .vailidatePrice(price)
        .vailidateDiagonal(minDiagonal, maxDiagonal)
        .vailidateResolution(resolution);
    softAssert.assertAll();
  }
}
