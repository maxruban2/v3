package uiTests;

import libs.ActionWithElement;
import libs.SetUpBrowser;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.WebDriver;
import pages.*;

import static libs.ConfigData.getCfgValue;


public class BaseTest extends SetUpBrowser {
    private WebDriver driver;
    private ActionWithElement action;
    protected BasePage basePage;
    protected MainPage mainPage;
    protected LoginPage loginPage;
    protected SparesPage sparesPage;
    protected EditSparePage editSparePage;
    private boolean isTestPassed = false;
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    private String baseUrl = getCfgValue("baseUrl");
    private Logger logger = Logger.getLogger(getClass());
//    String browser = System.getProperty("browser").toLowerCase();




    public void openV3(){
        driver.get(baseUrl);
    }

    @Rule
    public TestName testName = new TestName();

    @Before
    public void setUp(){

//        driver = new ChromeDriver();
        driver = setUpBrowser("remote");
        action = new ActionWithElement(driver);
        basePage = new BasePage(driver);
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        sparesPage = new SparesPage(driver);
        editSparePage = new EditSparePage(driver);

        logger.info(ANSI_GREEN + "TEST STARTED _____________________________________________ "+testName.getMethodName()+ ANSI_RESET);
        openV3();
    }


    public void checkAssertEquals(String message, Object expected, Object actual){
        Assert.assertEquals(message, expected,actual);
        isTestPassed=true;

    }

    @After
    public void tearDown(){
        if(isTestPassed) {
            System.out.println(ANSI_GREEN + "TEST PASSED !!! "+ANSI_GREEN_BACKGROUND + ANSI_BLACK +" +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++  " + ANSI_RESET +"  " + testName.getMethodName() );

        }else{
            System.out.println(ANSI_RED +"TEST FAILED !!! "+ANSI_RED_BACKGROUND +" - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -   " + ANSI_RESET + "  " + testName.getMethodName());
        }

        driver.quit();
    }

}
