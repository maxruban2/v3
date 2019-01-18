package testSuits;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import uiTests.LoginTest;
import uiTests.SparesTest;

@RunWith(Suite.class)
@Suite.SuiteClasses(
        {
                LoginTest.class,
                SparesTest.class


        }
)
public class SmokeSuit {

}
