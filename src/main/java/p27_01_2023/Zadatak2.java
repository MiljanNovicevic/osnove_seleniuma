package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("file:///C:/Users/Miljan%20IT/Downloads/Zadatak4.html");;
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.id("showInBtn")).click();
            driver.findElement(By.id("id-" + i));

        }

        Thread.sleep(5000);
        driver.quit();
    }
}
