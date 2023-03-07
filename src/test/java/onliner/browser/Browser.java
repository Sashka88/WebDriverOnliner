package onliner.browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
  public WebDriver driver;

  public Browser() {
    this.driver = new ChromeDriver();
  }

  public void maximizeWindow() {
    driver.manage().window().maximize();
  }

  public void getBasePage(String url) {
    driver.get(url);
  }
}
