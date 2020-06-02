package com.example.androidhometask;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.androidhometask.Adapter.RecordAdapter;
import com.example.androidhometask.RecordApi.RecordService;
import com.example.androidhometask.RecordApi.ReportResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {


    public  static final String baseUrl ="http://unionint.net/";

    private RecyclerView recyclerView;
    private RecordAdapter recordAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recordRecyclerView);




        //******** Retrofit Api Get method ******** //
        getApiResponse();

    }


    public void getApiResponse(){

        RecordService recordService = RetrofitClient
                .getClient(baseUrl)
                .create(RecordService.class);

        recordService.getRecordResponse()
                .enqueue(new Callback<ReportResponse>() {
                    @Override
                    public void onResponse(Call<ReportResponse> call, Response<ReportResponse> response) {
                        if(response.isSuccessful()){

                            ReportResponse reportResponse = response.body();
                            // LinearLayoutManager linearLayoutManager =  new LinearLayoutManager(MainActivity.this);
                            recordAdapter = new RecordAdapter(MainActivity.this,reportResponse);
                            //linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                            GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,2);
                            recyclerView.setLayoutManager(gridLayoutManager);
                            recordAdapter.notifyDataSetChanged();
                            recyclerView.setAdapter(recordAdapter);
                            Toast.makeText(MainActivity.this, ""+reportResponse.getReport().size(), Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(MainActivity.this, "Api key experied ", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<ReportResponse> call, Throwable t) {

                        Toast.makeText(MainActivity.this, "Api key experied ", Toast.LENGTH_SHORT).show();
                    }
                });

    }


}
