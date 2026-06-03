package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProfilePage extends BaseTest {

    public ProfilePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".btn.btn-primary")
    public List<WebElement> profileButtonList;

    @FindBy(id = "userName-value")
    public WebElement profileUserName;

    public void clickOnButton(String buttonName) {
        for(int i = 0; i < profileButtonList.size(); i++) {
            if(profileButtonList.get(i).getText().equals(buttonName)) {
                profileButtonList.get(i).click();
                break;
            }
        }
    }
}
