package d02_02_2023;
import com.sun.org.glassfish.gmbal.Description;
import helper.Helper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.IOException;
import java.time.Duration;
public class BootstrapTableTests {

    public class BootstrapTableTestsD {
        private WebDriver driver;
        private WebDriverWait wait;
        private String baseUrl = "https://s.bootsnipp.com";

        @BeforeClass
        public void beforeClass() {
            System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
            this.driver = new ChromeDriver();
            this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        }
        @BeforeMethod
        public void beforeMethod() {
            driver.get(baseUrl);
            driver.manage().window().maximize();
        }
        @Test
        @Description("Edit Row")
        public void editRow() {
            driver.get(baseUrl + "/iframe/K5yrx");

            Assert.assertEquals(driver.getTitle(),
                    "Table with Edit and Update Data - Bootsnipp.com",
                    "Page title not as expected");

            driver.findElement(By.xpath(
                            "//tbody/tr[1]//button[contains(@class,'update')]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.id("edit")));

            driver.findElement(By.id("fn")).clear();
            driver.findElement(By.id("fn")).sendKeys("Pera");
            driver.findElement(By.id("ln")).clear();
            driver.findElement(By.id("ln")).sendKeys("Peric");
            driver.findElement(By.id("mn")).clear();
            driver.findElement(By.id("mn")).sendKeys("Perin");
            driver.findElement(By.id("up")).click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(
                    By.id("edit")));

            Assert.assertEquals(driver.findElement(By.id("f1")).getText(),"Pera","First name not updated");

            Assert.assertEquals(driver.findElement(By.id("l1")).getText(),"Peric","Last name not updated");

            Assert.assertEquals(driver.findElement(By.id("m1")).getText(),"Perin","Middle name not updated");
        }
        @Test
        @Description("Delete Row")
        public void deleteRow() {
            driver.get(baseUrl + "/iframe/K5yrx");

            Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                    "Page title not as expected");

            driver.findElement(By.xpath("//tbody/tr[1]//button[contains(@class,'delete')]")).click();

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));

            driver.findElement(By.id("del")).click();

            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("delete")));

            wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//tbody/tr[1]/td"), 0));
        }
        @Test
        @Description("Take a Screenshot")
        public void takeScreenshot() throws IOException {
            driver.get(baseUrl + "/iframe/K5yrx");

            Assert.assertEquals(driver.getTitle(),"Table with Edit and Update Data - Bootsnipp.com",
                    "Page title not as expected");

            new Helper().takeScreenshot(driver, "screenshots/pic1.png");
        }
        @AfterMethod
        public void afterMethod() {
        }
        @AfterClass
        public void afterClass() throws InterruptedException {
            Thread.sleep(5000);
            driver.quit();
        }
    }
}
