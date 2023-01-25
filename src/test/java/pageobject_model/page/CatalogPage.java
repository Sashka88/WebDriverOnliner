package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


public class CatalogPage extends AbstractPage{

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement searchElectroBtn;

    @FindBy(xpath = "//div[@class='catalog-navigation-list__aside-title'][contains(text(), 'Телевидение')]")
    private WebElement searchTvBtn;

    @FindBy(xpath = "//span[@class='catalog-navigation-list__dropdown-title'][contains(text(), 'Телевизоры')]")
    private List<WebElement> searchTvMenuBtn;


    public CatalogPage(WebDriver driver){
        super(driver);
    }


    public CatalogPage openElectronicMenu() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchElectroBtn.isDisplayed());
        searchElectroBtn.click();
        return this;
    }
    public CatalogPage openTvMenu() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchTvBtn.isDisplayed());
        searchTvBtn.click();
        return this;
    }

    public CatalogPage openTvPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchTvMenuBtn.get(1).isDisplayed());
        searchTvMenuBtn.get(1).click();
        return this;
    }

}
