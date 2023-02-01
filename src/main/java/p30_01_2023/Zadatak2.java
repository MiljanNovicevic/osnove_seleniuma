package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://www.youtube.com");
        driver.manage().window().maximize();

        driver.findElement(By.name("search_query")).sendKeys("breskvica");
        driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("ytd-video-renderer"),3));
        driver.findElement(By.tagName("ytd-video-renderer")).click();

        System.out.println("Stranica je ucitana");
        Thread.sleep(3000);
        driver.quit();





    }
}
