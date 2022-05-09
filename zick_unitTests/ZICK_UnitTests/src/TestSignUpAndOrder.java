
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

public class TestSignUpAndOrder {
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
  public void testSignUpAndOrder() throws Exception {
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Log in'])[1]/following::button[1]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/signup.jsp");
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).click();
    driver.findElement(By.name("firstname")).clear();
    driver.findElement(By.name("firstname")).sendKeys("Test");
    driver.findElement(By.name("lastname")).click();
    driver.findElement(By.name("lastname")).clear();
    driver.findElement(By.name("lastname")).sendKeys("Testy");
    driver.findElement(By.id("username")).click();
    driver.findElement(By.id("username")).clear();
    driver.findElement(By.id("username")).sendKeys("Test123");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/login.jsp");
    driver.findElement(By.name("username")).click();
    driver.findElement(By.name("username")).clear();
    driver.findElement(By.name("username")).sendKeys("Test123");
    driver.findElement(By.name("password")).click();
    driver.findElement(By.name("password")).clear();
    driver.findElement(By.name("password")).sendKeys("test");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/home.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='View Menu'])[1]/following::button[1]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/Menu");
    driver.findElement(By.name("A03_quantity")).click();
    new Select(driver.findElement(By.name("A03_quantity"))).selectByVisibleText("2");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/cart.jsp");
    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='$30.0'])[1]/following::button[1]")).click();
    driver.get("http://ec2-50-19-192-131.compute-1.amazonaws.com:8080/zick_restaurant/PlaceOrder");
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
