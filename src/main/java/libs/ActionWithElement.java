package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ActionWithElement {
    private WebDriver driver;
    private WebDriverWait wait;
    private Logger logger;



    public ActionWithElement(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        logger = Logger.getLogger(getClass());

    }


    public void clickElement(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        try{
            element.click();
            logger.info("Clicked on element");
        }catch(Exception e){
            logger.error("ERROR! Couldn't click on element: " +e);
            Assert.fail("ERROR! Couldn't click on element: " +e);
        }

    }

    public void sendKeys(WebElement element, String string){
        wait.until(ExpectedConditions.visibilityOf(element));
        try{
            element.sendKeys(string);
            logger.info("Entered text: "+ string);
        }catch(Exception e){
            logger.error("ERROR! Couldn't enter text: "+string+"   "+e);
            Assert.fail("ERROR! Couldn't enter text: "+string+"   "+e);
        }

    }

    public void assertElementIsDisplayed(WebElement element){
        try{
            Assert.assertEquals(true, element.isDisplayed());
            logger.info("Element is displayed!");
        }catch(Exception e){
            logger.error("Element is not displayed: "+e);
        }

    }

    public void selectFromDropdown(WebElement select, int index){
        try {
            Select selectType = new Select(select);
            selectType.selectByIndex(index);
            logger.info("Selected index: " + index + " from drop-down ");
        }catch(Exception e){
            logger.info("Selection of index: "+ index+" FAILED! "+e);
        }
    }






}
