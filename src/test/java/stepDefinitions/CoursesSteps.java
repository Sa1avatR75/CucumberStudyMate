package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CoursesPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class CoursesSteps {

    WebDriver driver = Driver.getDriver();
    private LoginPage loginPage = new LoginPage(driver);
    private CoursesPage coursesPage = new CoursesPage(driver);


    @Given("user on the my courses page")
    public void user_on_the_my_courses_page() {
        driver.get(Config.getValue("URL"));
        loginPage.logIn(Config.getValue("validLogin"), Config.getValue("validPassword"));
    }
    @When("user clicks on the course {string}")
    public void user_clicks_on_the_course(String courseTitle) {
        coursesPage.clickOnCourseByTitle(courseTitle);
    }

    @Then("user should see all lessons")
    public void user_should_see_all_lessons() {
        int numberOfLessons = coursesPage.seeListOfLessons();
        Assert.assertTrue(numberOfLessons > 0);
    }

    @And("close browser")
    public void close_browser() {
        Driver.close();
    }
}
