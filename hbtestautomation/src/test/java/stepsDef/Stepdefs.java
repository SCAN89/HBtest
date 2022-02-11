package stepsDef;

import helpers.AssertHelper;
import helpers.ElementActionsHelper;
import helpers.JavaScriptHelper;
import helpers.NavigationHelper;
import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.SneakyThrows;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.io.FileNotFoundException;
import java.io.IOException;

import static helpers.FindHelper.createBy;

public class Stepdefs {
    ElementActionsHelper elementActionsHelper = new ElementActionsHelper();

    @Given("{string} sayfasindayim")
    public void hbsayfasindayim(String URL) throws Exception {
        NavigationHelper.navigateTo(URL);
        JavaScriptHelper.pageLoadComplete();
         Assert.assertEquals("Türkiye'nin En Büyük Online Alışveriş Sitesi Hepsiburada.com", Hooks.driver.getTitle());
    }
    @SneakyThrows
    @And("Click {string}")
    public void click(String element)  {
        try {
			elementActionsHelper.click(createBy(element));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @When("Fill in {string} field with {string}")
    public void fillInFieldWith(String element, String text) throws Exception {
        elementActionsHelper.enterText(createBy(element), text);
    }

    @Then("Verifiy that the login was successful with {string} user")
    public void verifiyThatTheLoginWasSuccessfulWithUser(String user) throws IOException {
        AssertHelper.assertEqualsText(elementActionsHelper.getText(By.cssSelector(".sf-OldMyAccount-1k66b")),user);
    }
}
