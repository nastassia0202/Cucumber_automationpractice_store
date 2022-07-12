package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage extends BasePage {

  private final By errorAuthMessage = By.xpath("//*[text()='Authentication failed.']");
  private final By welcomeMessageLocator = By.className("info-account");
  private static String ENDPOINT = "/index.php?controller=my-account";
  private final By username = By.xpath("//*[@title='View my customer account']//span");

  public MyAccountPage(WebDriver driver) {
    super(driver);
  }

  public MyAccountPage(WebDriver driver, boolean openByURL) {
    super(driver, openByURL);
  }

  @Override
  protected void openPage() {
    driver.get(BASE_URL + ENDPOINT);
  }

  @Override
  protected boolean isPageOpened() {
    return true;
  }

  private WebElement getUsername() {
    return driver.findElement(username);
  }

  public String getVisibleUsername() {
    return getUsername().getText();
  }

  private WebElement getWelcomeMessage() {
    return driver.findElement(welcomeMessageLocator);
  }

  public String getVisibleWelcomeMessage() {
    return getWelcomeMessage().getText();
  }

  private WebElement getErrorMessage() {
    return driver.findElement(errorAuthMessage);
  }

  public String getVisibleErrorMessage() {
    return getErrorMessage().getText();
  }
}
