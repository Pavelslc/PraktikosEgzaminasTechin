package internetinisskaiciuotuvas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class SkaiciuotuvasPage extends BasePage{
    @FindBy(css = "#sk1")
    private WebElement inputPirmasSkaicius;
    @FindBy(css = "#sk2")
    private WebElement inputAntrasSkaicius;
    @FindBy (css = "#logoutForm ~ a")
    private WebElement linkLogOut;
    @FindBy (css = "[type='submit']")
    private WebElement buttonSubmit;
    @FindBy (css = "[href='/skaiciai']")
    protected WebElement linkAtliktosOperacijos;
    @FindBy (xpath = "//span[@class='error']")
    protected WebElement errorFailedToCalculate;


    public SkaiciuotuvasPage(WebDriver driver) {
        super(driver);
    }

    public SkaiciuotuvasPage waitForPageToLoadSkaiciuotuvas(){
        wait.until(ExpectedConditions.titleIs("Skaičiuotuvas"));
        return this;
    }
    public SkaiciuotuvasPage sendInputPirmasSkaicius(String skaicius) {
        wait.until(ExpectedConditions.visibilityOf(inputPirmasSkaicius));
        actions.click(inputPirmasSkaicius).sendKeys(Keys.BACK_SPACE).sendKeys(skaicius).perform();
        return this;
    }
    public SkaiciuotuvasPage sendInputAntrasSkaicius(String skaicius) {
        wait.until(ExpectedConditions.visibilityOf(inputAntrasSkaicius));
        actions.click(inputAntrasSkaicius).sendKeys(Keys.BACK_SPACE).sendKeys(skaicius).perform();
        return this;
    }
    public SkaiciuotuvasPage selectOptionOperaciojosZenklas(String zenklas){
        Select selectOperacijosZenklas = new Select(driver.findElement(By.cssSelector("[name='zenklas']")));
        selectOperacijosZenklas.selectByValue(zenklas);
        return this;
    }
    public void clickButtonSubmit () {
        wait.until(ExpectedConditions.elementToBeClickable(buttonSubmit));
        actions.click(buttonSubmit).perform();
    }
    public void clickLinkAtliktosOperacijos(){
        linkAtliktosOperacijos.click();
    }
    public void clickLinkLogOut(){
        linkLogOut.click();
    }
    public boolean isDisplayedErrorFailedToCalculate() {
        return errorFailedToCalculate.isDisplayed();
    }

}
