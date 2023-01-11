import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HelloWebDriver {

    public void openChrome() {

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.onliner.by/");
      //  Assert.assertEquals();
        new WebDriverWait(driver, Duration.ofSeconds(10))
               .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2/a[contains(text(),'Каталог')]")));

        WebElement searchBtn = driver.findElement(By.xpath("//h2/a[contains(text(),'Каталог')]"));
        searchBtn.click();
        //Assert.assertTrue(searchResults.size()>0, "searchResults are empty");

        new WebDriverWait(driver, Duration.ofSeconds(10))
            .until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//span[contains(text(),'Электроника')]"))));
       WebElement searchBtnTele = driver.findElement(By.xpath("//span[contains(text(),'Электроника')]"));
       searchBtnTele.click();
        driver.quit();
    }
}
