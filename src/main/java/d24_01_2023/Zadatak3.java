package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Zadatak3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.navigate().to("https://www.tutorialrepublic.com/snippets/bootstrap/table-with-add-and-delete-row-feature.php");
        driver.findElement(By.xpath("//button[@type='button']")).click();

        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Miljan Novicevic");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//input[@name='department']")).sendKeys("Finance IT");
            Thread.sleep(1000);
            driver.findElement(By.name("phone")).sendKeys("(018) 333-3333");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//tbody/tr[last()]/td[last()]/a[@class='add']"))
                    .click();

        }
        Thread.sleep(5000);
        driver.quit();


    }

}



