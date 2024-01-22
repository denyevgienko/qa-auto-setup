package steps;

import POJO.RequestObjects.AddContact;
import POJO.RequestObjects.CreateNewUser;
import POJO.Responces.ListOfContactResponses;
import POJO.Responces.UserResponse;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import config.MainConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.openqa.selenium.Cookie;
import rest.client.RestAssuredClient;

import static com.codeborne.selenide.Selenide.sleep;
import static io.restassured.RestAssured.given;

public class ApiBaseSteps extends MainConfig {
    public UserResponse userResponse;
    public ListOfContactResponses[] contactList;

    public ApiBaseSteps() {
        this.userResponse = createUser();
    }

    public void signInUnderNewUser() {
        String token = userResponse.token;
        Selenide.open("https://thinking-tester-contact-list.herokuapp.com/");
        Cookie cookie = new Cookie("token", token);
        WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        sleep(3000);
        Selenide.open("https://thinking-tester-contact-list.herokuapp.com/contactList");
    }

    public UserResponse createUser() {
        Response response = given()
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.registerUser))
                .contentType(ContentType.JSON)
                .body(new CreateNewUser().createJsonRandomUser())
                .post();

        return response.as(UserResponse.class);
    }


    public void addContact() {
        Response response = given()
                .header(new Header("Authorization", "Bearer ".concat(userResponse.token)))
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.addContact))
                .contentType(ContentType.JSON)
                .body(new AddContact().createJsonRandomContact())
                .post();
    }


    public ListOfContactResponses[] getContacts() {
        Response response = given()
                .header(new Header("Authorization", "Bearer ".concat(userResponse.token)))
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.getContactList))
                .contentType(ContentType.JSON)
                .get();
        response.print();
        contactList = response.as(ListOfContactResponses[].class);
        return contactList;
    }
}
