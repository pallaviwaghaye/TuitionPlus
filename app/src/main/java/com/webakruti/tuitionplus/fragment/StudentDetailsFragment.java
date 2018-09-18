package com.webakruti.tuitionplus.fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.adapters.StudentCourseAdapter;
import com.webakruti.tuitionplus.adapters.StudentDetailsAdapter;
import com.webakruti.tuitionplus.models.Details;
import com.webakruti.tuitionplus.models.Student;
import com.webakruti.tuitionplus.retrofit.service.RestClient;
import com.webakruti.tuitionplus.ui.ParentDetailsActivity;
import com.webakruti.tuitionplus.ui.StudentDetailsActivity;
import com.webakruti.tuitionplus.utils.NetworkUtil;
import com.webakruti.tuitionplus.utils.SharedPreferenceManager;

import org.w3c.dom.Text;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class StudentDetailsFragment extends Fragment {

    private View rootView;
    private ProgressDialog progressDialogForAPI;

    private String orgName;
    private String token;


    //about me
    private TextView textViewEmailId;
    private TextView textViewPhoneNumber;
    private TextView textViewStudentAddress;

    //parent details
    private Button buttonParentDetails;

    //batch details
    private RecyclerView recyclerView;

    //course details
    private  RecyclerView recyclerViewCourseDetails;

  /*  //course details
    private TextView textViewCourseName;
    private TextView textViewCourseDuration;
    private TextView textViewCourseDurationType;
    private TextView textViewCourseFee;

    //fees details
    private TextView textViewTotalFees;
    //private TextView textViewPaidFees;
    //private TextView textViewBalanceFees;

    //registartion
    private TextView textViewRegistrationTotalAmount;
    private TextView textViewRegistrationPaidFees;
    private TextView textViewRegistrationRemainingFee;
    private TextView textViewRegistrationPaidOnDate;

    //1st installment
    private TextView textView1stTotalAmount;
    private TextView textView1stPaidFees;
    private TextView textView1stRemainingFee;
    private TextView textView1stPaidOnDate;

    //2nd installment
    private TextView textView2ndTotalAmount;
    private TextView textView2ndPaidFees;
    private TextView textView2ndRemainingFee;
    private TextView textView2ndPaidOnDate;*/

    View viewBatchDetailsTop;
    View viewCourseDetails;

    TextView textViewBatchDetails;
    TextView textViewCourseDetails;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_student_details, container, false);

        initViews();

        if (NetworkUtil.hasConnectivity(getActivity())) {
            progressDialogForAPI = new ProgressDialog(getActivity());
            progressDialogForAPI.setCancelable(false);
            progressDialogForAPI.setIndeterminate(true);
            progressDialogForAPI.setMessage("Please wait...");
            progressDialogForAPI.show();

            getStudentDetails();

        } else {
            Toast.makeText(getActivity(), "No Internet connection", Toast.LENGTH_SHORT).show();
        }

        return rootView;
    }

    private void initViews() {

        orgName = SharedPreferenceManager.getWorkspace();
        token = SharedPreferenceManager.getToken();

        // Toast.makeText(getActivity(),"token : " + token + "\n" + "organisation : " + orgName,Toast.LENGTH_LONG).show();

        textViewEmailId = (TextView) rootView.findViewById(R.id.textViewEmailId);
        textViewPhoneNumber = (TextView) rootView.findViewById(R.id.textViewPhoneNumber);
        textViewStudentAddress = (TextView) rootView.findViewById(R.id.textViewStudentAddress);

        buttonParentDetails = (Button) rootView.findViewById(R.id.buttonParentDetails);

        viewBatchDetailsTop = (View) rootView.findViewById(R.id.viewBatchDetailsTop);
        viewCourseDetails = (View) rootView.findViewById(R.id.viewCourseDetails);

        textViewBatchDetails = (TextView) rootView.findViewById(R.id.textViewBatchDetails);
        textViewCourseDetails = (TextView) rootView.findViewById(R.id.textViewCourseDetails);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(layoutManager);

        recyclerViewCourseDetails = (RecyclerView) rootView.findViewById(R.id.recyclerView2);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCourseDetails.setLayoutManager(layoutManager2);


        /*textViewCourseName = (TextView) rootView.findViewById(R.id.textViewCourseName);
        textViewCourseDuration = (TextView) rootView.findViewById(R.id.textViewCourseDuration);
        textViewCourseDurationType = (TextView) rootView.findViewById(R.id.textViewCourseDurationType);
        textViewCourseFee = (TextView) rootView.findViewById(R.id.textViewCourseFee);

        //fees details
        textViewTotalFees = (TextView) rootView.findViewById(R.id.textViewTotalFees);
        //textViewPaidFees = (TextView)rootView.findViewById(R.id.textViewPaidFees);

        //textViewBalanceFees = (TextView)rootView.findViewById(R.id.textViewBalanceFees);

        //registration fees
        textViewRegistrationTotalAmount = (TextView) rootView.findViewById(R.id.textViewRegistrationTotalAmount);
        textViewRegistrationPaidFees = (TextView) rootView.findViewById(R.id.textViewRegistrationPaidFees);
        textViewRegistrationRemainingFee = (TextView) rootView.findViewById(R.id.textViewRegistrationRemainingFee);
        textViewRegistrationPaidOnDate = (TextView) rootView.findViewById(R.id.textViewRegistrationPaidOnDate);

        //1st installment
        textView1stTotalAmount = (TextView) rootView.findViewById(R.id.textView1stTotalAmount);
        textView1stPaidFees = (TextView) rootView.findViewById(R.id.textView1stPaidFees);
        textView1stRemainingFee = (TextView) rootView.findViewById(R.id.textView1stRemainingFee);
        textView1stPaidOnDate = (TextView) rootView.findViewById(R.id.textView1stPaidOnDate);

        //2nd installment
        textView2ndTotalAmount = (TextView) rootView.findViewById(R.id.textView2ndTotalAmount);
        textView2ndPaidFees = (TextView) rootView.findViewById(R.id.textView2ndPaidFees);
        textView2ndRemainingFee = (TextView) rootView.findViewById(R.id.textView2ndRemainingFee);
        textView2ndPaidOnDate = (TextView) rootView.findViewById(R.id.textView2ndPaidOnDate);*/

    }

    public void getStudentDetails() {
        SharedPreferenceManager.setApplicationContext(getActivity());
        String orgName = SharedPreferenceManager.getWorkspace();
        String token = SharedPreferenceManager.getToken();

        String getDetails_URL = "http://" + orgName + ".tuitionplus.in/api/";
        String headers = "Bearer " + token;
        Call<Details> requestCallback = RestClient.getApiService(getDetails_URL).getDetails(headers);
        requestCallback.enqueue(new Callback<Details>() {
            @Override
            public void onResponse(Call<Details> call, Response<Details> response) {
                if (response.isSuccessful() && response.body() != null && response.code() == 200) {

                    Details details = response.body();
                    //  Toast.makeText(getActivity(),"Data : " + details ,Toast.LENGTH_LONG).show();
                    if (details != null) {
                        setNavData(details.getStudent());
                        setUIData(details);
                    }

                } else {
                    // Response code is 401
                }

                if (progressDialogForAPI != null) {
                    progressDialogForAPI.cancel();
                }
            }

            @Override
            public void onFailure(Call<Details> call, Throwable t) {

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

    private void setUIData(final Details details) {
        textViewEmailId.setText(details.getStudent().getEmail());
        textViewPhoneNumber.setText(details.getStudent().getMobile());
        textViewStudentAddress.setText(details.getStudent().getAddress() + ", " + details.getStudent().getCity() + ", " +
                details.getStudent().getState() + ", " + details.getStudent().getCountry() + ", " + details.getStudent().getPincode());

       /* textViewCourseName.setText(details.getStudent().getStudentcourses().get(0).getCourse().getCourseName());
        textViewCourseDuration.setText(details.getStudent().getStudentcourses().get(0).getCourse().getDuration());
        textViewCourseDurationType.setText(details.getStudent().getStudentcourses().get(0).getCourse().getDurationType());
        textViewCourseFee.setText(details.getStudent().getStudentcourses().get(0).getCourse().getCoursefee());

        //fees details
        textViewTotalFees.setText(details.getStudent().getStudentcourses().get(0).getCourse().getTotalfee());
        //textViewPaidFees.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getPaidAmt());
        //textViewBalanceFees.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getRemainingAmt());

        //registration
        textViewRegistrationTotalAmount.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(0).getAmount());
        textViewRegistrationPaidFees.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(0).getPaidAmt());
        textViewRegistrationRemainingFee.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(0).getRemainingAmt());
        textViewRegistrationPaidOnDate.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(0).getPaidDate().toString());

        //1st installment
        textView1stTotalAmount.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getAmount());
        textView1stPaidFees.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getPaidAmt());
        textView1stRemainingFee.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getRemainingAmt());
        textView1stPaidOnDate.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(1).getPaidDate().toString());

        //2st installment
        textView2ndTotalAmount.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(2).getAmount());
        textView2ndPaidFees.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(2).getPaidAmt());
        textView2ndRemainingFee.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(2).getRemainingAmt());
//        textView2ndPaidOnDate.setText(details.getStudent().getStudentcourses().get(0).getStudentcoursesfeemng().get(2).getPaidDate().toString());*/


        if (details.getStudent().getStudentbatches() != null && details.getStudent().getStudentbatches().size() > 0)
        {
            textViewBatchDetails.setVisibility(View.VISIBLE);
            viewBatchDetailsTop.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
            // recyclerview setadapter

            // pass list of StudentBatches
            recyclerView.setAdapter(new StudentDetailsAdapter(getActivity(), details.getStudent().getStudentbatches()));

            //recyclerView.setAdapter(new StudentDetailsAdapter(getActivity(), 6));

        } else {
            textViewBatchDetails.setVisibility(View.GONE);
            viewBatchDetailsTop.setVisibility(View.GONE);
            recyclerView.setVisibility(View.GONE);
        }


        if (details.getStudent().getStudentcourses() != null && details.getStudent().getStudentcourses().size() > 0)
        {
            textViewCourseDetails.setVisibility(View.VISIBLE);
            viewCourseDetails.setVisibility(View.VISIBLE);
            recyclerViewCourseDetails.setVisibility(View.VISIBLE);
            // recyclerview setadapter

            // pass list of StudentBatches
            recyclerViewCourseDetails.setAdapter(new StudentCourseAdapter(getActivity(), details.getStudent().getStudentcourses()));

            //recyclerView.setAdapter(new StudentDetailsAdapter(getActivity(), 6));

        } else {
            textViewCourseDetails.setVisibility(View.GONE);
            viewCourseDetails.setVisibility(View.GONE);
            recyclerViewCourseDetails.setVisibility(View.GONE);
        }


        buttonParentDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ParentDetailsActivity.class);
                intent.putExtra("parentDetails", details.getStudent().getStudentparents());
                startActivity(intent);

            }
        });

    }


    public void setNavData(Student student) {
        if (student != null) {
            StudentDetailsActivity.headerView.setVisibility(View.VISIBLE);
            if (student.getFname() != null && student.getLname() != null) {
                StudentDetailsActivity.textViewUserName.setText(student.getFname() + " " + student.getLname());
            } else {
                if (student.getFname() != null) {
                    StudentDetailsActivity.textViewUserName.setText(student.getFname());
                } else {
                    StudentDetailsActivity.textViewUserName.setText("N/A");
                }
            }

            if (student.getEmail() != null) {
                StudentDetailsActivity.textViewEmailId.setText(student.getEmail());
            } else {
                StudentDetailsActivity.textViewEmailId.setText("N/A");
            }


            // https://upload.wikimedia.org/wikipedia/commons/1/14/Deepika_Padukone_December_2015.jpg
            String url = null;
            if (student.getImgurl() != null) {
                url = student.getImgurl();
            } else {
                url = "https://upload.wikimedia.org/wikipedia/commons/1/14/Deepika_Padukone_December_2015.jpg";
            }
            Picasso.with(getActivity())
                    .load(url)
                    .placeholder(R.drawable.defaultfemaleimg)
                    .into(StudentDetailsActivity.imageViewProfile);


        } else {
            StudentDetailsActivity.headerView.setVisibility(View.GONE);
        }
    }
}
