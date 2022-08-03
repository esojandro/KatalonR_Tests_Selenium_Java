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

public class Test132ControlFlowCommands {
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
  public void test132ControlFlowCommands() throws Exception {
    driver.get("https://cms.demo.katalon.com/");
//    long index = 1;
//    while (index < 13) {
//      String itemText = (String)driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[" + index + "]/div/a[2]")).getText();
//      if (itemText.toString().equals("Add to cart")) {
//        driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[2]/div/a[2]")).click();
//        try {
//          assertEquals("View cart", driver.findElement(By.xpath("//main[@id='main']/div[2]/ul/li[2]/div/a[3]")).getText());
//        } catch (Error e) {
//          verificationErrors.append(e.toString());
//        }
//      }
//      index = (long)js.executeScript("var index = \"" + index + "\";var itemText = \"" + itemText + "\";var storedVars = { 'index': index,'itemText': itemText }; return " + index + " + 1" + "");
//    }
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
