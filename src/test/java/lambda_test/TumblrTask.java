package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TumblrTask {
    @Test
    public void tumblrTask() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tumblr.com/");

        WebElement sigUp = driver.findElement(By.linkText("Log in"));
        sigUp.click();
        WebElement continueWithEmail = driver.findElement(By.xpath("//button[@aria-label='Continue with email']"));
        continueWithEmail.click();
        WebElement email = driver.findElement(By.xpath("//input[@type='email']"));
        email.sendKeys("Ulzii@gmail.com");
        email.sendKeys(Keys.ENTER);
        WebElement passWord = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        passWord.sendKeys("12345");
        passWord.sendKeys(Keys.ENTER);

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='a0A37 hAkP2']"));
        if (errorMessage.isDisplayed()) {
            String errorMessageText = errorMessage.getText().trim();
            String expectedErrorMessage = "Your email or password were incorrect.";
            Assert.assertEquals(errorMessageText, expectedErrorMessage);

        }

    }
}
