import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class login {
    @FindBy(id="txtUsername")
    private WebElement username;

    @FindBy(id="txtPassword")
    private WebElement password;

    @FindBy(id="btnLogin")
    private WebElement loginButton;

    public void loggingIn(){
        username.sendKeys("Admin");
        password.sendKeys("AdminAdmin");
        loginButton.submit();
    }
}
