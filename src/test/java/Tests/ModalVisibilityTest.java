package Tests;

import Pages.ModalDialogsPage;
import Pages.HomePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class ModalVisibilityTest {

    HomePage homePage;
    SideBar sideBar;
    ModalDialogsPage modalPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        modalPage = new ModalDialogsPage();

        homePage.clickOnCard("Alerts, Frame & Windows");
        sideBar.clickOnSideBarOption("Modal Dialogs");
    }

    @Test
    public void modalButtonsCanDisplayPopUp() {
        modalPage.clickOnSmallModalButton();

        Assert.assertEquals(modalPage.smallModalButton.getText(), "Small modal");
        Assert.assertTrue(modalPage.closeButton.isDisplayed());

        modalPage.clickOnCloseSmallModalButton();

        modalPage.clickOnLargeModalButton();

        Assert.assertEquals(modalPage.largeModalButton.getText(), "Large modal");
        Assert.assertTrue(modalPage.closeButton.isDisplayed());

        modalPage.clickOnCloseLargeModalButton();

        Assert.assertTrue(modalPage.smallModalButton.isDisplayed());
        Assert.assertTrue(modalPage.largeModalButton.isDisplayed());
    }
}
