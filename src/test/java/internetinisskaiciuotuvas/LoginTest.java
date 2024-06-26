package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;
    private SkaiciuotuvasPage skaiciuotuvasPage;
    private RegisterPage registerPage;


    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
        skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Test
    void loginTest (){
        // create user
        String username = RandomNameGenerator.generateRandomName();
        String password = "password123.";
        loginPage.clickLinkRegister();
        registerPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .sendInputPasswordConfirm(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        skaiciuotuvasPage.clickLinkLogOut();

        // login
        loginPage.waitForToLoadPrisijungimas()
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();

        // assert
        assertEquals("Skaičiuotuvas", driver.getTitle(), "page title does not match");

        // logout
        skaiciuotuvasPage.clickLinkLogOut();
    }
    @Test
    void loginNegativeTest (){
        String username = "a";
        String password = "";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        assertTrue(loginPage.IsDisplayedErrorLogin(),"Login error is not displayed");
    }

}
