package pageobject_model.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    private static By searchCatalogBtn = By.xpath("//h2/a[contains(text(),'Каталог')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openCatalogPage() {
        waitUntilIsDisplayed(searchCatalogBtn);
        findAndClick(searchCatalogBtn);
        return this;
    }
}


