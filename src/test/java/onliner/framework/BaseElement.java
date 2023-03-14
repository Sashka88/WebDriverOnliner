package onliner.framework;

import org.openqa.selenium.*;import org.openqa.selenium.support.ui.ExpectedConditions;import org.openqa.selenium.support.ui.WebDriverWait;import java.time.Duration;import static onliner.framework.BaseTest.browser;import static onliner.framework.PropertyReader.getTestData;

public class BaseElement {
    protected static long WAIT_TIMEOUT_SECONDS = Long.parseLong(getTestData("tvFilterTestData", "testdata.duration"));

    public static void waitUntilIsDisplayed(WebElement button) {
    new WebDriverWait(browser.driver, WAIT_TIMEOUT_SECONDS).until(condition -> button.isDisplayed());
    }

    public static void waitUntilIsInvisibilityOfElement(By xpath) {
        new WebDriverWait(browser.driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.invisibilityOfElementLocated(xpath));
        }

    public static void waitUntilVisibilityOfAllElementsLocated(By xpath) {
        new WebDriverWait(browser.driver, WAIT_TIMEOUT_SECONDS)
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.visibilityOfAllElementsLocatedBy(xpath));
        }
        }



