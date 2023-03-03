package pageobject_model.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser extends AbstractPage {
    public WebDriver driver;

    public Browser(WebDriver driver) {
        super(driver);
    }

    public static void openOnliner() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
    }
}
