package d03_02_2023;
import com.sun.org.glassfish.gmbal.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;

public class KatalonShopTests {
    private WebDriver driver;
    private WebDriverWait wait;

    private String baseUrl = "https://cms.demo.katalon.com";

    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
    }

    @BeforeMethod
    public void beforeMethod(){
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(priority = 10)
    public void addingProductWithQuantityToCart(){
        driver.get(baseUrl + "/product/flying-ninja/");

        driver.findElement(By.name("quantity")).clear();
        driver.findElement(By.name("quantity")).sendKeys("3");
        driver.findElement(By.name("add-to-cart")).click();
        Assert.assertTrue(driver.findElement(By.className("woocommerce-message")).getText().contains("Flying Ninja"),
                "The message should contain a product name");

        driver.findElement(By.linkText("CART")).click();
        Assert.assertEquals(driver.getCurrentUrl(),baseUrl + "/cart/","Not on Cart page");

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), 1));
    }

    @Test (priority = 20)
    public void removeProductFromCart(){

        driver.findElement(By.linkText("CART")).click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/cart/"),"User not on the Cart page");

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), 1));

        driver.findElement(By.className("remove")).click();

        wait.until(ExpectedConditions.numberOfElementsToBe(By.className("cart_item"), 0));
    }

    @Test (priority = 30)
    public void displayErrorWhenUsernameIsMissing() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(
                        By.xpath("//*[@class='woocommerce-error']/li")).getText(),
                "Error: Username is required.",
                "User has logged in without a valid username");
    }

    @Test (priority = 40)
    public void displayErrorWhenPasswordIsMissing() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(),
                "ERROR: The password field is empty.",
                "User has logged in without entering a password");
    }

    @Test (priority = 50)
    public void displayErrorWhenPasswordIsWrong() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("invalidpassword");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(),
                "ERROR: The password you entered for the username customer is incorrect. Lost your password?",
                "User can log in with an invalid password");
    }

    @Test (priority = 60)
    public void displayErrorWhenUserDoesNotExist() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("username")).sendKeys("invaliduser");
        driver.findElement(By.id("password")).sendKeys("pass1234");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText(),
                "ERROR: Invalid username. Lost your password?",
                "User can log in with invalid username");
    }

    @Test (priority = 70)
    public void successfulLogin() {
        driver.findElement(By.linkText("MY ACCOUNT")).click();
        driver.findElement(By.id("username")).sendKeys("customer");
        driver.findElement(By.id("password")).sendKeys("crz7mrb.KNG3yxv1fbn");
        driver.findElement(By.name("login")).click();
        Assert.assertEquals(driver.findElement(
                                By.xpath("//*[@class='woocommerce-MyAccount-content']//p[1]")).getText(),
                "Hello Katalon Parlitul_Changed (not Katalon Parlitul_Changed? Log out)",
                "Unsuccessful login");
    }

    @AfterMethod
    public void afterMethod(){
        System.out.println("After Method");
    }

    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
