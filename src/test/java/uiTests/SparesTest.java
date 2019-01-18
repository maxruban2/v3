package uiTests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import static libs.ConfigData.getCfgValue;





public class SparesTest extends BaseTest{
    String spareName = getCfgValue("spareName");
    String spareType = getCfgValue("spareType");
    int typeIndex = Integer.valueOf(getCfgValue("typeIndex"));
    String login = getCfgValue("userLogin");
    String password =getCfgValue("userPassword");



    @Test
    public void addNewSparePart(){

        loginPage.loginUser(login,password);
        mainPage.openSparePage();
        int countSpare = (sparesPage.countSparesByName(spareName));
        sparesPage.clickAddButton();
        editSparePage.addSpare(spareName, typeIndex);
        int countSpareAfter = (sparesPage.countSparesByName(spareName));

        Assert.assertEquals( countSpare, countSpareAfter-1);
        String lastSpareName = sparesPage.getLastSpareNameAndType()[0];
        String lastSpareType = sparesPage.getLastSpareNameAndType()[1];
        Assert.assertEquals("Name is different!", lastSpareName, spareName);
        checkAssertEquals("Name is different!", lastSpareName, spareName);
//      Assert.assertEquals("Type is different!", lastSpareType, spareType);

    }

    @After
    public void clearTest(){
        sparesPage.clickLastSpareFromList();
        editSparePage.checkNameAndDeleteSpare(spareName);
    }
}
