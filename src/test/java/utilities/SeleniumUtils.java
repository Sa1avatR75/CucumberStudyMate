package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumUtils {

    public static void waitForElementTobeVisible(WebElement element, WebDriver driver, int duration ){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(ExpectedConditions.visibilityOf(element));
    }
    public static void waitForSeconds(int numberOfSeconds){
        try{
            Thread.sleep(numberOfSeconds * 1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
