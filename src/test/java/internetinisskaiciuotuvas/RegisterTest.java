package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterTest extends BaseTest {
    private LoginPage loginPage;
    private RegisterPage registerPage;
    private SkaiciuotuvasPage skaiciuotuvasPage;
    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
        registerPage = new RegisterPage(driver);
        skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
    }

    @Test
    void registerTest (){
        String username = "User002";
        String password = "password123.";
        String passwordConfirm = password;
        loginPage.clickLinkRegister();
        registerPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .sendInputPasswordConfirm(passwordConfirm)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        assertEquals("Skaičiuotuvas", driver.getTitle(), "page title does not match");

    }
}
