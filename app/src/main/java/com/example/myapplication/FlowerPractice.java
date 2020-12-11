package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.all_interface.FlowerService;
import com.example.myapplication.flower_response_pojo.DataFlowerCollection;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class FlowerPractice extends AppCompatActivity {
    private  static  String BaseUrl = "https://services.hanselandpetal.com/";
    private FlowerService service ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_practice);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service= retrofit.create(FlowerService.class);
        service.getFlowerApiService().enqueue(new Callback<List<DataFlowerCollection>>() {
            @Override
            public void onResponse(Call<List<DataFlowerCollection>> call, Response<List<DataFlowerCollection>> response) {
                if(response.code()==200){
                   List<DataFlowerCollection> flowerCollections = response.body();
                }
            }

            @Override
            public void onFailure(Call<List<DataFlowerCollection>> call, Throwable t) {

            }
        });


    }
}