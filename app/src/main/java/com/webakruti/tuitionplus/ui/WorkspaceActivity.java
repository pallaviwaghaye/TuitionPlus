package com.webakruti.tuitionplus.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.webakruti.tuitionplus.utils.NetworkUtil;
import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.models.Workspace;
import com.webakruti.tuitionplus.retrofit.ApiConstants;
import com.webakruti.tuitionplus.retrofit.service.RestClient;
import com.webakruti.tuitionplus.utils.SharedPreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WorkspaceActivity extends AppCompatActivity implements View.OnClickListener {
    public EditText editTextDomainName;
    private Button ButtonDomain;
    private ProgressDialog progressDialogForAPI;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workspace);

       SharedPreferenceManager.setApplicationContext(WorkspaceActivity.this);

        initViews();


    }

    private void initViews() {
        editTextDomainName = (EditText) findViewById(R.id.editTextDomainName);
        ButtonDomain = (Button) findViewById(R.id.buttonDomain);
        ButtonDomain.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonDomain:
                if (NetworkUtil.hasConnectivity(WorkspaceActivity.this)) {

                    try {
                        if (editTextDomainName.getText().toString().length() > 0) {
                            JSONObject jsonObject = new JSONObject();
                            jsonObject.put("workspace", editTextDomainName.getText().toString());

                            progressDialogForAPI = new ProgressDialog(this);
                            progressDialogForAPI.setCancelable(false);
                            progressDialogForAPI.setIndeterminate(true);
                            progressDialogForAPI.setMessage("Please wait...");
                            progressDialogForAPI.show();

                            RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
                            callCheckOrganizationAPI(body);
                        } else {
                            Toast.makeText(WorkspaceActivity.this, "Please enter organization name", Toast.LENGTH_SHORT).show();

                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                } else {
                    Toast.makeText(WorkspaceActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private void callCheckOrganizationAPI(RequestBody body) {
        Call<Workspace> requestCallback = RestClient.getApiService(ApiConstants.CHECK_ORGANIZATION_BASE_URL).checkOrganization(body);
        requestCallback.enqueue(new Callback<Workspace>() {
            @Override
            public void onResponse(Call<Workspace> call, Response<Workspace> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    Workspace result = response.body();
                    if (result.getSuccess() == true) {

                        SharedPreferenceManager.saveWorkspace(result.getCompanyName().toString());

                        Intent intent = new Intent(WorkspaceActivity.this, LoginActivity.class);

                        startActivity(intent);
                        finish();

                    }
                } else {
                    // Response code is 401

                    Toast.makeText(WorkspaceActivity.this, "Your organization is not found", Toast.LENGTH_SHORT).show();
                }

                if (progressDialogForAPI != null) {
                    progressDialogForAPI.cancel();
                }
            }

            @Override
            public void onFailure(Call<Workspace> call, Throwable t) {

                if (t != null) {

                    if (progressDialogForAPI != null) {
                        progressDialogForAPI.cancel();
                    }
                    if (t.getMessage() != null)
                        Log.e("error", t.getMessage());
                }

            }
        });


    }

}
