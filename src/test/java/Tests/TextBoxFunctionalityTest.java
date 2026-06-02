package Tests;

import Pages.ElementsPage;
import Pages.HomePage;
import Pages.TextBoxPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class TextBoxFunctionalityTest {

    HomePage homePage;
    ElementsPage elementsPage;
    TextBoxPage textBoxPage;

    String name = "Sara";
    String email = "sara@test.com";
    String currentAddress = "QA environment";
    String permanentAddress = "Production environment";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        textBoxPage = new TextBoxPage();

        homePage.clickOnCard("Elements");
        elementsPage.clickOnSideBarOption("Text Box");
    }

    @Test
    public void textBoxDataIsDisplayed() {
        textBoxPage.inputFullName(name);
        textBoxPage.inputEmail(email);
        textBoxPage.inputCurrentAddress(currentAddress);
        textBoxPage.inputPermanentAddress(permanentAddress);
        textBoxPage.clickOnSubmitButton();

        Assert.assertTrue(textBoxPage.textBoxDataList.get(0).isDisplayed());
        Assert.assertTrue(textBoxPage.textBoxDataList.get(0).getText().contains(name));

        Assert.assertTrue(textBoxPage.textBoxDataList.get(1).isDisplayed());
        Assert.assertTrue(textBoxPage.textBoxDataList.get(1).getText().contains(email));

        Assert.assertTrue(textBoxPage.textBoxDataList.get(2).isDisplayed());
        Assert.assertTrue(textBoxPage.textBoxDataList.get(2).getText().contains(currentAddress));

        Assert.assertTrue(textBoxPage.textBoxDataList.get(3).isDisplayed());
        Assert.assertTrue(textBoxPage.textBoxDataList.get(3).getText().contains(permanentAddress));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
