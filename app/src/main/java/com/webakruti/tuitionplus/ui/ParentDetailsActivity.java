package com.webakruti.tuitionplus.ui;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.models.Details;
import com.webakruti.tuitionplus.models.Student;
import com.webakruti.tuitionplus.retrofit.service.RestClient;
import com.webakruti.tuitionplus.utils.NetworkUtil;
import com.webakruti.tuitionplus.utils.SharedPreferenceManager;

import java.io.Serializable;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ParentDetailsActivity extends AppCompatActivity {

    private TextView textViewParentName;
    private TextView textViewStudentRelation;
    private TextView textViewEmail;
    private TextView textViewMobileNumber;
    private TextView textViewAlternateMobNo;
    private TextView textViewParentAddress;

    private ImageView imageViewBack;

    private TextView textViewParentDetails;
    private LinearLayout linearLayoutParentDetails;

    private ProgressDialog progressDialogForAPI;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parent_details);

        textViewParentName = (TextView) findViewById(R.id.textViewParentName);
        textViewStudentRelation = (TextView) findViewById(R.id.textViewStudentRelation);
        textViewEmail = (TextView) findViewById(R.id.textViewEmail);
        textViewMobileNumber = (TextView) findViewById(R.id.textViewMobileNumber);
        textViewAlternateMobNo = (TextView) findViewById(R.id.textViewAlternateMobNo);
        textViewParentAddress = (TextView) findViewById(R.id.textViewParentAddress);

        linearLayoutParentDetails = (LinearLayout)findViewById(R.id.linearLayoutParentDetails);
        textViewParentDetails = (TextView)findViewById(R.id.textViewParentDetails);

        imageViewBack = (ImageView) findViewById(R.id.imageViewBack);
        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Student.Studentparents parentDetails = (Student.Studentparents) getIntent().getSerializableExtra("parentDetails");

        if (NetworkUtil.hasConnectivity(ParentDetailsActivity.this)) {
            progressDialogForAPI = new ProgressDialog(ParentDetailsActivity.this);
            progressDialogForAPI.setCancelable(false);
            progressDialogForAPI.setIndeterminate(true);
            progressDialogForAPI.setMessage("Please wait...");
            progressDialogForAPI.show();

            if (parentDetails != null) {

                linearLayoutParentDetails.setVisibility(View.VISIBLE);
                textViewParentDetails.setVisibility(View.GONE);

                progressDialogForAPI.cancel();

                if(parentDetails.getFname()!=null && parentDetails.getLname()!=null) {
                    textViewParentName.setText(parentDetails.getFname() + " " + parentDetails.getLname());
                }else{
                    textViewParentName.setText("N/A");
                }
                textViewStudentRelation.setText(parentDetails.getRelation());
                if (parentDetails.getEmail() != null) {
                    textViewEmail.setText(parentDetails.getEmail().toString());
                } else {
                    textViewEmail.setText("N/A");
                }

                textViewMobileNumber.setText(parentDetails.getMobile());

                if (parentDetails.getAltmobile() != null) {
                    textViewAlternateMobNo.setText(parentDetails.getAltmobile().toString());
                } else {
                    textViewAlternateMobNo.setText("N/A");
                }

                if (parentDetails.getAddress() != null) {
                    textViewParentAddress.setText(parentDetails.getAddress() + ", " + parentDetails.getCity() + ", " +
                            parentDetails.getState() + ", " + parentDetails.getCountry() + ", " + parentDetails.getPincode());

                }else{
                    textViewParentAddress.setText("N/A");
                }
            }
            else{
                progressDialogForAPI.cancel();
                linearLayoutParentDetails.setVisibility(View.GONE);
                textViewParentDetails.setVisibility(View.VISIBLE);
                textViewParentDetails.setText("No data found");
            }

        } else {
            Toast.makeText(ParentDetailsActivity.this, "No Internet connection", Toast.LENGTH_SHORT).show();
        }
    }


}
