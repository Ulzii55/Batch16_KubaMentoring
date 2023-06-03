package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class test3 {
    @Test
    public void test3() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement JSAlert = driver.findElement(By.linkText("Javascript Alerts"));
        JSAlert.click();

        WebElement clickMe1 = driver.findElement(By.xpath("//button[@class='btn btn-dark my-30 mx-10 hover:bg-lambda-900 hover:border-lambda-900']"));
        clickMe1.click();
        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        String expectedText = "Alert box!";
        Assert.assertEquals(actualText, expectedText);
        alert.accept();

        WebElement confirmBox = driver.findElement(By.xpath("//p[contains(.,'Confirm box:')]//folowing-siblings::"));
        confirmBox.click();
        alert.dismiss();


    }

    @Test
    public void test4() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement Dragslider = driver.findElement(By.linkText("Drag & Drop Sliders"));
        Dragslider.click();
        List<WebElement> allSliders = driver.findElements(By.xpath("//div//input[@class='sp__range']"));
        List<WebElement> allrange = driver.findElements(By.tagName("output"));


        for (int i = 0; i < allSliders.size(); i++) {

            while (!allrange.get(i).getText().equals("85")) {

                if (allSliders.get(i).getText().equals("85")) {
                    break;
                } else {
                    allSliders.get(i).sendKeys(Keys.ARROW_RIGHT);
                }
            }

        }
        driver.quit();

    }
}