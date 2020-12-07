package com.example.myapplication.all_interface;

import com.example.myapplication.news_response_pojos.NewsApiResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface NewsResponseServiceProvider {


 @GET("everything?q=bitcoin&from=2020-11-07&sortBy=publishedAt&apiKey=bc18ebb5afcd44ef972c0990836f3b4a")
 Call<NewsApiResponse> getNewsService();
}
