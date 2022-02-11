package helpers;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class ElementActionsHelper {


    public void highlightElement(By by) throws Exception {
        try {

            WebElement el = Hooks.driver.findElement(by);
            if (Hooks.driver instanceof JavascriptExecutor) {
                ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].style.border='3px solid green'", el);
            }

        } catch (Exception ex) {
            Thread.sleep(1000);
            throw ex;
        }
    }


    public void swipeToElement(By by) throws Exception {
        WebElement element = Hooks.driver.findElement(by);
        ((JavascriptExecutor) Hooks.driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    public void click(By locator) throws Exception {

            swipeToElement(locator);
            highlightElement(locator);
            WebDriverWait wait = new WebDriverWait(Hooks.driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();

    }

    public void enterText(By locator, String input) throws Exception {
            WaitHelper.waitAndFindElement(locator);
            swipeToElement(locator);
            highlightElement(locator);
            WebDriverWait wait = new WebDriverWait(Hooks.driver, 20);
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
            Hooks.driver.findElement(locator).clear();
            Hooks.driver.findElement(locator).sendKeys(input);

    }
    public String getValue(By locator) throws Exception {

            swipeToElement(locator);
            highlightElement(locator);
            WebDriverWait wait = new WebDriverWait(Hooks.driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));

        return Hooks.driver.findElement(locator).getAttribute("value");

    }

    public String getText(By locator) throws IOException {
            WebDriverWait wait = new WebDriverWait(Hooks.driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return Hooks.driver.findElement(locator).getText();
    }
}
