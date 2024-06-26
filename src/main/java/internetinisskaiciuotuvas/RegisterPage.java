package internetinisskaiciuotuvas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class RegisterPage extends BasePage{
    @FindBy (css = "#username")
    private WebElement inputUsername;
    @FindBy (css = "#password")
    private WebElement inputPassword;
    @FindBy (css = "#passwordConfirm")
    private WebElement inputPasswordConfirm;
    @FindBy (css = "[type='submit']")
    private WebElement buttonSubmit;


    public RegisterPage(WebDriver driver) {
        super(driver);
    }
    public RegisterPage sendInputUsername(String username) {
        wait.until(ExpectedConditions.visibilityOf(inputUsername));
        actions.click(inputUsername).sendKeys(username).perform();
        return this;
    }
    public RegisterPage sendInputPassword (String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPassword));
        actions.click(inputPassword).sendKeys(password).perform();
        return this;
    }
    public RegisterPage sendInputPasswordConfirm (String password) {
        wait.until(ExpectedConditions.visibilityOf(inputPasswordConfirm));
        actions.click(inputPasswordConfirm).sendKeys(password).perform();
        return this;
    }
    public void clickButtonSubmit () {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        actions.click(buttonSubmit).perform();
    }


}
