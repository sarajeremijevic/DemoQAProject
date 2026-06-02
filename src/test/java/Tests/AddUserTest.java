package Tests;

import Pages.ElementsPage;
import Pages.HomePage;
import Pages.WebTablesPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

import static Base.BaseTest.driver;

public class AddUserTest {

    HomePage homePage;
    ElementsPage elementsPage;
    WebTablesPage webTablesPage;

    String firstName = "Sara";
    String lastName = "Test";
    String email = "test@testing.com";
    String age = "26";
    String salary = "11945";
    String department = "QA";

    @BeforeMethod
    public void pageSetUp() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
        driver.navigate().to("https://demoqa.com/");

        homePage = new HomePage();
        elementsPage = new ElementsPage();
        webTablesPage = new WebTablesPage();

        homePage.clickOnCard("Elements");
        elementsPage.clickOnSideBarOption("Web Tables");
    }

    @Test
    public void userCanBeAdded() {
        webTablesPage.clickOnAddButton();
        webTablesPage.inputFirstName(firstName);
        webTablesPage.inputLastName(lastName);
        webTablesPage.inputEmailField(email);
        webTablesPage.inputAge(age);
        webTablesPage.inputSalary(salary);
        webTablesPage.inputDepartment(department);
        webTablesPage.clickOnSubmitButton();


    }
}
