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

import java.util.List;

public class StudentDetailsAdapter extends RecyclerView.Adapter<StudentDetailsAdapter.ViewHolder> {

    private Context context;

    int size;
    public StudentDetailsAdapter(Context context, int size) {
        this.context = context;
        this.size = size;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_student_details, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //holder.textViewBatchCourseName.setText(details.get(position).getCourseName());

    }

    @Override
    public int getItemCount() {
        return size;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewBatchCourseName;
        private TextView textViewBatchTime;
        private TextView textViewBatchCourseDuration;
        private TextView textViewBatchStartDate;
        private TextView textViewBatchEndDate;
        private ImageView imageViewBatchCourseImage;
        private ImageView imageViewTime;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewBatchCourseName = (TextView)itemView.findViewById(R.id.textViewBatchCourseName);
            textViewBatchTime = (TextView)itemView.findViewById(R.id.textViewBatchTime);
            textViewBatchCourseDuration = (TextView)itemView.findViewById(R.id.textViewBatchCourseDuration);
            textViewBatchStartDate = (TextView)itemView.findViewById(R.id.textViewBatchStartDate);
            textViewBatchEndDate = (TextView)itemView.findViewById(R.id.textViewBatchEndDate);
            imageViewBatchCourseImage = (ImageView)itemView.findViewById(R.id.imageViewBatchCourseImage);
            imageViewTime = (ImageView)itemView.findViewById(R.id.imageViewTime);


        }
    }
}
