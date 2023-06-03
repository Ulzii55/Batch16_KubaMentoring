package lambda_test;

import Utils.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

public class test2 {
    @Test()
    public void test1() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");


        WebElement TablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        TablePagination.click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropDown, "5000", "value");

        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));


        for (int i = 0; i < allNames.size(); i++) {
            TreeMap<String, String> map = new TreeMap<>();
            map.put(BrowserUtils.getText(allNames.get(i)), BrowserUtils.getText(allEmails.get(i)));
            System.out.println("Map = " + map);

        }


    }


    @Test()
    public void test2() {

        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.lambdatest.com/selenium-playground");


        WebElement TablePagination = driver.findElement(By.xpath("//a[.='Table Pagination']"));
        TablePagination.click();

        WebElement dropDown = driver.findElement(By.xpath("//select[@id='maxRows']"));
        BrowserUtils.selectBy(dropDown, "5000", "value");


        List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
        List<WebElement> allPhoneNumbers = driver.findElements(By.xpath("//tr//td[4]"));

        TreeMap<String, Long> map2 = new TreeMap<>();
        for (int i = 0; i < allNames.size(); i++) {
            map2 = new TreeMap<>();

            map2.put(BrowserUtils.getText(allNames.get(i)),
                    Long.parseLong(BrowserUtils.getText(allPhoneNumbers.get(i)).replace("-", "")));

        }

        System.out.println(map2);

    }


}
