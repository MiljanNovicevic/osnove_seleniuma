package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://s.bootsnipp.com/iframe/Dq2X");

        List<WebElement> elements = driver.findElements(By.className("alert"));

        for (int i = elements.size()-1; i >= 0; i--) {
            elements.get(i).findElement(By.className("close")).click();
            Thread.sleep(3000);
        }


        Thread.sleep(3000);
        driver.quit();
    }
}


