package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CheckboxesPage {
    private final WebDriver driver;
    private final By checkboxes = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Navigate to Checkboxes page by clicking link from home
     * (since BaseTest already loads base URL).
     */
    public void open() {
        driver.findElement(By.linkText("Checkboxes")).click();
    }

    /** Wait for at least n checkboxes to be present (use before interacting) */
    public void waitForCheckboxes(int expectedCount, int timeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(checkboxes, expectedCount - 1));
    }

    private WebElement checkboxAt(int index) {
        List<WebElement> boxes = driver.findElements(checkboxes);
        if (index < 1 || index > boxes.size()) {
            throw new IndexOutOfBoundsException(
                    "Checkbox index out of range: " + index + " (found " + boxes.size() + ")"
            );
        }
        return boxes.get(index - 1);
    }

    public boolean isChecked(int index) {
        return checkboxAt(index).isSelected();
    }

    public void clickCheckbox(int index) {
        checkboxAt(index).click();
    }

    public void toggleBoth() {
        List<WebElement> boxes = driver.findElements(checkboxes);
        for (WebElement b : boxes) {
            b.click();
        }
    }

    public int count() {
        return driver.findElements(checkboxes).size();
    }
}
