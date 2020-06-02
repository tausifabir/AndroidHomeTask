package com.example.androidhometask;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidhometask.RecordApi.ReportResponse;
import com.squareup.picasso.Picasso;

public class ItemDetailsActivity extends AppCompatActivity {

    private ImageView itemImageTV;
    private TextView itemTitleTV,itemPriceTV,itemTkTV;
    private Button itemAddCartBTN,itemBuyBTN;

    ReportResponse reportResponse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_details);

        itemImageTV = findViewById(R.id.itemImageurlID);
        itemTitleTV = findViewById(R.id.itemTitleID);
        itemPriceTV = findViewById(R.id.itemPriceID);
        itemTkTV = findViewById(R.id.itemtkID);
        itemAddCartBTN = findViewById(R.id.itemAddCartID);
        itemBuyBTN = findViewById(R.id.itemBuyID);

        reportResponse = new ReportResponse();

        Intent intent = getIntent();
        String itemImage = intent.getStringExtra("image");
        String itemTitle = intent.getStringExtra("title");
        String itemPrice = intent.getStringExtra("price");

        Picasso.get().load(itemImage).into(itemImageTV);
        itemTitleTV.setText(itemTitle);
        itemPriceTV.setText(itemPrice);

        itemBuy();
        itemAddCart();


    }

    public void itemBuy(){

        itemBuyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemDetailsActivity.this, "Buy", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void itemAddCart(){
        itemAddCartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ItemDetailsActivity.this, "Added to Cart", Toast.LENGTH_SHORT).show();
            }
        });
    }







}
