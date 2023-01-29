package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class Zadatak4 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://geodata.solutions/");
        driver.manage().window().maximize();


        driver.findElement(By.name("country")).click();
        WebElement selectElement= driver.findElement(By.name("country"));
                Select select = new Select(selectElement);
        select.selectByVisibleText("Canada");
        Thread.sleep(1000);


        driver.findElement(By.name("state")).click();
        WebElement selectElement1 = driver.findElement(By.name("state"));
        Select select1 = new Select(selectElement1);
        select1.selectByVisibleText("Manitoba");
        Thread.sleep(3000);

        driver.findElement(By.name("city")).click();
        WebElement selectElement2 = driver.findElement(By.name("city"));
        Select select2 = new Select(selectElement2);
        select2.selectByVisibleText("Morris");

        Thread.sleep(1000);
        driver.quit();
    }
}
