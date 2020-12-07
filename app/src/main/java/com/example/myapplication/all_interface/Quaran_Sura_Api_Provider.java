package com.example.myapplication.all_interface;

import com.example.myapplication.quaran_surapojos.QuaranSurahResponseApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface Quaran_Sura_Api_Provider {
    @GET("v1/surah")
    Call<QuaranSurahResponseApi> getQuaran_sura_service();
}
