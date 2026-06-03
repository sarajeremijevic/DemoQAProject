package Tests;

import Pages.CheckBoxPage;
import Pages.SideBar;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class CheckBoxFunctionalityTest {

    HomePage homePage;
    SideBar sideBar;
    CheckBoxPage checkBoxPage;

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        checkBoxPage = new CheckBoxPage();

        homePage.clickOnCard("Elements");
        sideBar.clickOnSideBarOption("Check Box");
    }

    @Test
    public void homeCheckBoxCanBeSelected() {
        checkBoxPage.clickOnCheckBox();
        Assert.assertTrue(checkBoxPage.selectedCheckBox.isDisplayed());
        Assert.assertTrue(checkBoxPage.resultText.isDisplayed());
    }

    @Test
    public void homeTreeNodeCanExpand() {
        checkBoxPage.clickOnHomeTreeNode();
        Assert.assertTrue(checkBoxPage.checkBoxTitleList.get(1).isDisplayed());
        Assert.assertTrue(checkBoxPage.checkBoxTitleList.get(2).isDisplayed());
        Assert.assertTrue(checkBoxPage.checkBoxTitleList.get(3).isDisplayed());
    }

}
