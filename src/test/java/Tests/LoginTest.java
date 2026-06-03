package Tests;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.ProfilePage;
import Pages.SideBar;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class LoginTest {

    private static final Logger log = LoggerFactory.getLogger(LoginTest.class);
    HomePage homePage;
    SideBar sideBar;
    LoginPage loginPage;
    ProfilePage profilePage;

    String username = "sarademo1";
    String password = "Qwerty123!@#";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        sideBar = new SideBar();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        homePage.clickOnCard("Book Store Application");
        sideBar.clickOnSideBarOption("Login");
    }

    @Test
    public void userCanLogInAndLogOut() {
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        Assert.assertTrue(profilePage.profileUserName.getText().contains(username));

        profilePage.clickOnButton("Logout");
        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/login");
        Assert.assertTrue(loginPage.loginButton.isDisplayed());
    }
}
