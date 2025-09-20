package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final WebDriver driver;

    // Locators
    private final By username = By.id("username");
    private final By password = By.id("password");
    private final By loginBtn = By.cssSelector("button[type='submit']");
    private final By flash = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Navigate to Login page from homepage */
    public void open() {
        driver.findElement(By.linkText("Form Authentication")).click();
    }

    public void enterUsername(String u) {
        driver.findElement(username).clear();
        driver.findElement(username).sendKeys(u);
    }

    public void enterPassword(String p) {
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(p);
    }

    public void clickLogin() {
        driver.findElement(loginBtn).click();
    }

    /** Wait for the flash message and return its text (trimmed) */
    public String getFlashText() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement flashElement = wait.until(ExpectedConditions.visibilityOfElementLocated(flash));
        return flashElement.getText().trim();
    }
}
