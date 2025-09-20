package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseTest;

public class HerokuLoginTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Verify user can log in with valid credentials")
    public void testValidLogin() {
        LoginPage login = new LoginPage(driver);

        // Navigate to login page from homepage
        login.open();

        // Perform login
        login.enterUsername("tomsmith");
        login.enterPassword("SuperSecretPassword!");
        login.clickLogin();

        // Validate success message
        String flash = login.getFlashText();
        Assert.assertTrue(
                flash.contains("You logged into a secure area!"),
                "Expected success message after login"
        );
    }
}
