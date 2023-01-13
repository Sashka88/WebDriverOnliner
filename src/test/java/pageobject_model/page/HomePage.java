package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class HomePage extends AbstractPage {

    private static final String HOMEPAGE_URL = "https://www.onliner.by/";

    @FindBy(xpath = "//h2/a[contains(text(),'Каталог')]")
    private WebElement searchCatalogBtn;

    @FindBy(xpath = "//span[contains(text(),'Электроника')]")
    private WebElement searchElectroBtn;

    @Override
    public HomePage openPage() {
        driver.get(HOMEPAGE_URL);
        return this;
        //Assert.assertEquals();
    }

    public HomePage(WebDriver driver) {
        super(driver);
    }
    public HomePage openCatalogPage() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchCatalogBtn.isDisplayed());
        searchCatalogBtn.click();
        return this;
        Assert.assertEquals(Title, );
    }
}


