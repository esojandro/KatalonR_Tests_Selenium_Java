package com.example.PruebasSemilla;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class Test3LoginRegistro {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void test3LoginRegistro() throws Exception {
    driver.get("http://opencart.abstracta.us/index.php?route=common/home");
    driver.findElement(By.linkText("My Account")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.get("https://opencart.abstracta.us/index.php?route=account/login");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("mail001@email.com");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("pass123");
    driver.findElement(By.xpath("//input[@value='Login']")).click();
    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span[2]")).click();
    driver.findElement(By.linkText("Register")).click();
    driver.get("https://opencart.abstracta.us/index.php?route=account/register");
    driver.findElement(By.id("input-firstname")).click();
    driver.findElement(By.id("input-firstname")).clear();
    driver.findElement(By.id("input-firstname")).sendKeys("Brand");
    driver.findElement(By.id("input-lastname")).click();
    driver.findElement(By.id("input-lastname")).clear();
    driver.findElement(By.id("input-lastname")).sendKeys("Dovarn");
    driver.findElement(By.id("input-email")).click();
    driver.findElement(By.id("input-email")).clear();
    driver.findElement(By.id("input-email")).sendKeys("mail001@email.com");
    driver.findElement(By.id("input-telephone")).click();
    driver.findElement(By.id("input-telephone")).clear();
    driver.findElement(By.id("input-telephone")).sendKeys("96857423");
    driver.findElement(By.id("input-password")).click();
    driver.findElement(By.id("input-password")).clear();
    driver.findElement(By.id("input-password")).sendKeys("pas123");
    driver.findElement(By.id("input-confirm")).click();
    driver.findElement(By.id("input-confirm")).clear();
    driver.findElement(By.id("input-confirm")).sendKeys("pas123");
    driver.findElement(By.name("newsletter")).click();
    driver.findElement(By.name("agree")).click();
//    
//    driver.findElement(By.xpath("//input[@value='Continue']")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=account/success");
//    driver.findElement(By.linkText("Continue")).click();
//    driver.get("https://opencart.abstracta.us/index.php?route=account/account");
//    driver.findElement(By.linkText("My Account")).click();
//    driver.findElement(By.linkText("Logout")).click();
//    driver.get("https://opencart.abstracta.us/index.php?route=account/logout");
//    driver.findElement(By.linkText("Continue")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=common/home");
//    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]/a/span")).click();
//    driver.findElement(By.linkText("Login")).click();
//    driver.get("https://opencart.abstracta.us/index.php?route=account/login");
//    driver.findElement(By.id("input-email")).click();
//    driver.findElement(By.id("input-email")).clear();
//    driver.findElement(By.id("input-email")).sendKeys("mail001@email.com");
//    driver.findElement(By.id("input-password")).click();
//    driver.findElement(By.id("input-password")).clear();
//    driver.findElement(By.id("input-password")).sendKeys("pas123");
//    driver.findElement(By.xpath("//input[@value='Login']")).click();
//    driver.get("https://opencart.abstracta.us/index.php?route=account/account");
//    driver.findElement(By.linkText("Monitors (2)")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=product/category&path=25_28");
//    driver.findElement(By.xpath("//div[@id='content']/div[3]/div/div/div[2]/div[2]/button/span")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=product/product&product_id=42");
//    driver.findElement(By.xpath("//div[@id='content']/div/div[2]/div/button/i")).click();
//    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[4]/a/span")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=checkout/cart");
//    driver.get("http://opencart.abstracta.us/index.php?route=checkout/cart");
//    driver.findElement(By.xpath("//div[@id='top-links']/ul/li[2]")).click();
//    driver.findElement(By.linkText("My Account")).click();
//    driver.findElement(By.linkText("Logout")).click();
//    driver.get("https://opencart.abstracta.us/index.php?route=account/logout");
//    driver.findElement(By.linkText("Continue")).click();
//    driver.get("http://opencart.abstracta.us/index.php?route=common/home");
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
