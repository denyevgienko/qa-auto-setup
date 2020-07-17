import models.Board;
import okhttp3.ResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import retrofit2.Response;

import java.io.IOException;

public class BoardsTest {
    public TrelloRestClient client = new TrelloRestClient();
    String idBoard;

    @Test
    public void createBoardTest() throws IOException {
        Response<Board> testBoardResponse = client.boardsServicel.createBoard("TestBoardTest").execute();
        Assert.assertEquals(testBoardResponse.code(), 200);

        System.out.println("Headers:");
        System.out.println();
        System.out.println(testBoardResponse.headers());

        System.out.println("Body:");
        System.out.println();
        System.out.println(testBoardResponse.body());

        idBoard = testBoardResponse.body().id;
    }

    @Test
    public void deleteBoardTest() throws IOException {
        Response<ResponseBody> testBoardResponse = client.boardsServicel.deleteBoard(idBoard).execute();
        Assert.assertEquals(testBoardResponse.code(), 200);
    }
}
