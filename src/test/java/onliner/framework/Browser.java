package onliner.framework;

import org.openqa.selenium.WebDriver;

import static onliner.framework.DriverFactory.getWebDriver;

public class Browser {
  public static WebDriver driver;

  public Browser(String driverName){
    Browser.driver = getWebDriver(driverName);
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