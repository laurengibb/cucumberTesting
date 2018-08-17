import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class stepDefs {

    public static ExtentReports report;
    public ExtentTest test;

    WebDriver driver;

    home homePage;
    employees employeesPage;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\LocalInstall\\Drivers\\chromedriver.exe");
        report = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\cucumberTesting\\orangeHRM\\Report.html", true);
        driver = new ChromeDriver();

        test = report.startTest("Adding an employee to the CRM");

        driver.manage().window().maximize();
        //test note
        test.log(LogStatus.INFO, "Browser maximised");
    }

    @After
    public void teardown(){
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    @Given("^the login page$")
    public void the_login_page()  {
        driver.get(constant.login);
        //test note
        test.log(LogStatus.INFO, "Login page loaded");
    }

    @When("^I login$")
    public void i_login() {
        login loginPage = PageFactory.initElements(driver, login.class);
        loginPage.loggingIn();
        //test note
        test.log(LogStatus.INFO, "User logged in");
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() {
        homePage = PageFactory.initElements(driver, home.class);
        homePage.clickingPIM();
        //test note
        test.log(LogStatus.INFO, "PIM tab opened");
    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() {
        WebElement myDynamicElement = (new WebDriverWait(driver, 10)) .until(ExpectedConditions.presenceOfElementLocated(By.id("menu_pim_addEmployee")));
        homePage = PageFactory.initElements(driver, home.class);
        homePage.clickingAddEmployee();
        //test note
        test.log(LogStatus.INFO, "Add Employee pop up loaded");
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() {
        WebElement myDynamicElement = (new WebDriverWait(driver, 30)) .until(ExpectedConditions.presenceOfElementLocated(By.id("firstName")));
        employeesPage = PageFactory.initElements(driver, employees.class);
        employeesPage.enterEmployeeDetails();
        //test note
        test.log(LogStatus.INFO, "New Employee details entered");
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
        employeesPage = PageFactory.initElements(driver, employees.class);
        employeesPage.clickingCreateLogin();
        //test note
        test.log(LogStatus.INFO, "Create Login Details clicked");
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        employeesPage = PageFactory.initElements(driver, employees.class);
        employeesPage.createLogin();
       //test note
       test.log(LogStatus.INFO, "Login Details created");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() {
        employeesPage = PageFactory.initElements(driver, employees.class);
        employeesPage.save();
        //test note
        test.log(LogStatus.INFO, "New employee created");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() {
        employeesPage = PageFactory.initElements(driver, employees.class);
        employeesPage.searchEmployees();
        //test note
        test.log(LogStatus.INFO, "Searched for new employee");
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
