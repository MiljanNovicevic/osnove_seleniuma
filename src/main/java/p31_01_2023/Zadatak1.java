package p31_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

        Actions actions = new Actions(driver);
        String uploadImgPath = new File("test_data/nis.jpg").getAbsolutePath();

        driver.get("https://tus.io/demo.html");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement uploadFile = driver.findElement(By.id("js-file-input"));

        actions.scrollToElement(uploadFile);
        actions.perform();

        driver.findElement(By.id("js-file-input")).sendKeys(uploadImgPath);
        wait.until(ExpectedConditions.
                presenceOfElementLocated(By.xpath("//a[contains(text(),'Download')]")));





        Thread.sleep(5000);
        driver.quit();


    }



}
