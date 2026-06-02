package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ElementsPage extends BaseTest {

    public ElementsPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "router-link")
    public List<WebElement> elementsSideBarOptions;

    public void clickOnSideBarOption(String optionName) {
        for(int i = 0; i < elementsSideBarOptions.size(); i++) {
            if(elementsSideBarOptions.get(i).getText().equals(optionName)) {
                elementsSideBarOptions.get(i).click();
                break;
            }
        }
    }
}
