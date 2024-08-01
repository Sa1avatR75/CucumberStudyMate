package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.SeleniumUtils;

import java.util.List;

public class CoursesPage {
    WebDriver driver;

    public CoursesPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[contains(@class,'MuiTypography-root MuiTypography-h5')]")
    List<WebElement> listOfCourses;
    @FindBy(xpath = "//div[@class='sc-iWOQzb UgwiX']//p")
    List<WebElement> listOfLessons;

    public void clickOnCourseByTitle(String courseTitle){
        SeleniumUtils.waitForElementTobeVisible(listOfCourses.get(0),driver,10 );
        for (WebElement course: listOfCourses){
          if (course.getText().equals(courseTitle)) {
              course.click();
              break;
          }
        }
    }
    public int seeListOfLessons(){
      return listOfLessons.size();
    }

    public void clickOnLessonByTitle(String lessonTitle){
        for (WebElement lesson: listOfLessons){
            String title = lesson.getText().split("   ")[1];
            if (title.equals(lessonTitle)) {
                lesson.click();
                break;
            }
        }

    }
}
