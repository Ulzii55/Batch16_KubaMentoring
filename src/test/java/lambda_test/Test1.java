package lambda_test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Test1 {
    @Test()
    public void test1() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");

        WebElement input = driver.findElement(By.xpath("//a[.='Input Form Submit']"));
        input.click();
        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Name']"));
        name.sendKeys("Ulzii Ganbat");
        WebElement email = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        email.sendKeys("Ulzii12345@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        password.sendKeys("Ulzii12345678");
        WebElement company = driver.findElement(By.xpath("//input[@placeholder='Company']"));
        company.sendKeys("CodeFish");
        WebElement website = driver.findElement(By.xpath("//input[@placeholder='Website']"));
        website.sendKeys("www.CodeFish.com");
        WebElement country = driver.findElement(By.xpath("//select[@name='country']"));
        country.sendKeys("United States");
        WebElement city = driver.findElement(By.xpath("//input[@id='inputCity']"));
        city.sendKeys("Chicago");
        WebElement address = driver.findElement(By.xpath("//input[@id='inputAddress1']"));
        address.sendKeys("1234 Devon street");
        WebElement state = driver.findElement(By.xpath("//input[@id='inputState']"));
        state.sendKeys("IL");
        WebElement zipCode = driver.findElement(By.xpath("//input[@id='inputZip']"));
        zipCode.sendKeys("60078");
        WebElement submit = driver.findElement(By.xpath("//button[.='Submit']"));
        submit.click();


    }
}
