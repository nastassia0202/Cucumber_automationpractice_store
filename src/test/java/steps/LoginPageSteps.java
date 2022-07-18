package steps;

import core.BrowsersService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LoginPage;
import tests.BaseCucumberTest;

public class LoginPageSteps extends BaseCucumberTest {

  public LoginPage loginPage;

  @Given("I open a browser and go to desktop login page")
  public void browserIsStarted() {
    driver = new BrowsersService().getDriver();
    loginPage = new LoginPage(driver, true);
    Assert.assertTrue(loginPage.getEmailField().isDisplayed());
  }

  @When("User {string} with password {string} logged in")
  public void userWithPasswordLoggedIn(String email, String password) {
    loginPage.login(email, password);
  }
}
