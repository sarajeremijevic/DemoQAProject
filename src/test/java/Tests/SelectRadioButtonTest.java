package Tests;

import Pages.ElementsPage;
import Pages.HomePage;
import Pages.RadioButtonPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class SelectRadioButtonTest {

    HomePage homePage;
    ElementsPage elementsPage;
    RadioButtonPage radioButtonPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        radioButtonPage = new RadioButtonPage();

        homePage.clickOnCard("Elements");
        elementsPage.clickOnRadioButtonCard();
    }

    @Test(priority = 1)
    public void selectYesRadioButton() {
        radioButtonPage.clickOnYesRadioButton();

        Assert.assertTrue(radioButtonPage.selectionMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.selectedOptionMessage.getText(), "Yes");
    }

    @Test(priority = 2)
    public void selectImpressiveRadioButton() {
        radioButtonPage.clickOnImpressiveRadioButton();

        Assert.assertTrue(radioButtonPage.selectionMessage.isDisplayed());
        Assert.assertEquals(radioButtonPage.selectedOptionMessage.getText(), "Impressive");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
