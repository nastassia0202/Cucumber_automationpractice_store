package utils;

import core.ReadProperties;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class Waits {

  private WebDriver driver;
  private WebDriverWait wait;

  public Waits(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(ReadProperties.getTimeOut()));
  }

  public Waits(WebDriver driver, int timeOut) {
    this.driver = driver;
    wait = new WebDriverWait(driver, Duration.ofSeconds(timeOut));
  }

  public boolean waitForVisibility(WebElement element) {
    return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
  }

  public boolean waitForInvisibility(WebElement element) {
    return wait.until(ExpectedConditions.invisibilityOf(element));
  }

  public WebElement waitForVisibility(By by) {
    return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
  }

  public WebElement waitForClickable(WebElement webElement) {
    return wait.until(ExpectedConditions.elementToBeClickable(webElement));
  }
}
