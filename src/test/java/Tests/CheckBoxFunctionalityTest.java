package Tests;

import Pages.CheckBoxPage;
import Pages.ElementsPage;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class CheckBoxFunctionalityTest {

    HomePage homePage;
    ElementsPage elementsPage;
    CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        checkBoxPage = new CheckBoxPage();

        homePage.clickOnCard("Elements");
        elementsPage.clickOnCheckBoxCard();
    }

    @Test
    public void selectHomeCheckBox() {
        checkBoxPage.clickOnCheckBox();
        Assert.assertTrue(checkBoxPage.selectedCheckBox.isDisplayed());
        Assert.assertTrue(checkBoxPage.resultText.isDisplayed());
    }

    @Test
    public void clickHomeTreeNode() {
        checkBoxPage.clickOnHomeTreeNode();
        Assert.assertTrue(checkBoxPage.desktopBoxTitle.isDisplayed());
        Assert.assertTrue(checkBoxPage.documentsBoxTitle.isDisplayed());
        Assert.assertTrue(checkBoxPage.downloadsBoxTitle.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
