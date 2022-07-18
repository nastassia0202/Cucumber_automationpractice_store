package pages;

import core.ReadProperties;
import org.openqa.selenium.WebDriver;
import utils.Waits;

public class BasePage {

  protected WebDriver driver;
  protected String BASE_URL;
  protected Waits waits;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    this.waits = new Waits(driver);
    this.BASE_URL = ReadProperties.getUrl();
  }
}
