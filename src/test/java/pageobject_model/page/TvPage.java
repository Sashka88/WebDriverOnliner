package pageobject_model.page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class TvPage extends AbstractPage {
//    Actions builder = new Actions(driver);
    JavascriptExecutor js = (JavascriptExecutor) driver;


    @FindBy(xpath = "//ul//input[@type='checkbox' and @value='samsung']")
    private WebElement searchSamsungChbx;

    //@FindBy(xpath = "//li[2]//input[@value='samsung']")
    //private WebElement SearchPriceInput;

    public TvPage(WebDriver driver){
        super(driver);
    }

    public TvPage selectTvMaker()  {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> searchSamsungChbx.isDisplayed());
        js.executeScript("arguments[0].click();", searchSamsungChbx);
//        Action seriesOfActions = builder
//                .moveToElement(SearchSamsungChbx)
//                .click()
//                .build();
//        seriesOfActions.perform();
        return this;
    }

//    public TvPage writePrice()  {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(condition -> SearchSamsungChbx.isDisplayed());
//        SearchSamsungChbx.click();
//        return this;
//    }

    }

