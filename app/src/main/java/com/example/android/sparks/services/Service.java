package com.example.android.sparks.services;

import com.example.android.sparks.models.Unit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface Service {
    @GET("ideas")
    Call<List<Unit>> getIdeas();

    @GET("ideas/{id}")
    Call<Unit> getIdea(@Path("id")int id);

    @POST("ideas")
    Call<Unit> createIdea(@Body Unit newIdea);

    @FormUrlEncoded
    @PUT("ideas/{id}")
    Call<Unit> updateIdea(
            @Path("id")int id,
            @Field("name")String name,
            @Field("description")String desc,
            @Field("status")String status,
            @Field("owner")String owner
    );

    @DELETE("ideas/{id}")
    Call<Void> deleteIdea(@Path("id")int id);
}
//sofia sunam