package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.DropdownPage;
import utils.BaseTest;

public class DropdownTest extends BaseTest {

    @Test(groups = {"regression"}, description = "Verify default and manual dropdown selections")
    public void testSelectOption1() {
        DropdownPage page = new DropdownPage(driver);

        page.open();
        page.waitForOptions(3, 10);

        // Explicitly select Option 1 and assert
        page.selectByVisibleText("Option 1");
        Assert.assertEquals(page.getSelectedOption(), "Option 1", "Option 1 should be selected after explicit selection");
    }
}
