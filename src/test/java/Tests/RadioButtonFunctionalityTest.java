package Tests;

import Pages.SideBar;
import Pages.HomePage;
import Pages.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class RadioButtonFunctionalityTest {

    HomePage homePage;
    SideBar sideBar;
    RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        radioButtonPage = new RadioButtonPage();

        homePage.clickOnCard("Elements");
        sideBar.clickOnSideBarOption("Radio Button");
    }

    @Test(priority = 1)
    public void yesRadioButtonCanBeSelected() {
        radioButtonPage.clickOnYesRadioButton();

        Assert.assertTrue(radioButtonPage.selectionMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.selectedOptionMessage.getText(), "Yes");
    }

    @Test(priority = 2)
    public void impressiveRadioButtonCanBeSelected() {
        radioButtonPage.clickOnImpressiveRadioButton();

        Assert.assertTrue(radioButtonPage.selectionMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.selectedOptionMessage.getText(), "Impressive");
    }
}
