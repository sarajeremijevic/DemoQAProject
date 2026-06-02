package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AlertsFrameAndWindowsPage extends BaseTest {

    public AlertsFrameAndWindowsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Modal Dialogs")
    public WebElement modalDialogsCard;

    @FindBy(id = "showSmallModal")
    public WebElement smallModalButton;

    @FindBy(id = "showLargeModal")
    public WebElement largeModalButton;

    @FindBy(id = "closeSmallModal")
    public WebElement closeSmallModalButton;

    @FindBy(id = "closeLargeModal")
    public WebElement closeLargeModalButton;

    @FindBy(className = "modal-header")
    public WebElement modalHeader;

    @FindBy(className = "btn-close")
    public WebElement closeButton;

    public void clickOnModalDialogsCard() {
        modalDialogsCard.click();
    }

    public void clickOnSmallModalButton() {
        smallModalButton.click();
    }

    public void clickOnLargeModalButton() {
        largeModalButton.click();
    }

    public void clickOnCloseSmallModalButton() {
        closeSmallModalButton.click();
    }

    public void clickOnCloseLargeModalButton() {
        closeLargeModalButton.click();
    }
}
