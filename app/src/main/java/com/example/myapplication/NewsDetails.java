package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.news_response_pojos.Article;
import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
     private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        imageView = findViewById(R.id.newsImage);
        Article article = (Article) getIntent().getSerializableExtra("article");
        if(article!= null){
            String imageURL = article.getUrlToImage();
            Picasso.get().load(imageURL).into(imageView);

        }
    }
}