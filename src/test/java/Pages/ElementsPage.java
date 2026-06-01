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

    @FindBy(linkText = "Buttons")
    public WebElement buttonsCard;

    @FindBy (linkText = "Links")
    public WebElement linksCard;

    public void clickOnRadioButtonCard() {
        radioButtonCard.click();
    }

    public void clickOnWebTablesCard() {
        webTablesCard.click();
    }

    public void clickOnButtonsCard() {
        buttonsCard.click();
    }

    public void clickOnLinksCard() {
        linksCard.click();
    }
}
