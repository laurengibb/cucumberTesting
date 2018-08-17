import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class employees {

    @FindBy(id="firstName")
    private WebElement employeeFirstName;

    @FindBy(id="middleName")
    private WebElement employeeMiddleName;

    @FindBy(id="lastName")
    private WebElement employeeLastName;

    @FindBy(id="employeeId")
    public WebElement employeeID;

    @FindBy(xpath = "//*[@id=\"location_inputfileddiv\"]/div/input")
    private WebElement employeeLocationDropdown;

    @FindBy(xpath = "//*[@id=\"pimAddEmployeeForm\"]/div[1]/div/materializecss-decorator[3]/div/sf-decorator/div/label")
    private WebElement createLoginDetails;

    @FindBy(id="username")
    private WebElement employeeUsername;

    @FindBy(id="password")
    private WebElement employeePassword;

    @FindBy(id="confirmPassword")
    private WebElement employeeConfirmPassword;

    @FindBy(xpath = "//*[@id=\"adminRoleId_inputfileddiv\"]/div/input")
    private WebElement employeeAdminID;

    @FindBy(xpath = "//*[@id=\"systemUserSaveBtn\"]")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"menu_pim_viewEmployeeList\"]")
    private WebElement viewEmployeesButton;

    @FindBy(id="employee_name_quick_filter_employee_list_value")
    private WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"right-side\"]/header/div/nav/div/div/ul[2]/li[2]/a")
    private WebElement searchButton;

    String id;

    public void enterEmployeeDetails(){
        employeeFirstName.sendKeys("Jane");
        employeeMiddleName.sendKeys("");
        employeeLastName.sendKeys("Doe");
        employeeLocationDropdown.click();
        employeeLocationDropdown.sendKeys(Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.ENTER);
        id = employeeID.getText();
    }

    public void clickingCreateLogin(){
        createLoginDetails.click();
    }

    public void createLogin(){
        employeeUsername.sendKeys("JaneDoe20");
        employeePassword.sendKeys("fdghjJKHKJH564!!!DFDJ");
        employeeConfirmPassword.sendKeys("fdghjJKHKJH564!!!DFDJ");
        employeeAdminID.click();
        employeeAdminID.sendKeys(Keys.DOWN, Keys.ENTER);
    }

    public void save(){
        saveButton.click();
    }

    public void searchEmployees(){
        viewEmployeesButton.click();
        searchBar.sendKeys(id);
        searchButton.click();
    }

}
