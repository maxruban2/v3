package tests;

import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;
import pages.SparesPage;




public class MainPageTest extends BaseTest{
    String login ="Student";
    String password = "909090";
    String spareName = "MaxSpare";
    String spareType = "Электроника";


    @Test
    public void addNewSparePart(){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginUser(login,password);
        MainPage mainPage = new MainPage(driver);
        mainPage.openSparePage();
        SparesPage sparesPage = new SparesPage(driver);
        int countSpare = (sparesPage.countSparesByName(spareName));
        sparesPage.addSpare(spareName,spareType);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int newCountSpare = (sparesPage.countSparesByName(spareName));

        Assert.assertEquals( countSpare, newCountSpare-1);
        String lastSpareName = sparesPage.getLastSpareNameAndType()[0];
        String lastSpareType = sparesPage.getLastSpareNameAndType()[1];
        Assert.assertEquals("Name is different!", lastSpareName, spareName);
        Assert.assertEquals("Type is different!", lastSpareType, spareType);

        sparesPage.deleteLastSpareByName(spareName);

    }
}
