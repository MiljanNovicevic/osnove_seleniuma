package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        driver.get("https://s.bootsnipp.com/iframe/klDWV");
        driver.manage().window().maximize();

//        WebElement progressBar = driver.findElement((By.xpath("//*[@id = 'percent']")));
        wait.until(ExpectedConditions.textToBe(
                (By.xpath("//div[@id = 'percent']")), "100%"));

        //        wait.until(ExpectedConditions.attributeToBe(progressBar, "aria-valuenow", "100"));

        System.out.println("Stranica učitana");
        driver.quit();
    }
}
