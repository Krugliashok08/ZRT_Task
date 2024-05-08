import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class Class {
    public static WebDriver driver;
    public static WebDriverWait wait;

    private final static String Login = "abcd11@mail.ru";
    private final static String Password = "Abcdef";

    public static String getLogin() {
        return Login;
    }

    public static String getPassword() {
        return Password;
    }

    @BeforeAll
    static void beforeTestConfigs() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("start-maximized");
        // chromeOptions.addArguments("headless");
        driver = new ChromeDriver(chromeOptions);
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    }

    @AfterAll
    static void afterTestConfigs() {
        driver.quit();
    }
}
