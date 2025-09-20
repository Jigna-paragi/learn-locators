package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CheckboxesPage;
import utils.BaseTest;

public class CheckboxesTest extends BaseTest {

    @Test(groups = {"smoke"}, description = "Toggle both checkboxes and verify their state flips")
    public void testToggleCheckboxes() {
        CheckboxesPage page = new CheckboxesPage(driver);

        // Navigate to Checkboxes page from homepage
        page.open();

        // Wait until 2 checkboxes are present
        page.waitForCheckboxes(2, 10);

        // Assert that at least 2 checkboxes exist
        int count = page.count();
        Assert.assertTrue(count >= 2,
                "Expected at least 2 checkboxes on the page, but found " + count);

        // Capture initial states
        boolean initial1 = page.isChecked(1);
        boolean initial2 = page.isChecked(2);

        // Toggle both checkboxes
        page.clickCheckbox(1);
        page.clickCheckbox(2);

        // Validate states have flipped
        Assert.assertNotEquals(page.isChecked(1), initial1, "First checkbox state should have toggled");
        Assert.assertNotEquals(page.isChecked(2), initial2, "Second checkbox state should have toggled");
    }
}
