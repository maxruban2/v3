package pages;

import libs.ActionWithElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected ActionWithElement action;
    protected WebDriverWait wait;



    public BasePage(WebDriver driver) {

        this.driver = driver;
        this.action = new ActionWithElement(driver);
        wait = new WebDriverWait(driver, 5);

    }
}
