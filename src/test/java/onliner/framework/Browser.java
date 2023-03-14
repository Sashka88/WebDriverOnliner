package onliner.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
  public static WebDriver driver;

  public Browser(WebDriver driver){
    Browser.driver = driver;
  }

  public static WebDriver getWebDriver(String browserName) {
      switch(browserName){
        case "Chrome":
          WebDriverManager.chromedriver().setup();
          driver = new ChromeDriver();
          break;
        case "Firefox":
          WebDriverManager.firefoxdriver().setup();
          driver = new FirefoxDriver();
          break;
        case "Edge":
          WebDriverManager.edgedriver().setup();
          driver = new EdgeDriver();
          break;
        default:
          throw new RuntimeException("Incorrect Browser Name");
      }
      return driver;
  }

  public void maximizeWindow() {
    driver.manage().window().maximize();
  }

  public void navigatePage(String url) {
    driver.get(url);
  }

  public void quitBrowser() {
    driver.quit();
  }
}
