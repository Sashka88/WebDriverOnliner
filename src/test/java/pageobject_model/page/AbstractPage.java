package pageobject_model.page;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.title;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected JavascriptExecutor js;
    @FindBy(xpath = "//title")
    private WebElement pageTitle;

    protected final Duration WAIT_TIMEOUT_SECONDS = Duration.ofSeconds(15);

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        this.js = (JavascriptExecutor) driver;
//        private static By title = By.xpath("//div[@class = 'catalog-navigation__title']");
        //h1[@class='schema-header__title js-schema-header_title']
    }

    protected void waitUntilIsDisplayed(By xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> findTvElement(xpath).isDisplayed());
    }

    protected void waitUntilAllVisible(By xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
    }

    protected void waitUntilInvisibile(By xpath) {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.invisibilityOfElementLocated(xpath));
    }

    protected WebElement findTvElement(By xpath) {
        System.out.println("findElement"+ xpath);
        return driver.findElement(xpath);
    }

    protected List<WebElement> findTvElements(By xpath) {
        System.out.println("findElements" + xpath);
        return driver.findElements(xpath);
    }

    private void jsClick(WebElement element) {
        System.out.println("clickElement");
        js.executeScript("arguments[0].click();", element);
    }

    protected void findAndClick(By xpath){findTvElement(xpath).click();}

    protected void findAndJsClick(By xpath){
        jsClick(findTvElement(xpath));
    }

    protected void sendValue(By xpath, String value) {
        findTvElement(xpath).sendKeys(value);
    }

//    protected void assertPage(By currentTitle, String expectedTitle) {
//        Assert.assertTrue((findTvElements(currentTitle).contains(expectedTitle)), "page is incorrect");
//    }
//    protected void assertPage(String title) {
//        String expectedTitle = "Каталог";
//        Assert.assertTrue(findTvElements(title).contains(expectedTitle), "page is incorrect");


}
