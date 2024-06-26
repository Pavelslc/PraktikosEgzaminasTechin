package internetinisskaiciuotuvas;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    protected WebDriver driver;

    @BeforeEach
    void  setup(){
        driver = new ChromeDriver();
        driver.get("http://localhost:8080/prisijungti");
        driver.manage().window().maximize();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.waitForToLoadPrisijungimas();

    }
    @AfterEach
    void driverQuit(){
//        driver.quit();
    }

}
