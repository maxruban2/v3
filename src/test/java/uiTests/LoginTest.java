package uiTests;


import org.junit.Assert;
import org.junit.Test;

import static libs.ConfigData.getCfgValue;

public class LoginTest extends BaseTest {
    String login = getCfgValue("userLogin");
    String password =getCfgValue("userPassword");






    @Test
    public void testLoginUser(){
    loginPage.loginUser(login, password);
    String name1 = mainPage.getUserNameTagLeft().getText();
    String name2 = mainPage.getUserNameTagRight().getText();

    Assert.assertEquals( "Wrong login name!",login, name1);
    Assert.assertEquals( "Wrong login name!",login, name2);

    }
}
