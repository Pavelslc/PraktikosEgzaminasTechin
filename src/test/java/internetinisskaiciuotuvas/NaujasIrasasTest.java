package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class NaujasIrasasTest extends BaseTest{
    private LoginPage loginPage;
    private SkaiciuotuvasPage skaiciuotuvasPage;
    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
        skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
    }
    @Test
    void naujasIrasasTest (){
        // login
        String username = "User001";
        String password = "password123.";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        // enter values
        String pirmassSkaicius = "10";
        skaiciuotuvasPage.sendInputPirmasSkaicius(pirmassSkaicius);
    }
}
