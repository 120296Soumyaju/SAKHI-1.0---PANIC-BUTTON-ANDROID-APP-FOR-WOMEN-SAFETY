package com.example.sos;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class EmailActivity extends AppCompatActivity {
    TextView txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acitivity_email);
        txtEmail=findViewById(R.id.txt_email);
        txtEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try{
                    Intent intent = new Intent (Intent.ACTION_VIEW , Uri.parse("mailto:" + "deepalichourasiya19@gmail.com"+","+"soumyaju12@gmail.com"));
                    intent.putExtra(Intent.EXTRA_SUBJECT, "Help me I m in Trouble!!!!!!!!!!!!!!");
                    intent.putExtra(Intent.EXTRA_TEXT, "(100),(8369076587) please Contact these two numbers and help me out as soon as possible ");
                    startActivity(intent);
                }catch(ActivityNotFoundException e){
                    //TODO smth
                }
            }
        });
    }
}
