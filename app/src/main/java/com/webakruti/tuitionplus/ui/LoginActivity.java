package com.webakruti.tuitionplus.ui;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.webakruti.tuitionplus.models.Workspace;
import com.webakruti.tuitionplus.utils.NetworkUtil;
import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.models.Login;
import com.webakruti.tuitionplus.retrofit.ApiConstants;
import com.webakruti.tuitionplus.retrofit.service.RestClient;
import com.webakruti.tuitionplus.utils.SharedPreferenceManager;

import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextUsername;
    private EditText editTextPassword;
    private Button buttonlogin;
    private ProgressDialog progressDialogForAPI;
    private ImageView imageBack;

    private String orgName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        SharedPreferenceManager.setApplicationContext(LoginActivity.this);

        orgName = SharedPreferenceManager.getWorkspace();

        initviews();

    }

    public void initviews()
    {
        editTextUsername = (EditText)findViewById(R.id.editTextUsername);
        editTextPassword = (EditText)findViewById(R.id.editTextPassword);

        imageBack = (ImageView)findViewById(R.id.imageView);
        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this,WorkspaceActivity.class);
                startActivity(i);
                finish();
            }
        });

        //orgName = getIntent().getStringExtra("orgName");

        buttonlogin = (Button)findViewById(R.id.buttonLogin);

        buttonlogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
                case R.id.buttonLogin:
                    if (NetworkUtil.hasConnectivity(LoginActivity.this)) {

                        try {
                            if (editTextUsername.getText().toString().length() > 0) {
                                if (isValidEmailAddress(editTextUsername.getText().toString().trim())) {
                                    if (editTextPassword.getText().toString().length() >= 6) {
                                        JSONObject jsonObject = new JSONObject();
                                        jsonObject.put("email", editTextUsername.getText().toString());
                                        jsonObject.put("password", editTextPassword.getText().toString());

                                        progressDialogForAPI = new ProgressDialog(this);
                                        progressDialogForAPI.setCancelable(false);
                                        progressDialogForAPI.setIndeterminate(true);
                                        progressDialogForAPI.setMessage("Please wait...");
                                        progressDialogForAPI.show();

                                        RequestBody body = RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonObject.toString());
                                        callLoginAPI(body);
                                    } else {
                                        Toast.makeText(LoginActivity.this, "Password must be greater than 6 characters", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(LoginActivity.this, "Email-Id/Username must be valid", Toast.LENGTH_SHORT).show();
                                }
                            } else {
                                Toast.makeText(LoginActivity.this, "Please enter email-Id", Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    } else {
                        Toast.makeText(LoginActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();
                    }
                    break;
        }
    }

    private void callLoginAPI(RequestBody body) {
        String login_URL = "http://" + orgName + ".tuitionplus.in/api/";
        Call<Login> requestCallback = RestClient.getApiService(login_URL).submitLogin(body);
        requestCallback.enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    Login result = response.body();
                    if (result.getSuccess().getToken() != null) {

                        SharedPreferenceManager.saveToken(result.getSuccess().getToken());

                        Intent intent = new Intent(LoginActivity.this, StudentDetailsActivity.class);
                        startActivity(intent);
                        finish();
                    //   Toast.makeText(LoginActivity.this, " UserId:" + result.getSuccess().getUserId() + "Token::::  " + result.getSuccess().getToken() , Toast.LENGTH_SHORT).show();

                    }
                }  else {
                    // Response code is 401
                    Toast.makeText(LoginActivity.this, "Unauthorized User", Toast.LENGTH_SHORT).show();
                }

                if (progressDialogForAPI != null) {
                    progressDialogForAPI.cancel();
                }
            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {

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

    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}
