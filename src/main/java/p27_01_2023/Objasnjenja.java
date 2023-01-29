package p27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Objasnjenja {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.get("file:///C:/Users/Miljan%20IT/Downloads/Zadatak4.html");

 //       WebElement div = driver.findElement(By.id("id=o"));

        boolean elementExists = true;

        try {
            System.out.println("Posle trazenja");
            WebElement div = driver.findElement(By.id("id-0"));

            System.out.println("Posle trazenja");

        } catch (NoSuchElementException error){
            System.out.println("GRESKA");
        }

        if (elementExists){
            System.out.println("Element postoji");
        } else {
            System.out.println("Element ne postoji");
        }

        Thread.sleep(5000);
        driver.quit();


    }

}
