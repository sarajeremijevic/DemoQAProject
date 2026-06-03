package Tests;

import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class RegisterUserTest {

    HomePage homePage;
    SideBar sideBar;
    LoginPage loginPage;
    RegisterPage registerPage;
    ProfilePage profilePage;

    String firstName = "Sara";
    String lastName = "Test";
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
        registerPage = new RegisterPage();
        loginPage = new LoginPage();
        profilePage = new ProfilePage();

        homePage.clickOnCard("Book Store Application");
        sideBar.clickOnSideBarOption("Login");
        loginPage.clickOnNewUserButton();
    }

    @Test
    public void userCanRegister() throws InterruptedException {
        Thread.sleep(1000);
        registerPage.inputFirstName(firstName);
        Thread.sleep(500);
        registerPage.inputLastName(lastName);
        Thread.sleep(500);
        registerPage.inputUserName(username);
        Thread.sleep(500);
        registerPage.inputPassword(password);
        Thread.sleep(500);
        registerPage.clickOnRegisterButton();
        driver.navigate().refresh();

        registerPage.clickOnBackToLogin();
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        Thread.sleep(2000);

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        Assert.assertTrue(profilePage.profileUserName.getText().contains(username));
    }
}
