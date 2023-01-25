package d24_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        ArrayList<String> toDo=new ArrayList<>();

        toDo.add("Visit Paris");
        toDo.add("Visit Prague");
        toDo.add("Visit London");
        toDo.add("Visit New York");
        toDo.add("Visit Belgrade");

        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        for (String todo : toDo  ){
            driver.findElement(By.xpath("//input[@class='new-todo']")).sendKeys(todo + '\n');
        }
        Thread.sleep(5000);
        driver.quit();


    }
}

