package services;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

public class BoardService {

    public ValidatableResponse createBoard(String boardName) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("name", boardName)
                .when()
                .post("/boards")
                .then().log().all();
    }

    public ValidatableResponse deleteBoard(String idBoard) {
        return RestAssured
                .given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("id", idBoard)
                .when()
                .delete("/boards/{id}")
                .then().log().all();
    }
}
