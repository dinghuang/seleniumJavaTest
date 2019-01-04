package io.choerodon.selenium.basic;

import java.util.concurrent.TimeUnit;

import io.choerodon.selenium.parse.SeleniumConfigureParse;
import io.choerodon.selenium.util.DriverUtil;
import org.junit.*;

import static org.junit.Assert.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/3
 */
public class SearchBaiduTest {
    private WebDriver driver = DriverUtil.getDriver();
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
//    private String baseUrl = SeleniumConfigureParse.getSeleniumConfigure().getBaseUrl();


    @Before
    public void setUp() {
        driver.manage().window().maximize();//全屏
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testSearchBaidu() {
        driver.get("https://www.baidu.com/");
        driver.findElement(By.id("kw")).click();
        driver.findElement(By.id("kw")).clear();
        driver.findElement(By.id("kw")).sendKeys("baidu");
        driver.findElement(By.id("kw")).sendKeys(Keys.ENTER);
    }

    @After
    public void tearDown() {
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
