package d26_01_2023;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;

public class Zadatak1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.manage().window().maximize();
        driver.navigate().to("https://example.cypress.io/todo");

        ArrayList<String> toDos = new ArrayList<>();
        toDos.add("Visit Paris");
        toDos.add("Visit Prague");
        toDos.add("Visit London");
        toDos.add("Visit New York");
        toDos.add("Visit Belgrade");

        for (int i = 0; i < toDos.size(); i++) {
            driver.findElement(By.className("new-todo")).sendKeys(toDos.get(i) + '\n');
        }

        Thread.sleep(1000);


        List<WebElement> toDoElementi =
                driver.findElements(By.xpath("//ul[@class='todo-list']/li/div"));

        for (int i = 0; i < toDoElementi.size(); i++) {
            if (toDoElementi.get(i).getText().isEmpty()) {
                System.out.println("No to-do's");
            } else {
                System.out.println("To do's");
            }
        }

        for (int i = 0; i < toDoElementi.size(); i++) {

            Actions action = new Actions(driver);
            action.moveToElement(toDoElementi.get(i));

            toDoElementi.get(i).findElement(By.xpath("//ul[@class='todo-list']/li/div/button[1]"))
                    .click();
        }



    }
}
