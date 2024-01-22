package selenide.tests.book.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.MainConfig;
import io.qameta.allure.Allure;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import steps.ApiBaseSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class BookTest extends MainConfig {

    private final ApiBaseSteps apiBaseSteps = new ApiBaseSteps();

    @BeforeMethod
    public void createUser() {
        apiBaseSteps.signInUnderNewUser();
    }

    @Test(description = "add random contact to the book using api for setup")
    public void addRandomContact() {
        Allure.step("check that user logged in and table empty", () -> {
            $(".contacts").should(Condition.visible);
            $(".contactTableBodyRow").should(Condition.hidden);
        });
        apiBaseSteps.addContact();
        apiBaseSteps.getContacts();
        sleep(3000);
        Allure.step("reload page", Selenide::refresh);
        Allure.step("Check that contact was added by api using api", () -> {
            $(".contactTableBodyRow")
                    .should(Condition.visible)
                    .should(Condition.text(apiBaseSteps.contactList[0].firstName))
                    .should(Condition.text(apiBaseSteps.contactList[0].lastName));
        });
        sleep(3000);
    }
}
