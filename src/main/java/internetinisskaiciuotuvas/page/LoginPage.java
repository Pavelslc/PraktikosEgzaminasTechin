package internetinisskaiciuotuvas.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy (css = "h4.text-center a")
    WebElement lingRegister;
    public LoginPage(WebDriver driver) {
        super(driver);
    }


}
