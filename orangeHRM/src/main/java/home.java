import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class home {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a")
    private WebElement PIM;

    @FindBy(id="menu_pim_addEmployee")
    private WebElement PIM_addEmployee;

    public void clickingPIM(){
        PIM.click();
    }

    public void clickingAddEmployee(){
        PIM_addEmployee.click();
    }
}
