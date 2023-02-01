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

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        String uploadImgPath = new File("test_data/nis.jpg").getAbsolutePath();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
        driver.manage().window().maximize();


        WebElement addFile = driver.findElement(By.xpath("//input[@type='file']"));
        addFile.sendKeys(uploadImgPath);

        driver.findElement(By.xpath("//tr//*[contains(@class, 'glyphicon-upload')]")).click();

        WebElement brisi = driver.findElement(By.xpath("//button[@data-type='DELETE']"));
        wait.until(ExpectedConditions.visibilityOf(brisi));
        brisi.click();
        wait.until(ExpectedConditions.numberOfElementsToBe(By.tagName("tr"),1));


        Thread.sleep(5000);
        driver.quit();


    }
}

