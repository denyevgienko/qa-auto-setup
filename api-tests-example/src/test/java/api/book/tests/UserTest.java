package api.book.tests;

import POJO.RequestObjects.AddContact;
import POJO.RequestObjects.CreateNewUser;
import POJO.Responces.ListOfContactResponses;
import POJO.Responces.UserResponse;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import rest.client.RestAssuredClient;

import java.util.Arrays;

import static io.restassured.RestAssured.given;

public class UserTest {

    UserResponse userResponse;
    ListOfContactResponses[] contactList;

    @BeforeClass
    public void addUser() {
        Response response = given()
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.registerUser))
                .contentType(ContentType.JSON)
                .body(new CreateNewUser().createJsonRandomUser())
                .post();

        Assert.assertEquals(response.statusCode(), 201);
        userResponse = response.as(UserResponse.class);
        response.print();
    }

    @AfterClass
    public void afterClass() {
        System.out.println("USER : " + userResponse);
        System.out.println("CONTACT LIST : " + Arrays.toString(contactList));
    }


    @Test(description = "add random contact")
    public void addContact() {
        Response response = given()
                .header(new Header("Authorization", "Bearer ".concat(userResponse.token)))
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.addContact))
                .contentType(ContentType.JSON)
                .body(new AddContact().createJsonRandomContact())
                .post();
        response.print();
        Assert.assertEquals(response.statusCode(), 201);
    }

    @Test(description = "check user info")
    public void getUserInfo() {
        Response response = given()
                .header(new Header("Authorization", "Bearer ".concat(userResponse.token)))
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.getUser))
                .contentType(ContentType.JSON)
                .get();
        response.print();
        Assert.assertEquals(response.statusCode(), 200);
    }

    @Test(dependsOnMethods = {"addContact"}, description = "check contacts info")
    public void getContacts() {
        Response response = given()
                .header(new Header("Authorization", "Bearer ".concat(userResponse.token)))
                .baseUri(RestAssuredClient.baseApiUrl.concat(RestAssuredClient.getContactList))
                .contentType(ContentType.JSON)
                .get();
        response.print();
        Assert.assertEquals(response.statusCode(), 200);
        contactList = response.as(ListOfContactResponses[].class);
    }
}
