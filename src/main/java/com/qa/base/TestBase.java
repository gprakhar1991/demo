package com.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.util.TestUtil;

public class TestBase {

    protected static WebDriver driver;
    protected static Properties property = new Properties();
    private static final String CONFIG_FILE_PATH = "src/main/java/com/qa/config/config.properties";

    protected TestBase() {

        try {
            FileInputStream file = new FileInputStream(CONFIG_FILE_PATH);
            property.load(file);
        } catch (FileNotFoundException exception) {
            TestUtil.LOGGER.log(Level.SEVERE, "Configuration file is not loaded properly");
        } catch (IOException exception) {
            TestUtil.LOGGER.log(Level.SEVERE, "Some error occured in reading configuration file");
        }
    }

    public static void initBrowser(String url) {

        launchBrowser();

        driver.manage().window().maximize();

        driver.manage().deleteAllCookies();

        driver.manage().timeouts().implicitlyWait(TestUtil.WAIT_FOR_PAGE_LOAD, TimeUnit.SECONDS);

        driver.get(url);
    }

    private static void launchBrowser() {
        if (property.getProperty("BROWSER").equalsIgnoreCase("chrome")) {
            System.setProperty(property.getProperty("CHROME_KEY"), property.getProperty("CHROME_EXE_PATH"));
            driver = new ChromeDriver();
        }

    }

    public void selectValueFromDropdown(WebElement element, String value) {
        Select dropdown = new Select(element);
        dropdown.selectByValue(value);
    }

    public boolean isVisible(WebElement element) {
        boolean flag = false;
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(element));

        if (element.isDisplayed() || element.isEnabled()) {
            flag = true;
        }

        return flag;
    }

    public void setValue(WebElement element, String value) {
        element.clear();
        element.sendKeys(value);
    }

    public void click(WebElement element) {
        if (isVisible(element))
            element.click();
    }
}
