package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.util.concurrent.TimeUnit;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.IE;

public class Hooks {

    public static WebDriver driver;

    @Before()
    public void runBrowser() {
        selectDriver();
    }

    @After()
    public void tearDownChrome(Scenario scenario) {
        embedScreenShotToScenario(scenario);
        defaultCloseAction();
    }

    private void selectDriver() {
        if (driver == null) {
            String os = System.getProperty("os.name").toLowerCase();
            ChromeOptions options = new ChromeOptions();

            if (os.contains("win")) {
                WebDriverManager.chromedriver().setup();
                options.addArguments("--disable-notifications");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("-—disable-gpu");
              //  options.addArguments("--headless");
                driver = new ChromeDriver(options);
                driver.manage().window().maximize();
                driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
                driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
            } else if (os.contains("nux") || os.contains("nix") || os.contains("aix")) {
                System.setProperty("webdriver.chrome.bin", "./drivers/chromedriver");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("enable-automation");
                options.addArguments("--headless");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--disable-gpu");
                options.addArguments("--no-sandbox");
                driver = new ChromeDriver(options);
                driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);
                driver.manage().timeouts().pageLoadTimeout(20000, TimeUnit.SECONDS);
            }
        }
    }

    public void defaultCloseAction() {
        driver.close();
        driver.quit();
        driver = null;
    }

    private void embedScreenShotToScenario(Scenario scenario) {
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, "image/png", "screenshot");
    }
}


