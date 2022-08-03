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

public class Test12ValidarDigitoEnLabel {
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
  public void test12ValidarDigitoEnLabel() throws Exception {
    driver.get("https://demo-store.katalon.com/dashboard");
    driver.findElement(By.xpath("//img[contains(@src,'https://static.zara.net/photos///2018/I/0/1/p/7568/469/251/2/w/1920/7568469251_2_1_1.jpg?ts=1540393989160')]")).click();
    String displayedPrice = (String)driver.findElement(By.xpath("//div[@id='root']/div/div/div/div[2]/div/div[2]/div/div[3]")).getText();
    String itemPrice = (String)js.executeScript("var displayedPrice = \"" + displayedPrice + "\";var storedVars = { 'displayedPrice': displayedPrice }; return " + "\"" + displayedPrice + "\".substring(0, 6)" + "");
    try {
      assertTrue(Pattern.compile("^[$](\\d+\\.\\d+)").matcher((CharSequence) js.executeScript("var displayedPrice = \"" + displayedPrice + "\";var itemPrice = \"" + itemPrice + "\";var storedVars = { 'displayedPrice': displayedPrice,'itemPrice': itemPrice }; return " + "\"" + itemPrice + "\"" + "")).find());
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
