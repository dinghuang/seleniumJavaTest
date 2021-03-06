package io.choerodon.selenium.util;

import io.choerodon.selenium.entity.SeleniumConfigure;
import io.choerodon.selenium.enums.Browser;
import io.choerodon.selenium.enums.EPlatform;
import io.choerodon.selenium.exception.SeleniumException;
import io.choerodon.selenium.parse.SeleniumConfigureParse;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author dinghuang123@gmail.com
 * @since 2019/1/2
 */
public class DriverUtil {

    private static WebDriver webDriver = null;

    private DriverUtil() {
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(DriverUtil.class);

    /**
     * 获取驱动
     *
     * @return WebDriver
     */
    public static WebDriver getDriver() {
        SeleniumConfigure seleniumConfigure = SeleniumConfigureParse.getSeleniumConfigure();
        if (seleniumConfigure == null) {
            throw new SeleniumException("configure can't not be null");
        }
        String browser = seleniumConfigure.getBrowser();
        synchronized (DriverUtil.class) {
            if (webDriver != null) {
                return webDriver;
            } else {
                String path;
                if (browser.equals(Browser.CHROME.value())) {
                    if (seleniumConfigure.getRemoteDriverUrl() != null) {
                        handleRemoteDriverUrl(seleniumConfigure.getRemoteDriverUrl(), new ChromeOptions());
                    } else {
                        if (seleniumConfigure.getLocalDriverPath() != null) {
                            path = seleniumConfigure.getLocalDriverPath();
                        } else {
                            if (OSinfoUtil.getOSname().equals(EPlatform.Linux.value())) {
                                path = DriverUtil.class.getClassLoader().getResource("chromedriverLinux").getPath();
                            } else if (OSinfoUtil.getOSname().equals(EPlatform.Mac_OS_X.value())) {
                                path = DriverUtil.class.getClassLoader().getResource("chromedriver").getPath();
                            } else if (OSinfoUtil.getOSname().equals(EPlatform.Windows.value())) {
                                path = DriverUtil.class.getClassLoader().getResource("chromedriver.exe").getPath();
                            } else {
                                throw new IllegalArgumentException("Platform not support");
                            }
                        }
                        System.setProperty("webdriver.chrome.driver", path);
                        webDriver = new ChromeDriver();
                    }
                } else if (browser.equals(Browser.FIRE_FOX.value())) {
                    if (seleniumConfigure.getRemoteDriverUrl() != null) {
                        handleRemoteDriverUrl(seleniumConfigure.getRemoteDriverUrl(), new FirefoxOptions());
                    } else {
                        webDriver = new FirefoxDriver();
                    }
                } else if (browser.equals(Browser.SAFARI.value())) {
                    //必须先让safari控制台开启Allow Remote Automation
                    if (seleniumConfigure.getRemoteDriverUrl() != null) {
                        throw new SeleniumException("remoteDriver not support Safari");
                    }
                    webDriver = new SafariDriver();
                } else if (browser.equals(Browser.IE.value())) {
                    if (seleniumConfigure.getRemoteDriverUrl() != null) {
                        throw new SeleniumException("remoteDriver not support IE");
                    }
                    webDriver = new InternetExplorerDriver();
                } else if (browser.equals(Browser.EDGE.value())) {
                    if (seleniumConfigure.getRemoteDriverUrl() != null) {
                        throw new SeleniumException("remoteDriver not support Edge");
                    }
                    webDriver = new EdgeDriver();
                } else {
                    throw new SeleniumException("Browser not support");
                }
                return webDriver;
            }
        }
    }

    private static void handleRemoteDriverUrl(String remoteDriverUrl, MutableCapabilities browser) {

        try {
            webDriver = new RemoteWebDriver(new URL(remoteDriverUrl), browser);
        } catch (MalformedURLException e) {
            throw new SeleniumException("MalformedURLException{}", e);
        }
    }
}
