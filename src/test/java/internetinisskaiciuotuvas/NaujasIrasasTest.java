package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class NaujasIrasasTest extends BaseTest {
    private LoginPage loginPage;
    private SkaiciuotuvasPage skaiciuotuvasPage;
    private SkaiciuotiPage skaiciuotiPage;
    private AtliktosOperacijosPage atliktosOperacijosPage;

    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
        skaiciuotuvasPage = new SkaiciuotuvasPage(driver);
        skaiciuotiPage = new SkaiciuotiPage(driver);
        atliktosOperacijosPage = new AtliktosOperacijosPage(driver);
    }

    @Test
    void naujasIrasasTest() {
        // login
        String username = "User001";
        String password = "password123.";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        // enter values
        String pirmasSkaicius = "30";
        String antrasSkaicius = "5";
        String operacijosZenklas = "*";

        skaiciuotuvasPage
                .sendInputPirmasSkaicius(pirmasSkaicius)
                .sendInputAntrasSkaicius(antrasSkaicius)
                .selectOptionOperaciojosZenklas(operacijosZenklas)
                .clickButtonSubmit();
        skaiciuotiPage.waitForToLoadSkaiciuoti().clickLinkAtliktosOperacijos();
        // assert
        String expectedResult = "150";
        String actualResult = atliktosOperacijosPage.getPaskutinioIrasoSuma();
        assertEquals(expectedResult, actualResult, "skaičiavimo rezultatai nesutampa");
        skaiciuotuvasPage.clickLinkLogOut();
    }

    @Test
    void naujasIrasasNegativeTest() {
        // login
        String username = "User001";
        String password = "password123.";
        loginPage
                .sendInputUsername(username)
                .sendInputPassword(password)
                .clickButtonSubmit();
        skaiciuotuvasPage.waitForPageToLoadSkaiciuotuvas();
        // enter values
        String pirmasSkaicius = "";
        String antrasSkaicius = "";
        String operacijosZenklas = "+";

        skaiciuotuvasPage
                .sendInputPirmasSkaicius(pirmasSkaicius)
                .sendInputAntrasSkaicius(antrasSkaicius)
                .selectOptionOperaciojosZenklas(operacijosZenklas)
                .clickButtonSubmit();
        assertTrue(skaiciuotiPage.isDisplayedErrorFailedToCalculate(), "Error is not displayed");
        skaiciuotuvasPage.clickLinkLogOut();
    }
}
