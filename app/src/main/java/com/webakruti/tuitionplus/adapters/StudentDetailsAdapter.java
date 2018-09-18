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

public class StudentDetailsAdapter extends RecyclerView.Adapter<StudentDetailsAdapter.ViewHolder> {

    private Context context;
    List<Student.Studentbatch> list;

    public StudentDetailsAdapter(Context context, List<Student.Studentbatch> list) {
        this.context = context;
        this.list = list;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_student_details, viewGroup, false);
        StudentDetailsAdapter.ViewHolder viewHolder = new StudentDetailsAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int position) {

        final Student.Studentbatch studentbatch = list.get(position);

        viewHolder.textViewBatchCourseName.setText(studentbatch.getBatch().getCourse().getCourseName());
        viewHolder.textViewBatchTime.setText(studentbatch.getBatch().getStartTime());
        viewHolder.textViewCourseTeacher.setText(studentbatch.getWhoAssinged());

        viewHolder.textViewBatchCourseDuration.setText(studentbatch.getBatch().getCourse().getDuration());
        viewHolder.textViewBatchStartDate.setText(studentbatch.getBatch().getStartDate());
        viewHolder.textViewBatchEndDate.setText(studentbatch.getBatch().getEndDate());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewBatchCourseName;
        private TextView textViewBatchTime;
        private TextView textViewCourseTeacher;

        private TextView textViewBatchCourseDuration;
        private TextView textViewBatchStartDate;
        private TextView textViewBatchEndDate;
        private ImageView imageViewBatchCourseImage;
        private ImageView imageViewTime;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewBatchCourseName = (TextView)itemView.findViewById(R.id.textViewBatchCourseName);
            textViewBatchTime = (TextView)itemView.findViewById(R.id.textViewBatchTime);
            textViewCourseTeacher = (TextView)itemView.findViewById(R.id.textViewCourseTeacher);
            textViewBatchCourseDuration = (TextView)itemView.findViewById(R.id.textViewBatchCourseDuration);
            textViewBatchStartDate = (TextView)itemView.findViewById(R.id.textViewBatchStartDate);
            textViewBatchEndDate = (TextView)itemView.findViewById(R.id.textViewBatchEndDate);
            imageViewBatchCourseImage = (ImageView)itemView.findViewById(R.id.imageViewBatchCourseImage);
            imageViewTime = (ImageView)itemView.findViewById(R.id.imageViewTime);


        }
    }
}
