package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;



public class CatalogPage extends AbstractPage{

    private static By searchElectroBtn = By.xpath("//span[contains(text(),'Электроника')]");
    private static By searchTvBtn = By.xpath("//div[@class='catalog-navigation-list__aside-title'][contains(text(), 'Телевидение')]");
    private static By searchTvMenuBtn = By.xpath("//span[@class='catalog-navigation-list__dropdown-title'][contains(text(), 'Телевизоры')]");
    private static By currentTitle = By.xpath("//div[@class = 'catalog-navigation__title']" );

    public CatalogPage(WebDriver driver){
        super(driver);
    }


    public CatalogPage openElectronicMenu() {
        waitUntilIsDisplayed(searchElectroBtn);
        findAndClick(searchElectroBtn);
        return this;
    }

    public CatalogPage openTvMenu() {
        waitUntilIsDisplayed(searchTvBtn);
        findAndClick(searchTvBtn);
        return this;
    }

    public CatalogPage openTvPage() {
        findTvElements(searchTvMenuBtn);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> findTvElements(searchTvMenuBtn).get(1).isDisplayed());
        findTvElements(searchTvMenuBtn).get(1).click();
        return this;
//
    }


//    public CatalogPage assertPage(By currentTitle) {
//        String expectedTitle = "Каталог";
//        Assert.assertTrue((findTvElements(currentTitle).contains(expectedTitle)), "page is incorrect");
//    }

}
