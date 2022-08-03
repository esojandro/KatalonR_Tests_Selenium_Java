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

public class Test10Busqueda2UsandoJson {
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
  public void test10Busqueda2UsandoJson() throws Exception {
    //ERROR: Caught exception [ERROR: Unsupported command [loadVars | test10_data.json | ]]
    driver.get("https://www.timeanddate.com/");
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div/div/div/div[2]/div/form/input")).click();
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div/div/div/div[2]/div/form/input")).clear();
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div/div/div/div[2]/div/form/input")).sendKeys("${city}");
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div/div/div/div[2]/div/form/button/i")).click();
    driver.findElement(By.linkText("Home")).click();
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div[2]/div[2]/div[2]/form/input")).click();
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div[2]/div[2]/div[2]/form/input")).clear();
    driver.findElement(By.xpath("//div[@id='main-content']/div[2]/div[2]/div[2]/div[2]/div[2]/form/input")).sendKeys("costa");
    //driver.findElement(By.xpath("//div[@id='po1']/div/ul/li[3]/a/span")).click();
    //driver.findElement(By.linkText("Home")).click();
    //ERROR: Caught exception [ERROR: Unsupported command [endLoadVars |  | ]]
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
