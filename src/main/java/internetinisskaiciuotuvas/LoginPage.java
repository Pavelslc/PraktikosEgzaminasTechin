package internetinisskaiciuotuvas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage{
    @FindBy (css = "#username")
    private WebElement inputUsername;
    @FindBy (css = "#password")
    private WebElement inputPassword;
    @FindBy (css = "[type='submit']")
    private WebElement buttonSubmit;
    @FindBy (css = "h4.text-center a")
    private WebElement lingRegister;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public LoginPage sendInputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(inputUsername));
        actions.click(inputUsername).sendKeys(username).perform();
        return this;
    }
    public LoginPage sendInputPassword (String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        actions.click(inputPassword).sendKeys(password).perform();
        return this;
    }
    public void clickButtonSubmit () {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        actions.click(buttonSubmit).perform();
    }
    public void clickLinkRegister(){
    wait.until(ExpectedConditions.elementToBeClickable(lingRegister));
        lingRegister.click();
    }
}
