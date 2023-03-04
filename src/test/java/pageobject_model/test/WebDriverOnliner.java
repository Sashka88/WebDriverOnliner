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

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {
    }
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





