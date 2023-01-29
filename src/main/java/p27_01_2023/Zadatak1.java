package p27_01_2023;

//1.Zadatak
//        Ucitati stranicu https://demoqa.com/modal-dialogs
//        Kliknuti na dugme Large modal
//        Proverite da li se prikazao dijalog i ispisite u konzoli odgovarajuce poruke

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://demoqa.com/modal-dialogs");

        WebElement largeModal =
                driver.findElement(By.id("showLargeModal"));
        largeModal.click();



        if (driver.findElements(By.id("showLargeModal")).size() > 0 ){
            System.out.println("Large Modal je prikazan");
        } else System.out.println("Large Modal nije prikazan");

        driver.quit();







    }
}
