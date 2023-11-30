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
        var firstName = "FirstName";
        var lastName = "LastName";
        var postalCode = "12345";
        double expectedPrice, actualPrice;

    visit(shoppingPage.getUrl());

    shoppingPage
            .fillUsername(username)
            .fillPassword(password)
            .clickLogin();

    expectedPrice = shoppingPage.addCheapestItemToCart();

    visit(shoppingPage.getUrl());

    shoppingPage
            .goToCheckOut()
            .validateCart()
            .fillFirstName(firstName)
            .fillLastName(lastName)
            .fillPostalCode(postalCode)
            .proceedToPurchase();

    actualPrice = shoppingPage.confirmPurchase(expectedPrice);

    Assert.assertEquals(expectedPrice, actualPrice);

    }
}
