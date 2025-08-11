package pages.components;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import pages.MainPage;
import utils.DataFaker;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class AuthorizationModalComponent {

    MainPage mainPage = new MainPage();

    DataFaker faker = new DataFaker();

    private final SelenideElement inputProfileModalEmail = $$("input.el-input__inner").get(0),
            inputProfileModalPassword = $$("input.el-input__inner").get(1),
            loginConfirmButton = $("div.login__action-block button"),
            uncorrectedEmailModalText = $$("div.el-form-item__error").get(0),
            uncorrectedPasswordModalText = $$("div.el-form-item__error").get(1),
            failedAuthorizationMessage = $("div.el-message--error");

    private final String randomEmail = faker.getRandomEmail(),
            randomPassword = faker.getRandomPassword(),
            randomLine = faker.getRandomLine();

    @Step("В модальном окне авторизации вводим email")
    public AuthorizationModalComponent setInputProfileModalEmail(String value) {
        inputProfileModalEmail.setValue(value);

        return this;
    }

    @Step("В модальном окне авторизации вводим password")
    public AuthorizationModalComponent setInputProfileModalPassword(String value) {
        inputProfileModalPassword.setValue(value);

        return this;
    }

    @Step("В модальном окне авторизации жмем на кнопку 'Подтвердить'")
    public AuthorizationModalComponent loginConfirmButtonClick() {
        loginConfirmButton.click();

        return this;
    }

    @Step("В модальном окне авторизации вводим некорректный password")
    public AuthorizationModalComponent setUncorrectedInputProfilePassword() {
        inputProfileModalPassword.setValue(randomLine);
        inputProfileModalPassword.sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.BACK_SPACE);

        return this;
    }

    @Step("В модальном окне авторизации вводим некорректный email")
    public AuthorizationModalComponent setUncorrectedInputProfileEmail() {
        inputProfileModalEmail.setValue(randomLine);

        return this;
    }

    @Step("В модальном окне авторизации вводим рандомный email")
    public AuthorizationModalComponent setFailedInputProfileEmail() {
        inputProfileModalEmail.setValue(randomEmail);

        return this;
    }

    @Step("В модальном окне авторизации вводим рандомный password")
    public AuthorizationModalComponent setFailedInputProfilePassword() {
        inputProfileModalPassword.setValue(randomPassword);

        return this;
    }

    @Step("Проверяем, что появилось сообщение 'Пожалуйста введите корректный email'")
    public AuthorizationModalComponent checkEmailFieldShouldBeUncorrectedText() {
        uncorrectedEmailModalText.shouldBe(text("Пожалуйста введите корректный email"));

        return this;
    }

    @Step("Проверяем, что появилось сообщение 'Это поле обязательно для заполнения'")
    public AuthorizationModalComponent checkPasswordFieldShouldBeUncorrectedText() {
        uncorrectedPasswordModalText.shouldBe(text("Это поле обязательно для заполнения"), Duration.ofSeconds(10));

        return this;
    }

    @Step("Проверяем, что в модальном окне кнопка 'Подтвердить' некликабельна")
    public AuthorizationModalComponent checkLoginConfirmButtonDisabled() {
        loginConfirmButton.shouldBe(disabled);

        return this;
    }

    @Step("Проверяем, что появился message о неккоректном вводе данных")
    public AuthorizationModalComponent checkFailedAuthorizationMessageVisible() {
        failedAuthorizationMessage.shouldBe(visible, Duration.ofSeconds(2));
        failedAuthorizationMessage.shouldBe(text("Неверные данные для входа"));

        return this;
    }
}
