package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends BasePage {

    @FindBy(xpath = "//span[@class='hidden-xs']")
    private WebElement userNameTagRight;
    @FindBy(xpath = "//div[@class='pull-left info']/p")
    private WebElement userNameTagLeft;

    @FindBy(xpath = "//li[@id='dictionary']/a")
    private WebElement dictionaryTab;
    @FindBy(xpath = "//li[@id='spares']/a")
    private WebElement spareOption;

//    @FindBy(xpath = "//div[@class='pull-left info']/p")
//    private WebElement userNameTagLeft;
//    @FindBy(xpath = "//div[@class='pull-left info']/p")
//    private WebElement userNameTagLeft;
//    @FindBy(xpath = "//div[@class='pull-left info']/p")
//    private WebElement userNameTagLeft;
//    @FindBy(xpath = "//div[@class='pull-left info']/p")
//    private WebElement userNameTagLeft;



    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void openSparePage(){
        action.clickElement(dictionaryTab);
        action.clickElement(spareOption);
    }

    public WebElement getUserNameTagRight() {
        return userNameTagRight;
        
    }

    public WebElement getUserNameTagLeft() {
        return userNameTagLeft;
    }


}
