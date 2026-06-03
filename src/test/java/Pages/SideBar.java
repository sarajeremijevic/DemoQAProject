package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SideBar extends BaseTest {

    public SideBar() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "router-link")
    public List<WebElement> sideBarOptions;

    public void clickOnSideBarOption(String optionName) {
        for(int i = 0; i < sideBarOptions.size(); i++) {
            if(sideBarOptions.get(i).getText().equals(optionName)) {
                sideBarOptions.get(i).click();
                break;
            }
        }
    }
}
