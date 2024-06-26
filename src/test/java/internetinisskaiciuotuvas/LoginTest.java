package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private SkaiciuotuvasPage skaiciuotuvasPage;


    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
        skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
    }

    @Test
    void loginTest (){
        String username = "User001";
        String password = "password123.";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        assertEquals("Skaičiuotuvas", driver.getTitle(), "page title does not match");
        skaiciuotuvasPage.clickLinkLogOut();
    }
    @Test
    void loginNegativeTest (){
        String username = "User001";
        String password = "";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        assertTrue(loginPage.IsDisplayedErrorLogin(),"Login error is not displayed");
    }

}
