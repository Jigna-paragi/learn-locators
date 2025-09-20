package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DropdownPage {
    private final WebDriver driver;
    private final By dropdown = By.id("dropdown");
    private final By dropdownLink = By.linkText("Dropdown");

    public DropdownPage(WebDriver driver) {
        this.driver = driver;
    }

    /** Navigate to Dropdown page from homepage (BaseTest loads base URL) */
    public void open() {
        driver.findElement(dropdownLink).click();
    }

    /** Wait until the dropdown is visible and has at least n options (useful before interacting) */
    public void waitForOptions(int expectedMinimumOptions, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dropdown));
        wait.until(d -> {
            Select s = new Select(driver.findElement(dropdown));
            List<WebElement> opts = s.getOptions();
            return opts.size() >= expectedMinimumOptions;
        });
    }

    public void selectByVisibleText(String text) {
        Select sel = new Select(driver.findElement(dropdown));
        sel.selectByVisibleText(text);
    }

    public void selectByIndex(int index) {
        Select sel = new Select(driver.findElement(dropdown));
        sel.selectByIndex(index);
    }

    public String getSelectedOption() {
        Select sel = new Select(driver.findElement(dropdown));
        return sel.getFirstSelectedOption().getText().trim();
    }

    public int optionCount() {
        Select sel = new Select(driver.findElement(dropdown));
        return sel.getOptions().size();
    }
}
