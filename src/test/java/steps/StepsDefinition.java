package steps;

import core.BrowsersService;
import core.ReadProperties;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.User;
import org.testng.Assert;
import pages.LoginPage;
import pages.MyAccountPage;
import tests.BaseCucumberTest;

public class StepsDefinition extends BaseCucumberTest {

  public LoginPage loginPage;

  @Given("browser is opened")
  public void browserIsStarted() {
    driver = new BrowsersService().getDriver();
  }

  @After
  public void tearDown() {
    driver.quit();
  }

  @And("login page is opened")
  public void loginPageIsOpened() {
    loginPage = new LoginPage(driver, true);
  }

  @And("email field is displayed")
  public void emailFieldIsDisplayed() {
    Assert.assertTrue(loginPage.getEmailField().isDisplayed());
  }

  @When("user {string} with password {string} logged in")
  public void userWithPasswordLoggedIn(String email, String password) {
    loginPage.login(email, password);
  }

  @Then("username is {string}")
  public void usernameIs(String username) {
    MyAccountPage myAccountPage = new MyAccountPage(driver, false);
    Assert.assertEquals(myAccountPage.getVisibleUsername(), username);
  }

  @And("welcome message {string} is displayed")
  public void welcomeMessageIsDisplayed(String welcomeMessage) {
    MyAccountPage myAccountPage = new MyAccountPage(driver, false);
    Assert.assertEquals(myAccountPage.getVisibleWelcomeMessage(), welcomeMessage);
  }

  @Then("error massage {string}")
  public void errorMassage(String errorMessage) {
    MyAccountPage myAccountPage = new MyAccountPage(driver, false);
    Assert.assertEquals(myAccountPage.getVisibleErrorMessage(), errorMessage);
  }
}
