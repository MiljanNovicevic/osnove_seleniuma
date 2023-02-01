package p30_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));

        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement primaryButton = driver.findElement(By.xpath("//button[contains(@id, 'primary')]"));
        wait.until(ExpectedConditions.elementToBeClickable(primaryButton));
        primaryButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se pojavio");
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se izgubio");

        primaryButton.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se pojavio");
        driver.findElement(By.xpath("//button[@class='btn-close']")).click();

        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[contains(@id, 'basic')]"))));
        System.out.println("Element se izgubio");

        System.out.println("Kraj");
        Thread.sleep(3000);
        driver.quit();


    }
}
