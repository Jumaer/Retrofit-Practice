package com.example.myapplication.all_adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FlowerDetails;
import com.example.myapplication.R;
import com.example.myapplication.flower_response_pojo.DataFlowerCollection;

import java.util.List;

public class FlowerResponseAdapter extends RecyclerView.Adapter<FlowerResponseAdapter.FlowerRes_Ad_ViewHolder> {

    private Context context;
    List<DataFlowerCollection>dataFlowerCollections;

    public FlowerResponseAdapter(Context context, List<DataFlowerCollection> dataFlowerCollections) {
        this.context = context;
        this.dataFlowerCollections = dataFlowerCollections;
    }

    @NonNull
    @Override
    public FlowerRes_Ad_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context)
                .inflate(R.layout.flower_details_show,parent,false);
        return new FlowerRes_Ad_ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull FlowerRes_Ad_ViewHolder holder, int position) {
        holder.flowerName.setText(dataFlowerCollections.get(position).getName());
        holder.flowerPrice.setText(String.valueOf(dataFlowerCollections.get(position).getPrice()));
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataFlowerCollection dataFlowerCollection = dataFlowerCollections.get(position);
                Intent i = new Intent(context, FlowerDetails.class);
                i.putExtra("flowers",dataFlowerCollection);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataFlowerCollections.size();
    }

    class FlowerRes_Ad_ViewHolder extends RecyclerView.ViewHolder{
      TextView flowerName, flowerPrice;
        public FlowerRes_Ad_ViewHolder(@NonNull View itemView) {
            super(itemView);
            flowerName= itemView.findViewById(R.id.flower_name);
            flowerPrice = itemView.findViewById(R.id.flower_price);
        }
    }
}
