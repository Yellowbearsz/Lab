package com.example.lab5.api;

import com.example.lab5.model.TextNote;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("posts")  // Endpoint
    Call<List<TextNote>> getTextNote();
}