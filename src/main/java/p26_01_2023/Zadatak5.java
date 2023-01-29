package p26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Zadatak5 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        Thread.sleep(3000);

        driver.findElement(By.xpath("//*[@id='gh-cat']"));

        Select sc = new Select(driver.findElement(By.xpath("//*[@id='gh-cat']")));

        sc.selectByVisibleText("Crafts");

        Thread.sleep(1000);

        driver.quit();



    }

}
