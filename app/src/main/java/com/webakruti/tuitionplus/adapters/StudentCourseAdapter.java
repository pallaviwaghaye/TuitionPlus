package com.webakruti.tuitionplus.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.models.Student;

import java.util.List;

import static android.view.ViewGroup.LayoutParams.MATCH_PARENT;
import static android.view.ViewGroup.LayoutParams.WRAP_CONTENT;

public class StudentCourseAdapter extends RecyclerView.Adapter<StudentCourseAdapter.ViewHolder> {


    private Context context;
    List<Student.Studentcourse> list;

    public StudentCourseAdapter(Context context, List<Student.Studentcourse> list) {
        this.context = context;
        this.list = list;

    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student_course_fees_details, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        final Student.Studentcourse studentcourse = list.get(position);

        //course details
        viewHolder.textViewCourseName.setText(studentcourse.getCourse().getCourseName());
        viewHolder.textViewCourseDuration.setText(studentcourse.getCourse().getDuration());
        viewHolder.textViewCourseDurationType.setText(studentcourse.getCourse().getDurationType());
        viewHolder.textViewCourseFee.setText(studentcourse.getCourse().getCoursefee());

        if (list.size() == 1) {
            viewHolder.linearLayout.getLayoutParams().width = MATCH_PARENT;
            viewHolder.cardView.getLayoutParams().width = MATCH_PARENT;
        } else {
            viewHolder.linearLayout.getLayoutParams().width = DpToPixel(context, WRAP_CONTENT);
            viewHolder.cardView.getLayoutParams().width = DpToPixel(context, 300);

        }

        //fees details
        viewHolder.textViewTotalFees.setText(studentcourse.getCourse().getTotalfee());

        if (studentcourse.getStudentcoursesfeemng() != null && studentcourse.getStudentcoursesfeemng().size() > 0) {

            int size = studentcourse.getStudentcoursesfeemng().size();

            if (size == 1) {

                viewHolder.linearLayoutRegistration.setVisibility(View.VISIBLE);
                //registration
                viewHolder.textViewRegistrationTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(0).getAmount());
                viewHolder.textViewRegistrationPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidAmt());
                viewHolder.textViewRegistrationRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(0).getRemainingAmt());
                viewHolder.textViewRegistrationPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidDate().toString());

                viewHolder.linearLayoutFirstInstallmentAmount.setVisibility(View.GONE);
                viewHolder.view1stInstallment.setVisibility(View.GONE);
                viewHolder.linearLayoutSecondInstallment.setVisibility(View.GONE);
                viewHolder.view2ndInstallment.setVisibility(View.GONE);

            } else if (size == 2) {

                viewHolder.linearLayoutRegistration.setVisibility(View.VISIBLE);
                //registration
                viewHolder.textViewRegistrationTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(0).getAmount());
                viewHolder.textViewRegistrationPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidAmt());
                viewHolder.textViewRegistrationRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(0).getRemainingAmt());
                viewHolder.textViewRegistrationPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidDate().toString());

                viewHolder.linearLayoutFirstInstallmentAmount.setVisibility(View.VISIBLE);
                viewHolder.view1stInstallment.setVisibility(View.VISIBLE);
                //1st installment
                viewHolder.textView1stTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(1).getAmount());
                viewHolder.textView1stPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidAmt());
                viewHolder.textView1stRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(1).getRemainingAmt());
                viewHolder.textView1stPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidDate().toString());
                viewHolder.linearLayoutSecondInstallment.setVisibility(View.GONE);
                viewHolder.view2ndInstallment.setVisibility(View.GONE);


            } else if (size == 3) {

                viewHolder.linearLayoutRegistration.setVisibility(View.VISIBLE);
                //registration
                viewHolder.textViewRegistrationTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(0).getAmount());
                viewHolder.textViewRegistrationPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidAmt());
                viewHolder.textViewRegistrationRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(0).getRemainingAmt());
                viewHolder.textViewRegistrationPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidDate().toString());

                viewHolder.linearLayoutFirstInstallmentAmount.setVisibility(View.VISIBLE);
                viewHolder.view1stInstallment.setVisibility(View.VISIBLE);
                //1st installment
                viewHolder.textView1stTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(1).getAmount());
                viewHolder.textView1stPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidAmt());
                viewHolder.textView1stRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(1).getRemainingAmt());
                viewHolder.textView1stPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidDate().toString());

                viewHolder.linearLayoutSecondInstallment.setVisibility(View.VISIBLE);
                viewHolder.view2ndInstallment.setVisibility(View.VISIBLE);

                //2nd installment
                viewHolder.textView2ndTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(2).getAmount());
                viewHolder.textView2ndPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(2).getPaidAmt());
                viewHolder.textView2ndRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(2).getRemainingAmt());


            }


        } else {
            viewHolder.linearLayoutRegistration.setVisibility(View.GONE);
            viewHolder.linearLayoutFirstInstallmentAmount.setVisibility(View.GONE);
            viewHolder.linearLayoutSecondInstallment.setVisibility(View.GONE);
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public int DpToPixel(Context context, int dp) {
        float density = context.getResources().getDisplayMetrics().density;
        float px = dp * density;
        return (int) px;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout linearLayoutRegistration;
        private LinearLayout linearLayoutFirstInstallmentAmount;
        private LinearLayout linearLayoutSecondInstallment;
        private View view2ndInstallment;
        private View view1stInstallment;
        private View cardView;
        private LinearLayout linearLayout;

        //course details
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
        private TextView textView2ndPaidOnDate;


        public ViewHolder(View itemView) {
            super(itemView);

            linearLayoutRegistration = (LinearLayout) itemView.findViewById(R.id.linearLayoutRegistration);
            linearLayoutFirstInstallmentAmount = (LinearLayout) itemView.findViewById(R.id.linearLayoutFirstInstallmentAmount);
            linearLayoutSecondInstallment = (LinearLayout) itemView.findViewById(R.id.linearLayoutSecondInstallment);
            view2ndInstallment = (View) itemView.findViewById(R.id.view2ndInstallment);
            view1stInstallment = (View) itemView.findViewById(R.id.view1stInstallment);
            cardView = (CardView) itemView.findViewById(R.id.cardView);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearLayout);

            textViewCourseName = (TextView) itemView.findViewById(R.id.textViewCourseName);
            textViewCourseDuration = (TextView) itemView.findViewById(R.id.textViewCourseDuration);
            textViewCourseDurationType = (TextView) itemView.findViewById(R.id.textViewCourseDurationType);
            textViewCourseFee = (TextView) itemView.findViewById(R.id.textViewCourseFee);

            //fees details
            textViewTotalFees = (TextView) itemView.findViewById(R.id.textViewTotalFees);
            //textViewPaidFees = (TextView)rootView.findViewById(R.id.textViewPaidFees);

            //textViewBalanceFees = (TextView)rootView.findViewById(R.id.textViewBalanceFees);

            //registration fees
            textViewRegistrationTotalAmount = (TextView) itemView.findViewById(R.id.textViewRegistrationTotalAmount);
            textViewRegistrationPaidFees = (TextView) itemView.findViewById(R.id.textViewRegistrationPaidFees);
            textViewRegistrationRemainingFee = (TextView) itemView.findViewById(R.id.textViewRegistrationRemainingFee);
            textViewRegistrationPaidOnDate = (TextView) itemView.findViewById(R.id.textViewRegistrationPaidOnDate);

            //1st installment
            textView1stTotalAmount = (TextView) itemView.findViewById(R.id.textView1stTotalAmount);
            textView1stPaidFees = (TextView) itemView.findViewById(R.id.textView1stPaidFees);
            textView1stRemainingFee = (TextView) itemView.findViewById(R.id.textView1stRemainingFee);
            textView1stPaidOnDate = (TextView) itemView.findViewById(R.id.textView1stPaidOnDate);

            //2nd installment
            textView2ndTotalAmount = (TextView) itemView.findViewById(R.id.textView2ndTotalAmount);
            textView2ndPaidFees = (TextView) itemView.findViewById(R.id.textView2ndPaidFees);
            textView2ndRemainingFee = (TextView) itemView.findViewById(R.id.textView2ndRemainingFee);
            textView2ndPaidOnDate = (TextView) itemView.findViewById(R.id.textView2ndPaidOnDate);


        }
    }


}
