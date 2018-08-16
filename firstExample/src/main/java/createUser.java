import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class createUser {
    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[1]/td[2]/p/input")
    private WebElement createUsername;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[2]/td[2]/p/input")
    private WebElement createPassword;

    @FindBy(xpath = "/html/body/table/tbody/tr/td[1]/form/div/center/table/tbody/tr/td[1]/div/center/table/tbody/tr[3]/td[2]/p/input")
    private WebElement createButton;

  private static String user;
    public static String getUser() {
        return user;
    }
    public static void setUser(String user) {
        createUser.user = user;
    }

    private static String pass;
    public static String getPass() {
        return pass;
    }
    public static void setPass(String pass) {
        createUser.pass = pass;
    }

    public void creating(){
        createUsername.sendKeys(user);
        createPassword.sendKeys(pass);
    }

    public void submit(){
        createButton.submit();
    }
}
