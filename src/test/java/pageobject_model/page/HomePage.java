package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageobject_model.test.HelloWebDriver;

import java.time.Duration;

public class HomePage extends AbstractPage{

    @FindBy(xpath = "//h2/a[contains(text(),'Каталог')]")
    private WebElement searchCatalogBtn;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage openCatalogPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchCatalogBtn.isDisplayed());
        searchCatalogBtn.click();
        return this;
    }
}


