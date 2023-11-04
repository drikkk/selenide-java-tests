package internet.tests;

import internet.BaseTest;
import internet.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static org.openqa.selenium.By.xpath;

public class LoginTest extends BaseTest {

    @Test
    public void canLogin() {
        var loginPage = new LoginPage();
        var username = "tomsmith";
        var password = "SuperSecretPassword!";

        visit(loginPage.getUrl());

        loginPage
                .fillUsernameField(username);

        loginPage
                .fillPasswordField(password);

        loginPage
                .clickElement();

        String actualString = $(xpath("//div[contains(@class, 'flash') and contains(@class, 'success')]")).getText();

        String expectedString = "You logged into a secure area!";

        Assert.assertTrue(actualString.contains(expectedString));



    }


}
