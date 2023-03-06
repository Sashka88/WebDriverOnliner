package onliner.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
public WebDriver driver;
    public Browser() {
        this.driver = new ChromeDriver();
    }

    public Browser getBasePage() {
        driver.manage().window().maximize();
        driver.get("https://www.onliner.by/");
        return this;
    }
}
