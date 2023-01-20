package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TvPage extends AbstractPage {

    @FindBy(xpath = "//li[2]//input[@value='samsung' and (@type='checkbox')]")
    private WebElement SearchSamsungChbx;

    //@FindBy(xpath = "//li[2]//input[@value='samsung']")
    //private WebElement SearchPriceInput;

    public TvPage(WebDriver driver){
        super(driver);
    }

    public TvPage selectTvMaker()  {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(condition -> SearchSamsungChbx.isDisplayed());
        SearchSamsungChbx.click();
        return this;
    }

//    public TvPage writePrice()  {
//        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
//                .until(condition -> SearchSamsungChbx.isDisplayed());
//        SearchSamsungChbx.click();
//        return this;
//    }

    }

