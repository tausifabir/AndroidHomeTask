package com.example.androidhometask.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.androidhometask.ItemDetailsActivity;
import com.example.androidhometask.R;
import com.example.androidhometask.RecordApi.ReportResponse;
import com.squareup.picasso.Picasso;

public class RecordAdapter extends RecyclerView.Adapter<RecordAdapter.RecordViewHolder> {


    public  static final String baseUrl ="http://unionint.net/";

    private Context context;
    private ReportResponse reportResponse;

    public RecordAdapter(Context context, ReportResponse reportResponse) {
        this.context = context;
        this.reportResponse = reportResponse;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_rows,parent,false);

        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {

        holder.titleTV.setText(reportResponse.getReport().get(position).getTitle());
        holder.priceTV.setText(reportResponse.getReport().get(position).getPrice());
        String  image =  baseUrl + reportResponse.getReport().get(position).getImage();


        Picasso.get().load(image).into(holder.imageViewTV);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String ImageLink = image;
                String Title = reportResponse.getReport().get(position).getTitle();
                String Price = reportResponse.getReport().get(position).getPrice();


                Intent intent = new Intent(context, ItemDetailsActivity.class)
                        .putExtra("image",ImageLink)
                        .putExtra("title",Title)
                        .putExtra("price",Price);
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return reportResponse.getReport().size();
    }

    public class RecordViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewTV;
        TextView titleTV,priceTV,tkTV;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewTV = itemView.findViewById(R.id.imageurlID);
            titleTV = itemView.findViewById(R.id.titleID);
            priceTV = itemView.findViewById(R.id.priceID);
            tkTV = itemView.findViewById(R.id.tkID);
        }
    }

}
