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

    public void clickOnRadioButtonCard() {
        radioButtonCard.click();
    }
}
