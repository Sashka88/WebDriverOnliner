package pageobject_model.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobject_model.page.CatalogPage;
import pageobject_model.page.HomePage;
import pageobject_model.page.TvPage;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {
    WebDriver driver = new ChromeDriver();

    @BeforeMethod(alwaysRun = true)
    public void browserSetup() {

        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
    }

    @Test
    public void HomePageTest() {

        HomePage homePage = new HomePage(driver);
        homePage.openCatalogPage();

        CatalogPage catalogPage = new CatalogPage(driver);
        catalogPage.openElectronicMenu();
        catalogPage.openTvMenu();
        catalogPage.openTvPage();

        TvPage TvPage = new TvPage(driver);
        TvPage.selectTvMaker();

    }


//    //  Assert.assertEquals(expectedSearchResultsNumber >0, "Search results are empty!")
//    @AfterMethod (alwaysRun = true)
//    public void stopBrowser() {
//        driver.quit();
//        driver = null;
//    }
}





