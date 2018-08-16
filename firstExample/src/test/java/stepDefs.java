import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

public class stepDefs {

    public static ExtentReports report;
    public ExtentTest test;

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\LocalInstall\\Drivers\\chromedriver.exe");
        report = new ExtentReports("C:\\Users\\Admin\\IdeaProjects\\cucumberTesting\\firstExample\\Report.html", true);
        driver = new ChromeDriver();

        test = report.startTest("Can register & log in");

        driver.manage().window().maximize();
        //test note
        test.log(LogStatus.INFO, "Browser maximised");
    }

    @After
    public  void teardown(){
        report.endTest(test);
        report.flush();
        driver.quit();
    }

    @Given("^correctly formatted deatils$")
    public void correctly_formatted_deatils() {
        createUser page = PageFactory.initElements(driver, createUser.class);
        page.setUser("Lauren");
        page.setPass("password");
        //test note
        test.log(LogStatus.INFO, "details correctly formatted");
    }

    @When("^i navigate to demosite\\.com$")
    public void i_navigate_to_demosite_com() {
       driver.get(constant.home);
        //test note
        test.log(LogStatus.INFO, "Homepage loaded");
    }

    @When("^I click create User$")
    public void i_click_create_User() {
        home page2 = PageFactory.initElements(driver, home.class);
        page2.addAUserLink();
        //test note
        test.log(LogStatus.INFO, "Create user page loaded");
    }

    @When("^I fill in the details$")
    public void i_fill_in_the_details()  {
        createUser page3 = PageFactory.initElements(driver, createUser.class);
        page3.creating();
        //test note
        test.log(LogStatus.INFO, "details correctly filled");
    }

    @When("^I click register$")
    public void i_click_register()  {
        createUser page4 = PageFactory.initElements(driver, createUser.class);
        page4.submit();
        //test note
        test.log(LogStatus.INFO, "registered");
    }

    @When("^I try to login$")
    public void i_try_to_login()  {
        login page5 = PageFactory.initElements(driver, login.class);
        page5.loggingIn();
        //test note
        test.log(LogStatus.INFO, "login page loaded and detailed filled");
    }

    @Then("^I am successfully logged in$")
    public void i_am_successfully_logged_in() {
        if (login.checkSuccessful.getText().equals("**Successful Login**")) {
            // report the test as a pass
            test.log(LogStatus.PASS, "Logged In");
        } else {
            test.log(LogStatus.FAIL, "Logged In");
        }

        Assert.assertEquals("**Successful Login**", login.checkSuccessful.getText());
    }
}
