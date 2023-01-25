package p24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://cms.demo.katalon.com/");


        WebElement searchInput =  driver.findElement(By.xpath("(//input[@name='s'])"));
        searchInput.sendKeys("Flying Ninja");

        Thread.sleep(1000);

        WebElement firstlink =
                driver.findElement(By.xpath("//button[contains(@class,'search-submit')]"));
        firstlink.click();

        Thread.sleep(1000);

        driver.quit();

    }
}
