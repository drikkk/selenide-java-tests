package internet.tests;

import internet.BaseTest;
import internet.pages.LoginPagePage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class LoginPage extends BaseTest {


    private  LoginPagePage loginPage;

    @BeforeClass
    public void setUp() {
        loginPage = new LoginPagePage();
    }


    @Test
    public void CanLogIn() {
        loginPage.open();


        loginPage
                .fillUsername("tomsmith")
                .fillPassword("SuperSecretPassword!");

        loginPage
                .clickLogin();


        String actualResultText = LoginPagePage.getResultText();

        String expectedResultText = "Welcome to the Secure Area. When you are done click logout below.";

        Assert.assertEquals(actualResultText, expectedResultText);
    }
}
