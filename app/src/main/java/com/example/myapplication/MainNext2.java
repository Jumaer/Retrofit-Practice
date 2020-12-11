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

import com.example.myapplication.all_adapter.Quaran_Sura_Adapter;
import com.example.myapplication.all_interface.Quaran_Sura_Api_Provider;
import com.example.myapplication.quaran_surapojos.Datum;
import com.example.myapplication.quaran_surapojos.QuaranSurahResponseApi;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainNext2 extends AppCompatActivity {
    // Code For Retrofit ..  BASE_URL_2 and TAG 2
    private  static  String BASE_URL_2 = "https://api.alquran.cloud/";
    private  static  String TAG = " Retrofit Problem";

   RecyclerView recyclerView2;
  private LinearLayoutManager llmanager;
   Quaran_Sura_Adapter sura_adapter;

   private Button b2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_next2);

        b2= findViewById(R.id.nextApi2);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainNext2.this,FlowerPractice.class);
                startActivity(intent);
            }
        });

        recyclerView2= findViewById(R.id.recycleView_Display_data) ;
        llmanager= new LinearLayoutManager(this);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL_2)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Quaran_Sura_Api_Provider sura_api_provider = retrofit.create(Quaran_Sura_Api_Provider.class);
        sura_api_provider.getQuaran_sura_service().enqueue(new Callback<QuaranSurahResponseApi>() {
            @Override
            public void onResponse(Call<QuaranSurahResponseApi> call, Response<QuaranSurahResponseApi> response) {

                if(response.code()==200){
                    QuaranSurahResponseApi quaranSurahResponseApi = response.body();
                    List<Datum>datumList = quaranSurahResponseApi.getData();
                  //  Toast.makeText(MainNext2.this,""+datumList.size(),Toast.LENGTH_SHORT).show();
                    sura_adapter = new Quaran_Sura_Adapter(MainNext2.this,datumList);
                recyclerView2.setLayoutManager(llmanager);
                    recyclerView2.setAdapter(sura_adapter);

                }
                else{
                    Toast.makeText(MainNext2.this,"Something Wrong in server",Toast.LENGTH_SHORT).show();
                }


            }

            @Override
            public void onFailure(Call<QuaranSurahResponseApi> call, Throwable t) {
                Log.e(TAG,t.getLocalizedMessage());
                Toast.makeText(MainNext2.this,"Internet connection Invalid",Toast.LENGTH_SHORT).show();
            }
        });
    }
}