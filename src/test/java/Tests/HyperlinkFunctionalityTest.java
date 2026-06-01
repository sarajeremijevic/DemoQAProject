package Tests;

import Pages.ElementsPage;
import Pages.HomePage;
import Pages.LinksPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

import static Base.BaseTest.driver;

public class HyperlinkFunctionalityTest {

    HomePage homePage;
    ElementsPage elementsPage;
    LinksPage linksPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        linksPage = new LinksPage();

        homePage.clickOnCard("Elements");
        elementsPage.clickOnLinksCard();
    }

    @Test
    public void homeLinkRedirectsToHomepage() {
        String originalTab = driver.getWindowHandle();
        linksPage.clickOnHomeHyperLink();

        Set<String> allTabs = driver.getWindowHandles();
        Assert.assertEquals(allTabs.size(), 2);

        for(String tab: allTabs) {
            if(!tab.equals(originalTab)) {
                driver.switchTo().window(tab);
                break;
            }
        }

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/");
    }

    @Test
    public void createdLinkReturns201() {
        linksPage.clickOnCreatedHyperLink();
        Assert.assertTrue(linksPage.linkResponse.getText().contains("201"));
    }

}
