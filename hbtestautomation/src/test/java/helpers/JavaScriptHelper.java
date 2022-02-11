package helpers;

import hooks.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedCondition;


public class JavaScriptHelper {

    public static void pageLoadComplete() {
        try {
            Thread.sleep(200);
            final JavascriptExecutor jsDriver = (JavascriptExecutor) Hooks.driver;
            ExpectedCondition<Boolean> expectation = driver -> jsDriver.executeScript("return document.readyState", true).toString().equals("complete");

        } catch (Throwable ignored) {

        }

    }


}
