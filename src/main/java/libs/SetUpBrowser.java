package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.URL;

public class SetUpBrowser extends SauceLabsSettings{



    public static WebDriver setUpBrowser(String browser){
        if (browser.equals("chrome")) {//|| browser == null){
            File file= new File("src/main/drivers/chromedriver");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            // download firefox
            File file = new File("cd");
            System.setProperty("webdriver.gecko.driver", file.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0);
            profile.addPreference("browser.startup.homepage_override.mstone"
                    , "ignore"); // Suppress the "What's new" page
            driver = new FirefoxDriver();
        }else if(browser.equals("safari")){
            // safari
        }else if(browser.equals("remote")){
            driver = setUpSauceLabs();
//            driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
        }
        return driver;

    }
}
