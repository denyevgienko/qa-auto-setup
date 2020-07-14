import interceptors.TrelloAuthInterceptor;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import services.BoardsService;
import services.ListsService;

import java.util.concurrent.TimeUnit;

public class TrelloRestClient {
    public static final String HOME_IO_BASE_URL = "https://api.trello.com/1/";
    public ListsService listsService;
    public BoardsService boardsServicel;

    public TrelloRestClient() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .addInterceptor(new TrelloAuthInterceptor())
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .baseUrl(HOME_IO_BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        listsService = retrofit.create(ListsService.class);
        boardsServicel = retrofit.create(BoardsService.class);
    }
}