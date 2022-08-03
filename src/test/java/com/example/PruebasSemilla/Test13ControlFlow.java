package com.example.PruebasSemilla;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
//import org.apache.commons.io.FileUtils;
import java.io.File;
import java.time.Duration;

public class Test13ControlFlow {
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
  public void test13ControlFlow() throws Exception {
    driver.get("https://cms.demo.katalon.com/");
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//a[@href='?add-to-cart=54'][contains(.,'Add to cart')]")).click();
    try {
      assertEquals("VIEW CART", driver.findElement(By.xpath("//a[@href='https://cms.demo.katalon.com/cart/'][contains(.,'View cart')]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[2]/div/a[2]")).click();
    try {
      assertEquals("VIEW CART", driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[2]/div/a[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[3]/div/a[2]")).click();
    try {
      assertEquals("VIEW CART", driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[3]/div/a[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[4]/div/a[2]")).click();
    try {
      assertEquals("VIEW CART", driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[4]/div/a[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
    driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[7]/div/a[2]")).click();
    try {
      assertEquals("VIEW CART", driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[7]/div/a[3]")).getText());
    } catch (Error e) {
      verificationErrors.append(e.toString());
    }
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
