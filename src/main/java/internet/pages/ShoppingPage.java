package internet.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import internet.interfaces.IPageObject;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class ShoppingPage implements IPageObject {


    @Override
    public String getUrl() {
        return "";
    }
    public ShoppingPage fillUsername(String username) {
        $(By.name("user-name")).setValue(username);
        return this;
    }
    public ShoppingPage fillPassword(String password) {
        $(By.name("password")).setValue(password);
        return this;
    }
    public ShoppingPage clickLogin() {
        $(By.name("login-button")).click();
        return this;
    }
    public ShoppingPage goToCheckOut() {
        $("shopping_cart_link").click();
        return this;
    }
    public ShoppingPage validateCart() {
        $("button#checkout").click();
        return this;
    
    }

    public ShoppingPage fillFirstName(String firstName) {
        $("input#first-name").setValue(firstName);
        return this;
    }
    public ShoppingPage fillLastName(String lastName) {
        $("input#last-name").setValue(lastName);
        return this;
    }
    public ShoppingPage fillPostalCode(String postalCode) {
        $("input#postal-code").setValue(postalCode);
        return this;
    }
    public ShoppingPage proceedToPurchase() {
        $("input#continue.submit-button").click();
        return this;
    }
    public double confirmPurchase(double expectedPrice) {
        double actualPrice;
        String finishTransactionButtonId = "button=finish";
        SelenideElement priceElement = $(".summary_subtotal_label");
        String htmlText = priceElement.text();
        String priceText = htmlText.replace("Item total: $", "");
        actualPrice = Double.parseDouble(priceText);
        return actualPrice;
    }

    public double addCheapestItemToCart() {
        ElementsCollection priceBars = $$(".pricebar");

        double minPrice = Double.MAX_VALUE;
        String addToCartButtonId = "";

        for (SelenideElement priceBar : priceBars) {
            SelenideElement priceElement = priceBar.find(".inventory_item_price");
            String priceText = priceElement.text().replace("$", "");
            double currentPrice = Double.parseDouble(priceText);

            if (currentPrice < minPrice) {
                minPrice = currentPrice;
                SelenideElement buttonElement = priceBar.find(".btn_inventory");
                addToCartButtonId = "#" + buttonElement.getAttribute("id");
            }
        }
        $(addToCartButtonId).click();
        return minPrice;
    }



    /*public ShoppingPage fillPostalCode() {
    }

    public ShoppingPage fillFirstName() {
    }*/
}
