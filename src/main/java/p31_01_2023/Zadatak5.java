package p31_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
//Ucitava stranicu https://cms.demo.katalon.com/
//        Hvata  sve href atribute svih linkova iz navigacije
//        Za svaki link proverava status da je veci ili jednak od 200 i manji od 400
//        Koristan link za citanje status koda nekog url-a

public class Zadatak5 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        String uploadImgPath = new File("test_data/nis.jpg").getAbsolutePath();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(" https://cms.demo.katalon.com/");
        driver.manage().window().maximize();
    }
}
