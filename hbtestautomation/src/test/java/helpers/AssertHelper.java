package helpers;


import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;


public class AssertHelper {

    public static void existsElement(By by) {
        try {
            Hooks.driver.findElement(by);
        } catch (NoSuchElementException ignored) {
        }
    }

    public static void isDisable(By by) {
        try {
            Hooks.driver.findElement(by).isEnabled();
        } catch (NoSuchElementException ignored) {
        }
    }

    public static void isEnable(By by) {
        try {
            Hooks.driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException ignored) {
        }
    }

    public static void notExistsElement(By by) {
        try {
            Hooks.driver.findElement(by);
        } catch (NoSuchElementException ignored) {
        }
    }

    public static void controlElementText(By by, String expectedtext) {
        String actualtext;
        actualtext = Hooks.driver.findElement(by).getText();
        Assert.assertEquals(expectedtext, actualtext);
    }

    public static void containsElementText(String existingText, String expectedtext) {
        Assert.assertTrue(existingText.contains(expectedtext));
    }

    public static void assertEqualsText(String expectedText, String existingText) {
        Assert.assertEquals(existingText, expectedText);
    }


}
