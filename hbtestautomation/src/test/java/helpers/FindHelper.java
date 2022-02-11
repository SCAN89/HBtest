package helpers;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.openqa.selenium.By;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Iterator;
import java.util.Objects;

public class FindHelper {

    static File dir = new File("./src/test/resources/pageObjects");

    public static By createBy(String elementName) throws FileNotFoundException {
        File[] list = dir.listFiles();
        for (int i = 0; i < Objects.requireNonNull(list).length; i++) {
            File file = new File(dir + "/" + list[i].getName());
            JsonArray array = new JsonParser().parse(new FileReader(file)).getAsJsonArray();
            Iterator<JsonElement> iterator = array.iterator();
            JsonObject foundObject = null;
            while (iterator.hasNext()) {
                JsonObject object = iterator.next().getAsJsonObject();
                if (
                        elementName.equalsIgnoreCase(object.get("elementName").getAsString())) {
                    foundObject = object;
                    break;
                }
            }
            if (foundObject == null) {
                continue;
            }
            String locateUsing = foundObject.get("locateUsing").getAsString();
            String locator = foundObject.get("locator").getAsString();

            if (("xpath".equalsIgnoreCase(locateUsing))) {
                return new By.ByXPath(locator);
            }
            if (("id".equalsIgnoreCase(locateUsing))) {
                return new By.ById(locator);
            }
            if (("name".equalsIgnoreCase(locateUsing))) {
                return new By.ByName(locator);
            }
            if (("className".equalsIgnoreCase(locateUsing))) {
                return new By.ByClassName(locator);
            }
            if (("css".equalsIgnoreCase(locateUsing))) {
                return new By.ByCssSelector(locator);
            }
            if (("tagName".equalsIgnoreCase(locateUsing))) {
                return new By.ByTagName(locator);
            }
            if (("linkText".equalsIgnoreCase(locateUsing))) {
                return new By.ByLinkText(locator);
            }
            if (("partialLinkText".equalsIgnoreCase(locateUsing))) {
                return new By.ByPartialLinkText(locator);
            }
            throw new UnsupportedOperationException("Currently " + locateUsing + " is NOT supported.");
        }
        throw new RuntimeException();
    }

}