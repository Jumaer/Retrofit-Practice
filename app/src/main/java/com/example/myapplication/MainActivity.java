package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myapplication.all_adapter.NewsResponseAdapter;
import com.example.myapplication.all_interface.NewsResponseServiceProvider;
import com.example.myapplication.news_response_pojos.Article;
import com.example.myapplication.news_response_pojos.NewsApiResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static String BASE_URL="https://newsapi.org/v2/";
    private static String TAG=" Retrofit Problem";

    private RecyclerView recyclerView;
    NewsResponseAdapter responseAdapter;
    LinearLayoutManager llm;


    private Button b ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


       recyclerView = findViewById(R.id.recycleView_Display_articles) ;
       llm = new LinearLayoutManager(this);

       b= findViewById(R.id.nextApi1);
       b.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent = new Intent(MainActivity.this,MainNext2.class);
               startActivity(intent);
           }
       });



        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        NewsResponseServiceProvider responseServiceProvider = retrofit.create(NewsResponseServiceProvider.class);
        responseServiceProvider.getNewsService().enqueue(new Callback<NewsApiResponse>() {
            @Override
            public void onResponse(Call<NewsApiResponse> call, Response<NewsApiResponse> response) {
                if(response.code()==200){
                    NewsApiResponse apiResponse = response.body();
                    List<Article>articleList = apiResponse.getArticles();

                    responseAdapter = new NewsResponseAdapter(MainActivity.this,articleList);
                    recyclerView.setLayoutManager(llm);
                    recyclerView.setAdapter(responseAdapter);
                }
                else{
                    Toast.makeText(MainActivity.this,"Something Wrong in server",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<NewsApiResponse> call, Throwable t) {

             Log.e(TAG,t.getLocalizedMessage());
             Toast.makeText(MainActivity.this,"Something Wrong in internet connection",Toast.LENGTH_SHORT).show();
            }
        });

     //   moveToNextApi();
    }


}