package tests;


import org.junit.Assert;
import org.junit.Test;
import pages.LoginPage;
import pages.MainPage;

public class LoginTest extends BaseTest {
    String login ="Student";
    String password = "909090";




    @Test
    public void testLoginUser(){
    LoginPage loginPage = new LoginPage(driver);
    loginPage.loginUser(login, password);
    MainPage mainPage = new MainPage(driver);
    String name1 = mainPage.getUserNameTagLeft().getText();
    String name2 = mainPage.getUserNameTagRight().getText();

    Assert.assertEquals( "Wrong login name!",login, name1);
    Assert.assertEquals( "Wrong login name!",login, name2);

    }



}
