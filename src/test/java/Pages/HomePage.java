package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "card-body")
    public List<WebElement> cardsList;

    public void clickOnCard(String cardName) {
        for (int i = 0; i < cardsList.size(); i++) {
            scrollToElement(cardsList.get(i));
            if(cardsList.get(i).getText().equals(cardName)) {
                cardsList.get(i).click();
                break;
            }
        }
    }
}
