package com.example.mainact;

import android.content.Intent;
import android.support.annotation.ColorInt;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class DataAdapter extends RecyclerView.Adapter<DataAdapter.MyViewHolder> {

   protected List<Lecture> lecturesList;

     class MyViewHolder extends RecyclerView.ViewHolder  {
         private  TextView lecture_name, note;
         private View view;
         MyViewHolder(View view) {
            super(view);
            this.view = view;
            lecture_name = (TextView) view.findViewById(R.id.lec_name);
            note = (TextView) view.findViewById(R.id.lec_note);
             Log.v("MSG","onBindViewHolder");

         }

        TextView getLecture_name() {
             return lecture_name;
         }

         TextView getNote() {
             return note;
         }


     }


     DataAdapter(List<Lecture> lecturessList) {

         this.lecturesList = lecturessList;
         Log.v("MSG","onDataAdapter Constructor");

     }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.lecture_list_row, parent, false);
        Log.v("MSG","onCreateViewHolder");

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Lecture lecture = lecturesList.get(position);
        holder.getLecture_name().setText(lecture.getLecture_name());
        holder.getNote().setText(lecture.getLecture_note());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), LectureActivity.class);
                intent.putExtra("lec",lecturesList.get(position));
                view.getContext().startActivity(intent);
            }
        });
        Log.v("MSG","onBindViewHolder");
    }


    @Override
    public int getItemCount() {
        Log.v("MSG","getItemCount");

        return lecturesList.size();
    }
}
