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

public class Test11SumaUsandoJsonYQuemandoLaOperaciN {
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
  public void test11SumaUsandoJsonYQuemandoLaOperaciN() throws Exception {
    //ERROR: Caught exception [ERROR: Unsupported command [loadVars | test11_data.json | ]]
    driver.get("https://testsheepnz.github.io/");
    driver.findElement(By.xpath("//a[@id='gotoBasicCalc']/div")).click();
    driver.findElement(By.id("number1Field")).click();
    driver.findElement(By.id("number1Field")).clear();
    driver.findElement(By.id("number1Field")).sendKeys("${n1}");
    driver.findElement(By.id("number2Field")).click();
    driver.findElement(By.id("number2Field")).clear();
    driver.findElement(By.id("number2Field")).sendKeys("${n2}");
    driver.findElement(By.id("selectOperationDropdown")).click();
    new Select(driver.findElement(By.id("selectOperationDropdown"))).selectByVisibleText("Add");
    driver.findElement(By.id("calculateButton")).click();
    driver.findElement(By.id("clearButton")).click();
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
