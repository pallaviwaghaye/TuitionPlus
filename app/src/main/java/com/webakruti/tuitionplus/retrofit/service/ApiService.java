package com.webakruti.tuitionplus.retrofit.service;

import com.webakruti.tuitionplus.models.Details;
import com.webakruti.tuitionplus.models.Login;
import com.webakruti.tuitionplus.models.Workspace;
import com.webakruti.tuitionplus.retrofit.ApiConstants;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface ApiService {

    // Check Organization API - POST
    @POST(ApiConstants.CHECK_ORGANIZATION_API)
    Call<Workspace> checkOrganization(@Body RequestBody body);


    // Login API - POST
    @POST(ApiConstants.LOGIN_API)
    Call<Login> submitLogin(@Body RequestBody body);

    //StudentDetails APT - POST
    @POST(ApiConstants.GET_DETAILS_API)
    Call<Details> getDetails(@Header("Authorization") String header);

}
