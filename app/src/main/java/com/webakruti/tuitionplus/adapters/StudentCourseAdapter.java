package com.webakruti.tuitionplus.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.webakruti.tuitionplus.R;
import com.webakruti.tuitionplus.models.Student;

import java.util.List;

public class StudentCourseAdapter extends RecyclerView.Adapter<StudentCourseAdapter.ViewHolder> {


        private Context context;
        List<Student.Studentcourse> list;

        public StudentCourseAdapter(Context context, List<Student.Studentcourse> list) {
            this.context = context;
            this.list = list;

        }


    @NonNull
    @Override
    public StudentCourseAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student_course_fees_details, viewGroup, false);
        StudentCourseAdapter.ViewHolder viewHolder = new StudentCourseAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StudentCourseAdapter.ViewHolder viewHolder,final int position) {

        final Student.Studentcourse studentcourse = list.get(position);

        //course details
        viewHolder.textViewCourseName.setText(studentcourse.getCourse().getCourseName());
        viewHolder.textViewCourseDuration.setText(studentcourse.getCourse().getDuration());
        viewHolder.textViewCourseDurationType.setText(studentcourse.getCourse().getDurationType());
        viewHolder.textViewCourseFee.setText(studentcourse.getCourse().getCoursefee());

        //fees details
        viewHolder.textViewTotalFees.setText(studentcourse.getCourse().getTotalfee());

        //registration
        viewHolder.textViewRegistrationTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(0).getAmount());
        viewHolder.textViewRegistrationPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidAmt());
        viewHolder.textViewRegistrationRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(0).getRemainingAmt());
        viewHolder.textViewRegistrationPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(0).getPaidDate().toString());

        //1st installment
        viewHolder.textView1stTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(1).getAmount());
        viewHolder.textView1stPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidAmt());
        viewHolder.textView1stRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(1).getRemainingAmt());
        viewHolder.textView1stPaidOnDate.setText(studentcourse.getStudentcoursesfeemng().get(1).getPaidDate().toString());

        //2nd installment
        viewHolder.textView2ndTotalAmount.setText(studentcourse.getStudentcoursesfeemng().get(2).getAmount());
        viewHolder.textView2ndPaidFees.setText(studentcourse.getStudentcoursesfeemng().get(2).getPaidAmt());
        viewHolder.textView2ndRemainingFee.setText(studentcourse.getStudentcoursesfeemng().get(2).getRemainingAmt());



    }

    @Override
        public int getItemCount() {
            return list.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {

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
