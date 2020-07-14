package services;

import models.TrelloList;
import retrofit2.Call;
import retrofit2.http.*;

public interface ListsService {

    @GET("lists/{id}")
    Call<TrelloList> getList(@Path("id") String id);

    @POST("lists")
    Call<TrelloList> createList(@Query("idBoard") String idBoard, @Query("name") String name);

    @PUT("lists/{id}")
    Call<TrelloList> updateList(@Path("id") String id, @Body TrelloList trelloList);

    @PUT("lists/{id}/closed")
    Call<TrelloList> archiveList(@Path("id") String id, @Query("value") Boolean value);

}