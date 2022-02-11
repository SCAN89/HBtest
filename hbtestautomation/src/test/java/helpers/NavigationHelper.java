package helpers;

import hooks.Hooks;

public class NavigationHelper {
    public static void navigateTo(String URL)  {
        Hooks.driver.navigate().to(URL);
    }

}
