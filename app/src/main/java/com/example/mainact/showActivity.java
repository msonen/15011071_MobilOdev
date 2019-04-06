package com.example.mainact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class showActivity extends AppCompatActivity {

    private PassData received = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        this.received = (PassData) this.getIntent().getSerializableExtra("data");
        this.put_data();

    }


    protected void btn_call(View v){

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+received.getPhone()));
        startActivity(intent);

    }

    protected void btn_lectures(View v){

        Intent intent = new Intent(this, lectures.class);
        startActivity(intent);

    }

    protected void btn_email(View e){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/html");
        intent.putExtra(Intent.EXTRA_EMAIL, received.getSurname());
        intent.putExtra(Intent.EXTRA_SUBJECT, "Subject");
        intent.putExtra(Intent.EXTRA_TEXT, "I'm email body.");

        startActivity(Intent.createChooser(intent, "Send Email"));
    }

    private void put_data(){


        String str = " Years old";
        ((TextView)this.findViewById(R.id.txt_name)).setText(received.getName());
        ((TextView)this.findViewById(R.id.txt_surname)).setText(received.getSurname());
        ((TextView)this.findViewById(R.id.txt_ssn)).setText(received.getSsn());
        Calendar cal =Calendar.getInstance();
        int age = cal.get(Calendar.YEAR) - received.getBirth_year();

        Bitmap bmp;
        byte[] byteArray = received.getPic_photo();
        bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        ((ImageView)this.findViewById(R.id.imageView2)).setImageBitmap(bmp);
        ((TextView)this.findViewById(R.id.txt_age)).setText(String.valueOf(age) + str);


    }


    private void toast(String message){

        Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
    }
}
