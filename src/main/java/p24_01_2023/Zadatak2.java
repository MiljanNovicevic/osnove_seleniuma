package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/login ");

        WebElement userNameInput =  driver.findElement(By.xpath("(//input[@id='userName'])"));
        userNameInput.sendKeys("itbootcamp");

        WebElement passwordInput =
                driver.findElement(By.xpath("(//input[@placeholder='Password'])"));
        passwordInput.sendKeys("ITBootcamp2021!");

        WebElement firstlink =
                driver.findElement(By.xpath("//form/div[4]/div/button"));
        firstlink.click();

        Thread.sleep(5000);

        WebElement secondlink =
                driver.findElement(By.xpath("//button[text()='Log out']"));
        secondlink.click();
        Thread.sleep(1000);
        driver.quit();

    }
}

