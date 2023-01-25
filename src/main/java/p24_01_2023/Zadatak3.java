package p24_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class Zadatak3 {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        ArrayList<String> webstranice = new ArrayList<>();

        webstranice.add("https://google.com/");
        webstranice.add("https://youtube.com/");
        webstranice.add("https://www.ebay.com/");
        webstranice.add("https://www.kupujemprodajem.com/");


//        for (String stranica : webstranice) {
//            driver.get(stranica);
//            System.out.println(driver.getTitle());

        for (int i = 0; i < webstranice.size(); i++) {
            driver.get(webstranice.get(i));
            System.out.println(driver.getTitle());
            System.out.println(driver.getCurrentUrl());
            System.out.println();

        }
        driver.quit();

        }

    }
