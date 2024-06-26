package internetinisskaiciuotuvas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SkaiciuotiPage extends BasePage{

    public SkaiciuotiPage(WebDriver driver) {
        super(driver);
    }

    public SkaiciuotiPage waitForToLoadSkaiciuoti(){
        wait.until(ExpectedConditions.titleIs("Skaičiuoti"));
        return this;
    }
}
