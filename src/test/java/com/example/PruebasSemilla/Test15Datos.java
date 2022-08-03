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

public class Test15Datos {
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
  public void test15Datos() throws Exception {
    //ERROR: Caught exception [ERROR: Unsupported command [loadVars | test15_data.csv | ]]
    driver.get("https://katalon-demo-cura.herokuapp.com/");
    driver.findElement(By.xpath("//a[@id='menu-toggle']/i")).click();
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("txt-username")).click();
    driver.findElement(By.id("txt-username")).clear();
    driver.findElement(By.id("txt-username")).sendKeys("John Doe");
    driver.findElement(By.id("txt-password")).click();
    driver.findElement(By.xpath("//section[@id='login']/div/div/div[2]/form/div[3]")).click();
    driver.findElement(By.id("txt-password")).clear();
    driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
    driver.findElement(By.xpath("//section[@id='login']/div/div/div[2]/form/div[3]/label")).click();
    driver.findElement(By.id("btn-login")).click();
    driver.findElement(By.id("txt_visit_date")).click();
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Sa'])[1]/following::td[25]")).click();
    driver.findElement(By.id("txt_comment")).click();
    driver.findElement(By.id("txt_comment")).clear();
    driver.findElement(By.id("txt_comment")).sendKeys("${Comment}");
    driver.findElement(By.id("btn-book-appointment")).click();
    driver.findElement(By.xpath("//a[@id='menu-toggle']/i")).click();
    driver.findElement(By.linkText("Logout")).click();
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
