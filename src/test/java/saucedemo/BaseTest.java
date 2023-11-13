package saucedemo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import internet.Constants;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import java.time.LocalDateTime;

import static internet.Constants.YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMATTER;

public class BaseTest {

    @BeforeSuite
    public void setup() {
        Configuration.baseUrl = internet.Constants.BASE_URL;
        Configuration.browserSize = internet.Constants.BROWSER_SIZE;
        Configuration.browser = internet.Constants.BROWSER;
        Configuration.browserVersion = internet.Constants.BROWSER_VERSION;
        Configuration.timeout = internet.Constants.TIMEOUT;
        Configuration.headless = internet.Constants.IS_HEADLESS;
        Configuration.reportsFolder = internet.Constants.REPORTS_FOLDER_PATH;
        Configuration.screenshots = false;
        Configuration.savePageSource = false;
    }

    @AfterMethod
    public void afterMethod(ITestResult testResult) {
        if (testResult.getStatus() != ITestResult.SUCCESS) {
            var currentDateTimeString = LocalDateTime.now().format(YEAR_MONTH_DAY_HOUR_MINUTE_SECOND_FORMATTER);
            //noinspection ResultOfMethodCallIgnored
            Selenide.screenshot(testResult.getMethod().getMethodName() + "-" + currentDateTimeString);
        }
        if (Selenide.webdriver().driver().hasWebDriverStarted()) Selenide.webdriver().driver().getWebDriver().quit();
    }

    public void visit(String url) {
        Selenide.open(Constants.BASE_URL + url);
    }
}
