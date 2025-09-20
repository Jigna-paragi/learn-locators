package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AlertsPage;
import utils.BaseTest;

public class AlertsTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Handle simple JS Alert and verify result")
    public void testJsAlertAccept() {
        AlertsPage p = new AlertsPage(driver);
        p.open();

        // Trigger alert and verify its text, then accept
        p.clickJsAlert();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("I am a JS Alert"), "Alert text should mention 'I am a JS Alert'");
        driver.switchTo().alert().accept();

        // Verify result on page
        String result = p.getResultText(10);
        Assert.assertTrue(result.contains("You successfully clicked an alert"), "Expected success message after accepting alert");
    }

    @Test(groups = {"regression"}, description = "Handle JS Confirm (dismiss) and verify result")
    public void testJsConfirmDismiss() {
        AlertsPage p = new AlertsPage(driver);
        p.open();

        p.clickJsConfirm();
        String confirmText = driver.switchTo().alert().getText();
        Assert.assertTrue(confirmText.contains("I am a JS Confirm"), "Confirm text should mention 'I am a JS Confirm'");
        driver.switchTo().alert().dismiss();

        String result = p.getResultText(10);
        Assert.assertTrue(result.contains("You clicked: Cancel"), "Expected 'You clicked: Cancel' after dismissing confirm");
    }

    @Test(groups = {"regression"}, description = "Handle JS Prompt (send keys) and verify result")
    public void testJsPromptSendKeys() {
        AlertsPage p = new AlertsPage(driver);
        p.open();

        p.clickJsPrompt();
        var alert = driver.switchTo().alert();
        String promptText = alert.getText();
        Assert.assertTrue(promptText.contains("I am a JS prompt"), "Prompt text should mention 'I am a JS prompt'");

        // send keys and accept
        String input = "Selenium";
        alert.sendKeys(input);
        alert.accept();

        String result = p.getResultText(10);
        Assert.assertTrue(result.contains(input), "Result should contain the text sent to prompt: " + input);
    }
}
