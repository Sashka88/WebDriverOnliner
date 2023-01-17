package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;

    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(10);

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //Assert.assertEquals(pageTitle,"Onliner");
    }

}
