package Tests;

import Pages.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    WebDriverWait wait;

    String firstName = "Sara";
    String lastName = "Test";
    String username = "demoqasara";
    String password = "Qwerty123!@#";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
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
        registerPage.inputLastName(lastName);
        registerPage.inputUserName(username);
        registerPage.inputPassword(password);
        registerPage.clickOnRegisterButton();
        driver.navigate().refresh();

        registerPage.clickOnBackToLogin();
        driver.navigate().refresh();
        loginPage.inputUserName(username);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        wait.until(ExpectedConditions.urlToBe("https://demoqa.com/profile"));

        Assert.assertEquals(driver.getCurrentUrl(), "https://demoqa.com/profile");
        Assert.assertTrue(profilePage.profileUserName.getText().contains(username));
    }
}
