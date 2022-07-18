package steps;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pages.MyAccountPage;
import tests.BaseCucumberTest;

public class MyAccountPageSteps extends BaseCucumberTest {

  @Then("Username is {string}")
  public void usernameIs(String username) {
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    Assert.assertEquals(myAccountPage.getVisibleUsername(), username);
  }

  @And("Welcome message {string} is displayed")
  public void welcomeMessageIsDisplayed(String welcomeMessage) {
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    Assert.assertEquals(myAccountPage.getVisibleWelcomeMessage(), welcomeMessage);
  }

  @Then("Error massage {string} is displayed")
  public void errorMassage(String errorMessage) {
    MyAccountPage myAccountPage = new MyAccountPage(driver);
    Assert.assertEquals(myAccountPage.getVisibleErrorMessage(), errorMessage);
  }

  @After
  public void tearDown() {
    driver.quit();
  }
}
