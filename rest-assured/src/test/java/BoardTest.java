import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import models.Board;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import services.BoardService;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.nullValue;

public class BoardTest {
    public BoardService boardService = new BoardService();
    public String idBoard;

    @BeforeMethod
    public void setup() {
        RestAssured.requestSpecification = new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com/1")
                .addQueryParam("key", "05249100335562a176686084e5182b79")
                .addQueryParam("token", "ddaeb5ee39b810770f49564fae5403925044b309e30e392715d2f3da8ecb95d5")
                .build();
    }

    @Test
    public void createBoard() {
        idBoard = boardService.createBoard("TestBoardRest")
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("TestBoardRest")).extract()
                .body().as(Board.class).getId();
    }

    @Test
    public void deleteBoard() {
        boardService.deleteBoard(idBoard)
                .assertThat()
                .statusCode(200)
                .body("_value", nullValue());
    }

    //TODO Default RestAssured client with out additional components
//        @Test
//    public void createBoard() {
//    RestAssured
//            .given()
//            .log().all()
//            .contentType(ContentType.JSON)
//            .queryParam("name", "TestBoardRest")
//
//            .when()
//            .post("/boards")
//
//            .then()
//            .log().all()
//            .assertThat()
//            .statusCode(200)
//            .body("name", equalTo("TestBoardRest"));
//    }
}
