package tests;

import libs.ActionWithElement;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.BasePage;
import pages.MainPage;



public class BaseTest {
    protected WebDriver driver;
    private ActionWithElement action;
    private BasePage basePage;
    private MainPage mainPage;
    Logger logger = Logger.getLogger(getClass());



    public void openV3(){
        driver.get("http://v3.test.itpmgroup.com");
    }

    @Rule

    public TestName testName = new TestName();

    @Before
    public void setUp(){
        logger.info("TEST STARTED _____________________________________________"+testName.getMethodName());
        driver = new ChromeDriver();
        action = new ActionWithElement(driver);
        openV3();







    }

    @After
    public void tearDown(){
        driver.quit();

    }




}
