package internet.pages;

import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selectors.*;


public class LoginPagePage {

   public LoginPagePage open() {
   Selenide.open("https://the-internet.herokuapp.com/login");
   return this;
   }

   public LoginPagePage fillUsername(String username) {
       Selenide.$(byName("username")).setValue(username);
       return this;
   }
   public LoginPagePage fillPassword(String password) {
       Selenide.$(byName("password")).setValue(password);
       return this;
   }
   public LoginPagePage clickLogin() {
       Selenide.$(By.cssSelector("button[type='submit']")).click();
       return this;

   }

    public static String getResultText() {
       return Selenide.$(By.cssSelector(".subheader")).getText();
    }
}