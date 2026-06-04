package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.ThreadLocalRandom;

public class RegisterPage extends BaseTest {

    public RegisterPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstname")
    public WebElement firstNameField;

    @FindBy(id = "lastname")
    public WebElement lastNameField;

    @FindBy(id = "userName")
    public WebElement userNameField;

    @FindBy(id = "password")
    public WebElement passwordField;

    @FindBy(id = "register")
    public WebElement registerButton;

    @FindBy(id = "gotologin")
    public WebElement backToLoginButton;

    public void inputFirstName(String firstName) throws InterruptedException {
        typeLikeAHuman(firstNameField, firstName);
    }

    public void inputLastName(String lastName) throws InterruptedException{
        typeLikeAHuman(lastNameField, lastName);
    }

    public void inputUserName(String username) throws InterruptedException{
        typeLikeAHuman(userNameField, username);
    }

    public void inputPassword(String password) throws InterruptedException{
        typeLikeAHuman(passwordField, password);
    }

    public void clickOnRegisterButton() {
        registerButton.click();
    }

    public void clickOnBackToLogin() {
        backToLoginButton.click();
    }

    private void typeLikeAHuman(WebElement element, String text) throws InterruptedException {
        element.clear();

        for(char c: text.toCharArray()) {
            element.sendKeys(String.valueOf(c));
            int randomDelay = ThreadLocalRandom.current().nextInt(50, 100);
            Thread.sleep(randomDelay);
        }
    }
}
