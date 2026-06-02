package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

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

    @FindBy(className = "rc-tree-title")
    public List<WebElement> checkBoxTitleList;

    public void clickOnCheckBox () {
        checkBox.click();
    }

    public void clickOnHomeTreeNode() {
        homeTreeNode.click();
    }
}
