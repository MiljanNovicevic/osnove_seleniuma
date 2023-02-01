package p31_01_2023;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;



public class Zadatak3 {
//    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
//        WebDriver driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
//        Actions actions = new Actions(driver);
//        String uploadImgPath = new File("test_data/nis.jpg").getAbsolutePath();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        driver.get("https://blueimp.github.io/jQuery-File-Upload/");
//        driver.manage().window().maximize();
//
//        String url = "https://www.journaldev.com/sitemap.xml";
//        try {
//            downloadUsingStream("/Users/pankaj/sitemap_stream.xml");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }






    }

//    private static void downloadUsingStream(String s) throws IOException{
//
//        URL url = new URL("https://cms.demo.katalon.com/wp-content/uploads/2019/08/600x600xposter_2_up.jpg.pagespeed.ic.chnYZ4B0V2.webpurl");
//        BufferedInputStream bis = new BufferedInputStream(url.openStream());
//        FileOutputStream fis = new FileOutputStream(file);
//        byte[] buffer = new byte[1024];
//        int count=0;
//        while((count = bis.read(buffer,0,1024)) != -1)
//        {
//            fis.write(buffer, 0, count);
//        }
//        fis.close();
//        bis.close();
//    }
//    }
