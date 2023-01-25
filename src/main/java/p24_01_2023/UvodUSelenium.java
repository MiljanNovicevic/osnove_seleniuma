package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UvodUSelenium {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

//        driver.get("https://cms.demo.katalon.com/");
//        driver.get("www.google.com");
        driver.manage().window().maximize();
//        driver.navigate().to("https://google.com/");
//        driver.navigate().to("https://youtube.com/");
//        driver.navigate().to("https://google.com");
//        driver.navigate().back();

        driver.navigate().to("https://google.com");
        WebElement searchInput =  driver.findElement(By.xpath("(//input[@name='q'])"));
        searchInput.sendKeys("IT Bootcamp");
        searchInput.sendKeys(Keys.ENTER);
        Thread.sleep(1000);

        WebElement firstlink =
        driver.findElement(By.xpath("//a[@href='https://itbootcamp.rs/']"));
        firstlink.click();


        Thread.sleep(5000);

        driver.quit();

    }
}
