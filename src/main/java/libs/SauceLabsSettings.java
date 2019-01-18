package libs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static libs.ConfigData.getCfgValue;

public class SauceLabsSettings {
    public static final String USERNAME = getCfgValue("USER_NAME");
    public static final String ACCESS_KEY = getCfgValue("ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";
    protected static WebDriver driver;

    public static WebDriver setUpSauceLabs(){
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("platform", "Windows 10");
        caps.setCapability("version", "latest");

        try {
             driver = new RemoteWebDriver(new URL(URL), caps);
        }catch(MalformedURLException e){
            // add logger +e
        }
        return driver;
    }
}
