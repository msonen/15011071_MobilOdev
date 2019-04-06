package com.example.mainact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.*;


public class lectures extends AppCompatActivity {

    private String[] notes = {"AA","BA", "BB", "CB", "CC", "DC", "DD", "FD","FF", "F0" };
    private String[] lecture_names = {
            "Inroduction to Mobile Programming",
            "Introduction to Computer Sciences",
            "Mathematics",
            "Mathematics II",
            "Physics I",
            "Programming Languages",
            "Physics II",
            "Circuit Theory I",
            "Circuit Theory II",
            "Electronics I",
            "Electronics II",
            "Elective I",
            "Elective II",
            "Elective III",
            "Elective IV",
            "Elective V"


    };
    private List<Lecture> lectures;
    private DataAdapter mAdapter;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lectures);
        this.lectures = new LinkedList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyleview1);

        Log.v("MSG","onCreate");
        this.fillList();
        mAdapter = new DataAdapter(this.lectures);
        //Log.v("MSG","DataAdapter created");

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        //Log.v("MSG","rcyleviewLayout seysi");

        recyclerView.setLayoutManager(mLayoutManager);
        //Log.v("MSG","set  layout seysi");

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        recyclerView.setAdapter(mAdapter);
        //Log.v("MSG","set adapter");


    }


    private void fillList(){

        Random r = new Random();

        for (int i=0; i<lecture_names.length; ++i)
        {
            this.lectures.add(new Lecture(lecture_names[i%lecture_names.length], notes[r.nextInt(notes.length)],r.nextFloat()*4,r.nextInt(60)));
        }
    }


}
