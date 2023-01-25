package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login ");
        Thread.sleep(5000);

        WebElement userNameInput =  driver.findElement(By.xpath("(//input[@name='username'])"));
        userNameInput.sendKeys("Admin");

        WebElement passwordInput =
                driver.findElement(By.xpath("(//input[@name='password'])"));
        passwordInput.sendKeys("admin123");

        WebElement loginButton =
                driver.findElement(By.xpath("//button[contains(@class,'login'"));
        loginButton.click();

        Thread.sleep(5000);

        driver.findElement(By.xpath("//input[contains(@placeholder,'Search')]"))
                .sendKeys("Me");
        driver.findElement(By.xpath("//a[@href='/web/index.php/time/viewTimeModule']"))
                .click();

        Thread.sleep(3000);

        driver.findElement(By.xpath("//i[contains(@class,'dropdown')]"))
                .click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//a[@href='/web/index.php/auth/logout']"))
                .click();

        Thread.sleep(5000);

        driver.quit();






    }
}
