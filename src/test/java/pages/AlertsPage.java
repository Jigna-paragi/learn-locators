package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertsPage {
    private final WebDriver driver;
    private final By alertsLink = By.linkText("JavaScript Alerts");
    private final By jsAlertBtn = By.xpath("//button[text()='Click for JS Alert']");
    private final By jsConfirmBtn = By.xpath("//button[text()='Click for JS Confirm']");
    private final By jsPromptBtn = By.xpath("//button[text()='Click for JS Prompt']");
    private final By result = By.id("result");

    public AlertsPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Navigate to JavaScript Alerts page from homepage */
    public void open() {
        driver.findElement(alertsLink).click();
    }

    public void clickJsAlert() {
        driver.findElement(jsAlertBtn).click();
    }

    public void clickJsConfirm() {
        driver.findElement(jsConfirmBtn).click();
    }

    public void clickJsPrompt() {
        driver.findElement(jsPromptBtn).click();
    }

    /**
     * Wait for the result message to appear and return its trimmed text.
     * Use after interacting with an alert (accept/dismiss/sendKeys).
     */
    public String getResultText(int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        WebElement el = wait.until(ExpectedConditions.visibilityOfElementLocated(result));
        return el.getText().trim();
    }
}
