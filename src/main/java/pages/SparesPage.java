package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SparesPage extends BasePage {

    @FindBy(xpath = "//span[@class='hidden-xs']")
    private WebElement userNameTagRight;
    @FindBy(xpath = "//a[@data-original-title='Add']")
    private WebElement addButton;
    @FindBy(xpath = "//input[@id='spares_spareName']")
    private WebElement spareNameField;
    @FindBy(xpath = "//select[@id='spares_spareType']")
    private WebElement spareTypeField;
    @FindBy(xpath = "//button[@name='add']")
    private WebElement addSpareButton;
    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteSpareButton;









    public SparesPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }


    public int countSparesByName(String spareName){
        List<WebElement> elements = driver.findElements(By.xpath("//td"));
        int count = 0;
        for(int i=0; i<elements.size(); i=i+1){
          if (elements.get(i).getText().equals(spareName)) count++;
        }
        return count;
    }

    public String [] getLastSpareNameAndType(){
        String [] lastSpare = new String[2];
        List<WebElement> elements = driver.findElements(By.xpath("//td"));
        int sizeOfList = elements.size();
        lastSpare[0] = elements.get(sizeOfList-2).getText();
        lastSpare[1] = elements.get(sizeOfList-1).getText();
        return lastSpare;

    }

    public void addSpare(String spareName, String spareType){
        action.clickElement(addButton);
        action.sendKeys(spareNameField, spareName);
//        spareNameField.sendKeys(spareName);
        Select selectType = new Select(spareTypeField);
        selectType.selectByVisibleText(spareType);
        action.clickElement(addSpareButton);

    }

    public void deleteLastSpareByName(String name){
        List<WebElement> elements = driver.findElements(By.xpath("//td"));
        int size = elements.size();
        action.clickElement(elements.get(size-2));
        if(spareNameField.getAttribute("value").equals(name)) {
            action.clickElement(deleteSpareButton);}
        wait.until(ExpectedConditions.visibilityOf(addButton));
        List<WebElement> elementsAfter = driver.findElements(By.xpath("//td"));
        int sizeAfter = elementsAfter.size();

        Assert.assertEquals("", size, sizeAfter+2);

    }



}
