package internetinisskaiciuotuvas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AtliktosOperacijosPage extends SkaiciuotuvasPage{
@FindBy (xpath = "//table[@class='table table-striped']//tr[last()]/td[4]")
    private WebElement paskutinioIrasoSuma;

    public AtliktosOperacijosPage(WebDriver driver) {
        super(driver);
    }
    public String getPaskutinioIrasoSuma(){
        return paskutinioIrasoSuma.getText();
    }
}
