package helpers;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class WaitHelper {
    protected static WebDriverWait wait;

    public static void sleep(int time) throws Exception {
        Thread.sleep(time * 1000);
    }

    public static void waitAndFindElement(By by) throws Exception {
        try {
            wait = new WebDriverWait(Hooks.driver, 30);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }

    public static void waitAndFindElement(String element) throws Exception {
        Thread.sleep(500);
        try {
            wait = new WebDriverWait(Hooks.driver, 6);
            wait.until(ExpectedConditions.visibilityOfElementLocated(FindHelper.createBy(element)));
        } catch (Exception ex) {
            throw new Exception(ex);
        }
    }
}
