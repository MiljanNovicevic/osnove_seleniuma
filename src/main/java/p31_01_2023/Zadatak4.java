package p31_01_2023;

import com.sun.deploy.cache.Cache;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Zadatak4 {
    public static void main(String[] args) throws Exception {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        Actions actions = new Actions(driver);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.get(" https://cms.demo.katalon.com/");
        driver.manage().window().maximize();

        TakesScreenshot screenShot = ((TakesScreenshot)driver);
        File SrcFile = screenShot.getScreenshotAs(OutputType.FILE);
        takeSnapShot(driver, "screenshots/screenshot1.jpg");

        Thread.sleep(5000);
        driver.quit();




    }

        public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
//Convert web driver object to TakeScreenshot
            TakesScreenshot scrShot =((TakesScreenshot)webdriver);
//Call getScreenshotAs method to create image file
            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//Move image file to new destination
            File DestFile=new File(fileWithPath);
//Copy file at destination
            Cache FileUtils=null;
            FileUtils.copyFile(SrcFile, DestFile);
        }
    }


