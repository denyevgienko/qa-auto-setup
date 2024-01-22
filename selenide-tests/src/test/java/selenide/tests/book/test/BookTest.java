package selenide.tests.book.test;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import config.MainConfig;
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

    @Test()
    public void addRandomContact() {
        $(".contacts").should(Condition.visible);
        $(".contactTableBodyRow").should(Condition.hidden);
        apiBaseSteps.addContact();
        apiBaseSteps.getContacts();
        sleep(3000);
        Selenide.refresh();
        $(".contactTableBodyRow")
                .should(Condition.visible)
                .should(Condition.text(apiBaseSteps.contactList[0].firstName))
                .should(Condition.text(apiBaseSteps.contactList[0].lastName));
        sleep(3000);
    }
}
