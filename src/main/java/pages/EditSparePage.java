package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.sql.rowset.BaseRowSet;

public class EditSparePage extends BasePage {
    @FindBy(xpath = "//input[@id='spares_spareName']")
    private WebElement spareNameField;
    @FindBy(xpath = "//select[@id='spares_spareType']")
    private WebElement spareTypeField;
    @FindBy(xpath = "//button[@name='add']")
    private WebElement addSpareButton;
    @FindBy(xpath = "//button[@name='delete']")
    private WebElement deleteSpareButton;


    public EditSparePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver,this);
    }


    public void addSpare(String spareName, int index){
        action.sendKeys(spareNameField, spareName);
        action.selectFromDropdown(spareTypeField, index);

//        Select selectType = new Select(spareTypeField);
//        selectType.selectByIndex(index);
        action.clickElement(addSpareButton);
    }

    public void checkNameAndDeleteSpare(String name) {
        if (spareNameField.getAttribute("value").equals(name)) {
            action.clickElement(deleteSpareButton);
        } else {
            Assert.fail("ERROR! Spare "+name+ " hasn't been deleted! WRONG NAME!");
        }
    }

}
