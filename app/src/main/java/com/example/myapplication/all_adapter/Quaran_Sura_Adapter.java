package com.example.myapplication.all_adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.quaran_surapojos.Datum;

import java.util.List;

public class Quaran_Sura_Adapter extends RecyclerView.Adapter<Quaran_Sura_Adapter.Quaran_sura_viewHolder> {
    private Context context;
    private List<Datum>datumList ;

    public Quaran_Sura_Adapter(Context context, List<Datum> datumList) {
        this.context = context;
        this.datumList = datumList;
    }

    @NonNull
    @Override
    public Quaran_sura_viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.list_of_data_surah_detail,parent,false);
        return new Quaran_sura_viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Quaran_sura_viewHolder holder, int position) {
        holder.number.setText(String.valueOf(datumList.get(position).getNumber()));
        holder.name.setText(datumList.get(position).getName());
        holder.englishName.setText(datumList.get(position).getEnglishName());
        holder.englishNameTranslation.setText(datumList.get(position).getEnglishNameTranslation());

    }

    @Override
    public int getItemCount() {
        return datumList.size();
    }

    class Quaran_sura_viewHolder extends RecyclerView.ViewHolder{

        TextView number, name, englishName, englishNameTranslation;

        public Quaran_sura_viewHolder(@NonNull View itemView) {
            super(itemView);

            number = itemView.findViewById(R.id.number);
            name = itemView.findViewById(R.id.name);
            englishName = itemView.findViewById(R.id.englishName);
            englishNameTranslation = itemView.findViewById(R.id.englishNameTranslation);
        }
    }
}
