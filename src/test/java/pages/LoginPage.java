package pages;

import core.ReadProperties;
import elements.Button;
import elements.Input;
import models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

  private static final By PAGE_OPENED_IDENTIFIER = By.xpath(
      "//*[@class='page-heading' and text()='Authentication']");
  private static String ENDPOINT = "/index.php?controller=authentication&back=my-account";
  protected By emailSelector = By.id("email");
  protected By passwordSelector = By.id("passwd");
  protected By loginSelector = By.id("SubmitLogin");

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public LoginPage(WebDriver driver, boolean openByURL) {
    super(driver, openByURL);
  }

  @Override
  protected void openPage() {
    driver.get(BASE_URL + ENDPOINT);
  }

  @Override
  protected boolean isPageOpened() {
    return waits.waitForVisibility(PAGE_OPENED_IDENTIFIER).isDisplayed();
  }

  public Input getEmailField() {
    return new Input(driver, emailSelector);
  }

  public Input getPasswordField() {
    return new Input(driver, passwordSelector);
  }

  public Button getLoginButton() {
    return new Button(driver, loginSelector);
  }


  public void login(User user) {
    getEmailField().sendKeys(user.getEmail());
    getPasswordField().sendKeys(user.getPassword());
    getLoginButton().click();
  }

  public void login(String username, String password) {
    User user = User.builder()
        .email(username)
        .password(password)
        .build();
    login(user);
  }
}
