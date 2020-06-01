package com.example.androidhometask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidhometask.RecordApi.ReportResponse;
import com.squareup.picasso.Picasso;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView itemImageTV;
    private TextView itemTitleTV,itemPriceTV;

    ReportResponse reportResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemImageTV = findViewById(R.id.itemImageurlID);
        itemTitleTV = findViewById(R.id.itemTitleID);
        itemPriceTV = findViewById(R.id.itemPriceID);

        reportResponse = new ReportResponse();

        Intent intent = getIntent();
        String itemImage = intent.getStringExtra("image");
        String itemTitle = intent.getStringExtra("title");
        String itemPrice = intent.getStringExtra("price");

        Picasso.get().load(itemImage).into(itemImageTV);
        itemTitleTV.setText(itemTitle);
        itemPriceTV.setText(itemPrice);
    }
}
