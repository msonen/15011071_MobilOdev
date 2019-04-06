package com.example.mainact;
import java.io.ByteArrayOutputStream;
import java.lang.*;
import java.util.*;
import android.content.*;
import android.graphics.Bitmap;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private PassData data_pack;
    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView;
    private Bitmap photo_pic=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("msg", "on create");
        setContentView(R.layout.activity_main);
        this.imageView = this.findViewById(R.id.img_pic);
        if (savedInstanceState !=null){

            PassData data = (PassData) savedInstanceState.getSerializable("data_packet");
            if (data!=null){

                this.data_pack = data;
               // ((TextView)findViewById(R.id.txt_name)).setText(data.getName());
            }
        }


    }

    protected void clk(View view) {
    }

    protected void clk_submit(View v){

        if (photo_pic == null) {

            toast("Take Your Profil pic!");
            return;
        }
        ByteArrayOutputStream bStream = new ByteArrayOutputStream();
        this.photo_pic.compress(Bitmap.CompressFormat.PNG, 100, bStream);
        byte[]  profile_pic = bStream.toByteArray();
        String name = ((EditText)this.findViewById(R.id.txt_name)).getText().toString();
        String email = ((EditText)this.findViewById(R.id.txt_email)).getText().toString();
        String phone = ((EditText)this.findViewById(R.id.txt_phone)).getText().toString();
        String ssn = ((EditText)this.findViewById(R.id.txt_ssn)).getText().toString();
        int birth_year = ((DatePicker)this.findViewById(R.id.datePicker1)).getYear();
        this.data_pack = new PassData(name, email, phone, ssn, birth_year, profile_pic);

        Intent intent = new Intent(this, showActivity.class);
        intent.putExtra("data",this.data_pack);
        startActivity(intent);



    }

    protected void imgCapture(View v){

        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);

    }




    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == CAMERA_REQUEST && resultCode == RESULT_OK) {
            photo_pic = (Bitmap) data.getExtras().get("data");

            imageView.setImageBitmap(photo_pic);
        }
    }


    private void toast(String message){

        Toast.makeText(this , message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.v("msg", "onSavedInstance");
        if (this.data_pack!=null)
            outState.putSerializable("data_packet", this.data_pack);

    }

    @Override

    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);
        Log.v("msg", "onRestoreInstance");

    }


}

