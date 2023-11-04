package internet.pages;

import com.codeborne.selenide.Condition;
import internet.interfaces.IPageObject;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage implements IPageObject {
    @Override
    public String getUrl() {
        return "/login";
    }

    public LoginPage fillUsernameField(String value) {
        $("input#username").setValue(value);
        return this;
    }

    public LoginPage fillPasswordField(String value) {
        $("input#password").setValue(value);
        return this;

    }

    public LoginPage clickElement() {
        $("button[type='submit']").click();
        return this;

    }

}
