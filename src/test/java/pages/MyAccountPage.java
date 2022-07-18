package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MyAccountPage extends BasePage {

  private final By errorAuthMessage = By.xpath("//*[@class=\"alert alert-danger\"]//li");
  private final By welcomeMessageLocator = By.className("info-account");
  private final By username = By.xpath("//*[@title='View my customer account']//span");

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  public String getVisibleUsername() {
    return driver.findElement(username).getText();
  }

  public String getVisibleWelcomeMessage() {
    return driver.findElement(welcomeMessageLocator).getText();
  }

  public String getVisibleErrorMessage() {
    return driver.findElement(errorAuthMessage).getText();
  }
}
