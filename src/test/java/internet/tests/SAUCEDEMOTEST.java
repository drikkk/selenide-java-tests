package internet.tests;

import internet.BaseTest;
import internet.pages.ShoppingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SAUCEDEMOTEST extends BaseTest {

    @Test
    public void loginTest() {
        var shoppingPage = new ShoppingPage();
        var username = "standard_user";
        var password = "secret_sauce";
        var firstname = "FirstName";

        var firstName = "FirstName";
        var lastName = "LastName";
        var postalCode = "12345";
        double expectedPrice, actualPrice;

    visit(ShoppingPage.getUrl());
    ShoppingPage
            .fillUsername(username)
            .fillPassword(password)
            .clickLogin();

    expectedPrice = shoppingPage.addCheapestItemToCart();

    visit(ShoppingPage.getUrl());
            .goToCheckOut()
            .validateCart()
            .fillFirstName()
            .fillLastName(lastName)
            .fillPostalCode()
            .proceedToPurchase();

    actualPrice = shoppingPage.confirmPurchase(expectedPrice);
        Assert.assertEquals(expectedPrice, actualPrice);

    }

    private ShoppingPage goToCheckOut() {
    }
}
