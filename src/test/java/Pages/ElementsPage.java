package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ElementsPage extends BaseTest {

    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Radio Button")
    public WebElement radioButtonCard;

    @FindBy(linkText = "Web Tables")
    public WebElement webTablesCard;

    @FindBy(linkText = "Links")
    public WebElement linksCard;

    @FindBy(linkText = "Check Box")
    public WebElement checkBoxCard;

    @FindBy(linkText = "Text Box")
    public WebElement textBoxCard;

    public void clickOnRadioButtonCard() {
        radioButtonCard.click();
    }

    public void clickOnWebTablesCard() {
        webTablesCard.click();
    }

    public void clickOnLinksCard() {
        linksCard.click();
    }

    public void clickOnCheckBoxCard() {
        checkBoxCard.click();
    }

    public void clickOnTextBox() {
        textBoxCard.click();
    }
}
