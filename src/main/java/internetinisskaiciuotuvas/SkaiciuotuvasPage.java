package internetinisskaiciuotuvas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkaiciuotuvasPage extends BasePage{
    public SkaiciuotuvasPage(WebDriver driver) {
        super(driver);
    }

    public SkaiciuotuvasPage waitForPageToLoadSkaiciuotuvas(){
        wait.until(ExpectedConditions.titleIs("Skaičiuotuvas"));
        return this;
    }
}
