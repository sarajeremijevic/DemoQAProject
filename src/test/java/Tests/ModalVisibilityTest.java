package Tests;

import Pages.AlertsFrameAndWindowsPage;
import Pages.ElementsPage;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class ModalVisibilityTest {

    HomePage homePage;
    AlertsFrameAndWindowsPage alertsPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        alertsPage = new AlertsFrameAndWindowsPage();

        homePage.clickOnCard("Alerts, Frame & Windows");
        alertsPage.clickOnModalDialogsCard();
    }

    @Test
    public void modalButtonsDisplayPopUp() {
        alertsPage.clickOnSmallModalButton();

        Assert.assertEquals(alertsPage.smallModalButton.getText(), "Small modal");
        Assert.assertTrue(alertsPage.closeButton.isDisplayed());

        alertsPage.clickOnCloseSmallModalButton();

        alertsPage.clickOnLargeModalButton();

        Assert.assertEquals(alertsPage.largeModalButton.getText(), "Large modal");
        Assert.assertTrue(alertsPage.closeButton.isDisplayed());

        alertsPage.clickOnCloseLargeModalButton();

        Assert.assertTrue(alertsPage.smallModalButton.isDisplayed());
        Assert.assertTrue(alertsPage.largeModalButton.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
