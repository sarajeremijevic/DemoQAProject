package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WebTablesPage extends BaseTest {

    public WebTablesPage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addNewRecordButton")
    public WebElement addButton;

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "userEmail")
    public WebElement emailField;

    @FindBy(id = "age")
    public WebElement ageField;

    @FindBy(id = "salary")
    public WebElement salaryField;

    @FindBy(id = "department")
    public WebElement departmentField;

    @FindBy(id = "submit")
    public WebElement submitButton;

    public void clickOnAddButton() {
        addButton.click();
    }

    public void inputFirstName(String firstName) {
        firstNameField.clear();
        firstNameField.sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        lastNameField.clear();
        lastNameField.sendKeys(lastName);
    }

    public void inputEmailField(String email) {
        emailField.clear();
        emailField.sendKeys(email);
    }

    public void inputAge(String age) {
        ageField.clear();
        ageField.sendKeys(age);
    }

    public void inputSalary(String salary) {
        salaryField.clear();
        salaryField.sendKeys(salary);
    }

    public void inputDepartment(String department) {
        departmentField.clear();
        departmentField.sendKeys(department);
    }

    public void clickOnSubmitButton() {
        submitButton.click();
    }

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[1]")
    public WebElement firstNameCell;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[2]")
    public WebElement lastNameCell;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[4]")
    public WebElement emailCell;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[3]")
    public WebElement ageCell;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[5]")
    public WebElement salaryCell;

    @FindBy(xpath = "/html/body/div/div/div/div/div[2]/div[1]/div[2]/table/tbody/tr[4]/td[6]")
    public WebElement departmentCell;
}
