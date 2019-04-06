package com.example.mainact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LectureActivity extends AppCompatActivity {

    private Lecture lecture = null;
    private  TextView name, avg, capacity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_lecture);
        this.lecture= (Lecture) this.getIntent().getSerializableExtra("lec");
        name =  this.findViewById(R.id.name_lecture);
        avg = findViewById(R.id.avg);
        capacity = findViewById(R.id.count);

        name.setText(lecture.getLecture_name());
        avg.setText(String.valueOf(lecture.getLecture_avg()));
        capacity.setText(String.valueOf(lecture.getRegistered()));
    }
}
