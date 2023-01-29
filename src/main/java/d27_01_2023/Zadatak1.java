package d27_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://mdbootstrap.com/docs/standard/components/toasts/#section-basic-example");
        driver.findElement(By.id("basic-primary-trigger")).click();


        List<WebElement> buttons = driver.findElements
                (By.xpath("//div[@class='container text-center']/button"));

        for (int i = 0; i < buttons.size(); i++) {
            buttons.get(i).click();
            Thread.sleep(1000);
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        Thread.sleep(3000);
        driver.quit();
}
}
