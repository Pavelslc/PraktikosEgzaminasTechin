package internetinisskaiciuotuvas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest{
    private LoginPage loginPage;

    @BeforeEach
    void loginTestSetup() {
        loginPage = new LoginPage(driver);
    }

//    @Test
//    void loginTest (){
//        String username = "User001";
//        String password = "password123.";
//        String passwordConfirm = password;
//        loginPage.clickLinkRegister();
//        registerPage
//                .sendInputUsername(username)
//                .sendInputPassword(password)
//                .sendInputPasswordConfirm(passwordConfirm)
//                .clickButtonSubmit();
//    }
}
