package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckBoxPage extends BaseTest {

    public CheckBoxPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "rc-tree-checkbox")
    public WebElement checkBox;

    @FindBy(css = ".rc-tree-checkbox.rc-tree-checkbox-checked")
    public WebElement selectedCheckBox;

    @FindBy(id = "result")
    public WebElement resultText;

    @FindBy(css = ".rc-tree-switcher.rc-tree-switcher_close")
    public WebElement homeTreeNode;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div/div[2]/span[4]/span[2]")
    public WebElement desktopBoxTitle;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div/div[3]/span[4]/span[2]")
    public WebElement documentsBoxTitle;

    @FindBy(xpath = "/html/body/div[1]/div/div/div/div[2]/div[1]/div[1]/div[3]/div/div/div/div[4]/span[4]/span[2]")
    public WebElement downloadsBoxTitle;

    public void clickOnCheckBox () {
        checkBox.click();
    }

    public void clickOnHomeTreeNode() {
        homeTreeNode.click();
    }
}
