package com.example.myapplication.all_interface;

import com.example.myapplication.flower_response_pojo.DataFlowerCollection;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FlowerService {

    @GET("feeds/flowers.json")
    Call<List<DataFlowerCollection>> getFlowerApiService();
}
