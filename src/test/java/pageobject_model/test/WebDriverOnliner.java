package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.Browser;
import pageobject_model.page.CatalogPage;
import pageobject_model.page.HomePage;
import pageobject_model.page.TvPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class WebDriverOnliner {
    WebDriver driver = new ChromeDriver();
//    private static By currentTitle = By.xpath("//div[@class = 'catalog-navigation__title']" );
//    public static String tv;
//    public static String price;
//    public static String diagonalfrom;
//    public static String diagonalto;
//    public static String resolution;
//    public static String titleCatalogPage;
//    public static String titleTvPage;
    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
        Browser.openOnliner();
    }
//        FileInputStream fis;
//        try {
//            Properties property = new Properties();
//            fis = new FileInputStream("src/test/resources/tvFilterTestData.properties");
//            property.load(fis);
//
//            tv = property.getProperty("testdata.tvMaker");
//            price = property.getProperty("testdata.price");
//            diagonalfrom = property.getProperty("testdata.diagonalfrom");
//            diagonalto = property.getProperty("testdata.diagonalto");
//            resolution = property.getProperty("testdata.resolution");
//            titleCatalogPage = property.getProperty("testdata.catalogtitle");
//            titleTvPage = property.getProperty("testdata.tvtitle");
//            System.out.println(tv);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

//        driver.manage().window().maximize();
//        driver.get("https://www.onliner.by/");
//        String expectedTitle = "Каталог";
//        Assert.assertTrue((findTvElements(currentTitle).contains(expectedTitle), "page is incorrect"));

    @Test
    public void HomePageTest() throws InterruptedException {

        Browser browser = new Browser(driver);
        browser.openOnliner();

        HomePage homePage = new HomePage(driver);
        homePage.openCatalogPage();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openElectronicMenu();
        catalogPage.openTvMenu();
        catalogPage.openTvPage();

        TvPage TvPage = new TvPage(driver);
        TvPage.selectTvMaker();
        TvPage.writePrice();
        TvPage.selectResolution();
        TvPage.selectDiagonal();
        TvPage.vailidateTvMaker();
        TvPage.vailidatePrice();
        TvPage.vailidateDiagonal();
        TvPage.vailidateResolution();
//        softAssert.assertAll();
    }



//    @AfterMethod (alwaysRun = true)
//    public void stopBrowser() {
//        driver.quit();
//        driver = null;
//    }
}





