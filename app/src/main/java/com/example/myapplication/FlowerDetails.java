package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.flower_response_pojo.DataFlowerCollection;
import com.squareup.picasso.Picasso;

public class FlowerDetails extends AppCompatActivity {
  private   ImageView imageView;
  private TextView tv_flower;
  private String ImgUrl, im1,im2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flower_details);

        im1 = "https://services.hanselandpetal.com/photos/";

        imageView= findViewById(R.id.flowersImage);
        tv_flower = findViewById(R.id.textView_flowers);
        DataFlowerCollection dataFlowerCollection = (DataFlowerCollection) getIntent().getSerializableExtra("flowers");
        im2 = dataFlowerCollection.getPhoto();
        ImgUrl= im1+im2;
        tv_flower.setText(dataFlowerCollection.getName()+"\n"+"\n"+dataFlowerCollection.getCategory()+"\n"+"\n"+dataFlowerCollection.getInstructions()+"\n"+"\n"+dataFlowerCollection.getPrice());
        Picasso.get().load(ImgUrl).into(imageView);
    }
}