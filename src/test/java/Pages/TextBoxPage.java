package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TextBoxPage extends BaseTest {

    public TextBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userName")
    public WebElement fullNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "currentAddress")
    public WebElement currentAddressField;

    @FindBy(id = "permanentAddress")
    public WebElement permanentAddressField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    @FindBy(className = "mb-1")
    public List<WebElement> textBoxDataList;

    public void inputFullName(String name) {
        fullNameField.clear();
        fullNameField.sendKeys(name);
    }

    public void inputEmail(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputCurrentAddress(String currentAddress) {
        currentAddressField.clear();
        currentAddressField.sendKeys(currentAddress);
    }

    public void inputPermanentAddress(String permanentAddress) {
        permanentAddressField.clear();
        permanentAddressField.sendKeys(permanentAddress);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }
}
