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

public class Test4FormularioUtilizaciNXpath {
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
  public void test4FormularioUtilizaciNXpath() throws Exception {
    driver.get("https://demoqa.com/automation-practice-form");
    driver.findElement(By.cssSelector("path")).click();
//    driver.findElement(By.xpath("(//div[contains(@class,'card-up')])[1]")).click();
//    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Forms'])[1]/following::span[1]")).click();
    driver.findElement(By.id("firstName")).click();
    driver.findElement(By.id("firstName")).clear();
    driver.findElement(By.id("firstName")).sendKeys("M");
    driver.findElement(By.id("lastName")).click();
    driver.findElement(By.id("lastName")).clear();
    driver.findElement(By.id("lastName")).sendKeys("R");
    driver.findElement(By.id("userEmail")).click();
    driver.findElement(By.id("userEmail")).clear();
    driver.findElement(By.id("userEmail")).sendKeys("no email fail");
    driver.findElement(By.xpath("//div[@id='genterWrapper']/div[2]/div[3]/label")).click();
    driver.findElement(By.id("userNumber")).click();
    driver.findElement(By.id("userNumber")).clear();
    driver.findElement(By.id("userNumber")).sendKeys("lestters");
    driver.findElement(By.id("dateOfBirthInput")).click();
    driver.findElement(By.xpath("//div[@id='dateOfBirth']/div[2]/div[2]/div/div/div[2]/div[2]/div[4]/div[5]")).click();
    driver.findElement(By.xpath("//div[@id='subjectsContainer']/div/div")).click();
    driver.findElement(By.id("subjectsInput")).clear();
    driver.findElement(By.id("subjectsInput")).sendKeys("karkarta");
    driver.findElement(By.xpath("//div[@id='hobbiesWrapper']/div[2]/div/label")).click();
    driver.findElement(By.xpath("//div[@id='subjectsContainer']/div/div")).click();
    driver.findElement(By.id("currentAddress")).click();
    driver.findElement(By.id("currentAddress")).clear();
    driver.findElement(By.id("currentAddress")).sendKeys("12312312lettes***/*-+");
//    driver.findElement(By.id("state")).click();
//    driver.findElement(By.id("react-select-3-option-0")).click();
//    driver.findElement(By.id("city")).click();
//    driver.findElement(By.id("react-select-4-option-2")).click();
//    driver.findElement(By.id("state")).click();
//    driver.findElement(By.id("react-select-3-option-3")).click();
    
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
