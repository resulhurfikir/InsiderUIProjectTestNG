package Utilities;

import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxDriverService;
import org.testng.annotations.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseClass {

    public HomePage homePage;
    public CareersPage careersPage;
    public QualityAssurancePage qualityAssurancePage;
    public OpenPositionsPage openPositionsPage;
    public ApplicationPage applicationPage;

    @BeforeClass
    public void pages() {
        homePage = new HomePage();
        careersPage = new CareersPage();
        qualityAssurancePage = new QualityAssurancePage();
        openPositionsPage = new OpenPositionsPage();
        applicationPage = new ApplicationPage();
    }

    @BeforeClass
    @Parameters("browserType")
    public void driver(String browser){
        threadBrowserName.set(browser);
    }


    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();
    private static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();

    public static WebDriver getDriver() {

        Logger logger = Logger.getLogger("");
        logger.setLevel(Level.SEVERE);

        if (threadDriver.get() == null) {

            switch (threadBrowserName.get()) {

                case "chrome":
                    System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
                    threadDriver.set(new ChromeDriver());
                    break;

                case "firefox":
                    System.setProperty(FirefoxDriverService.LOG_NULL, "/dev/null");
                    threadDriver.set(new FirefoxDriver());
                    break;

                default:
                    System.out.println("Unknown browser type which you selected!");
                    threadDriver = null;
            }
        }

        assert threadDriver != null;
        threadDriver.get().manage().window().maximize();
        return threadDriver.get();
    }


    @AfterClass
    public void tearDown() {
        if (threadDriver.get() != null) {
            threadDriver.get().quit();
            threadDriver.set(null);
        }
    }

}



