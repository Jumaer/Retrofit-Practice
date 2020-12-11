package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.news_response_pojos.Article;
import com.squareup.picasso.Picasso;

public class NewsDetails extends AppCompatActivity {
     private ImageView imageView;
     private TextView textView,text2,text3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        textView=findViewById(R.id.textView_author);
        text2= findViewById(R.id.textView_title);
        text3= findViewById(R.id.textView_content);
        imageView = findViewById(R.id.newsImage);
        Article article = (Article) getIntent().getSerializableExtra("article");
        if(article!= null){
            String imageURL = article.getUrlToImage();
            Picasso.get().load(imageURL).into(imageView);
            textView.setText(article.getAuthor()+"\n");
            text2.setText(article.getTitle()+"\n");
            text3.setText(article.getContent());


        }
    }
}