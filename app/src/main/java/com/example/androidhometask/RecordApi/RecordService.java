package com.example.androidhometask.RecordApi;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RecordService {


    @GET("api/home_page.php")
    Call<ReportResponse> getRecordResponse();


}
