package brutal;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PostmanBrutalTest {


    @Test() //Brutal test
    public void brutalTestExampleGet()
    {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "https://postman-echo.com";

        // Get the RequestSpecification of the request that you want to sent
        // to the server. The server is specified by the BaseURI that we have
        // specified in the above step.
        RequestSpecification httpRequest = RestAssured.given();
        //add params to header
        httpRequest.param("foo1", "bar1");

        // Make a request to the server by specifying the method Type and the method URL.
        // This will return the Response from the server. Store the response in a variable.
        Response response = httpRequest.request(Method.GET, "/get");

        /**
         * Get Body.
         */
        // Now let us print the body of the message to see what response
        // we have recieved from the server
        String responseBody = response.getBody().asString();
        System.out.println("Response Body is =>  " + responseBody);
        int status = response.getStatusCode();
        String statusLine = response.getStatusLine();
        Assert.assertEquals(status, 200, "Status code should be 200");
        Assert.assertEquals(statusLine /*actual value*/, "HTTP/1.1 200 OK" /*expected value*/, "Correct status code returned");

        /**
         * Validate headers.
         */
        // Reader header of a give name. In this line we will get
        // Header named Content-Type
        String contentType = response.header("Content-Type");
        System.out.println("Content-Type value: " + contentType);

        // Reader header of a give name. In this line we will get
        // Header named Server
        String serverType =  response.header("Server");
        System.out.println("Server value: " + serverType);

        // Reader header of a give name. In this line we will get
        // Header named Content-Encoding
        String acceptLanguage = response.header("Content-Encoding");
        System.out.println("Content-Encoding: " + acceptLanguage);
        Assert.assertEquals("Correct header returned", contentType /*actual value*/, "application/json; charset=utf-8" /*expected value*/);


        /**
         * Get all the headers. Return value is of type Headers.
        */
        // Headers class implements Iterable interface, hence we
        // can apply an advance for loop to go through all Headers
        // as shown in the code below
        Headers allHeaders = response.headers();

        // Iterate over all the Headers
        for(Header header : allHeaders)
        {
            System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
        }

        /**
         * Validate body using jsonPath
         */
        // First get the JsonPath object instance from the Response interface
        JsonPath jsonPathEvaluator = response.jsonPath();

        // Then simply query the JsonPath object to get a String value of the node
        String args = jsonPathEvaluator.get("args.foo1");

        System.out.println("args " + args);

        // Validate the response
        Assert.assertEquals("Correct args should be", args, "bar1");

    }

    @Test() //Brutal test
    public void brutalTestExamplePOST()
    {
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        requestParams.put("foo1", "bar1");
        requestParams.put("foo2", "bar2");

        request.body(requestParams.toString());
        Response response = request.post("/post");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 200);
        String successCode = response.jsonPath().get("SuccessCode");
    }

    @Test() //Brutal test
    public void brutalTestExampleSerializeResponse()
    {
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = RestAssured.given()
                .param("access_token", "xyz1")
                .param("id", "U1")
                .param("server_secret", "zeppelin")
                .param("admin", "true");

        JSONObject requestParams = new JSONObject();
        request.body(requestParams.toString());
        Response response = request.get("/auth/hawk");

        response.getBody().print();
        // Deserialize the Response body into RegistrationSuccessResponse
        UnautorizedPostmanResponce responce = response.getBody().as(UnautorizedPostmanResponce.class);
        System.out.println(responce.toString());
        Assert.assertEquals(responce.message, "Unauthorized");
        Assert.assertEquals(responce.error, "Unauthorized");
        Assert.assertEquals(responce.statusCode, String.valueOf(401));

    }

    @Test
    public void putRecords(){
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        request.body(requestParams.toString());
        Response response = request.put("/put");

        response.getBody().print();
        System.out.println(response.statusCode());    }

    @Test
    public void deleteRecords(){
        RestAssured.baseURI = "https://postman-echo.com";
        RequestSpecification request = RestAssured.given();

        JSONObject requestParams = new JSONObject();
        request.body(requestParams.toString());
        Response response = request.delete("/delete");

        response.getBody().print();
        System.out.println(response.statusCode());
    }
}
