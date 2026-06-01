package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LinksPage extends BaseTest {

    public LinksPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Home")
    public WebElement homeHyperLink;

    @FindBy(linkText = "Created")
    public WebElement createdHyperLink;

    @FindBy(id = "linkResponse")
    public WebElement linkResponse;

    public void clickOnHomeHyperLink() {
        homeHyperLink.click();
    }

    public void clickOnCreatedHyperLink() {
        createdHyperLink.click();
    }
}
