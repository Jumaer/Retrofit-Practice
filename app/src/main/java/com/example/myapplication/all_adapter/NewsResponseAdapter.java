package com.example.myapplication.all_adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.NewsDetails;
import com.example.myapplication.R;
import com.example.myapplication.news_response_pojos.Article;

import java.util.List;

public class NewsResponseAdapter extends RecyclerView.Adapter<NewsResponseAdapter.NewsResponseViewHolder> {

    private Context context;
    private List<Article> articleList;

    public NewsResponseAdapter(Context context, List<Article> articleList) {
        this.context = context;
        this.articleList = articleList;
    }

    @NonNull
    @Override
    public NewsResponseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_of_news,parent,false);
        return new NewsResponseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsResponseViewHolder holder, int position) {
      holder.publishedAt.setText(articleList.get(position).getPublishedAt());
      holder.description.setText(articleList.get(position).getDescription());

      holder.source.setText(articleList.get(position).getSource().getName());
      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Article article = articleList.get(position);
              Intent intent = new Intent(context, NewsDetails.class);
              intent.putExtra("article",article);
              context.startActivity(intent);
          }
      });

    }

    @Override
    public int getItemCount() {
        return articleList.size();
    }

    class NewsResponseViewHolder extends RecyclerView.ViewHolder{

        TextView publishedAt,description,source;

        public NewsResponseViewHolder(@NonNull View itemView) {
            super(itemView);
            publishedAt = itemView.findViewById(R.id.publishedAt);
            description = itemView.findViewById(R.id.description);

            source = itemView.findViewById(R.id.source);
        }
    }
}
