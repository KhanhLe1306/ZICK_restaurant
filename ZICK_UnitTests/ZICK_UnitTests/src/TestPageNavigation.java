
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

public class TestPageNavigation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  JavascriptExecutor js;
  @Before
  public void setUp() throws Exception {
    System.setProperty("webdriver.chrome.driver", "/Users/zach/ChromeDriver/chromedriver");
    driver = new ChromeDriver();
    baseUrl = "https://www.google.com/";
    driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
    js = (JavascriptExecutor) driver;
  }

  @Test
  public void testPageNavigation() throws Exception {
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::button[2]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/Menu");
    driver.findElement(By.linkText("Home")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.linkText("About Us")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/aboutus.jsp");
    driver.findElement(By.linkText("Home")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.linkText("Contact")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/contact.jsp");
    driver.findElement(By.linkText("Home")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Contact'])[1]/following::button[1]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/login.jsp");
    driver.findElement(By.linkText("Home")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::button[1]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/signup.jsp");
    driver.findElement(By.linkText("Home")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
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
