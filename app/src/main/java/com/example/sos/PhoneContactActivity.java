package com.example.sos;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.location.Location;
import android.net.Uri;
import android.provider.ContactsContract;
import android.provider.SyncStateContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.TextView;

import static android.provider.Settings.System.CONTENT_URI;


public class PhoneContactActivity extends AppCompatActivity {
    TextView txtAdd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonecontact);
        txtAdd = findViewById(R.id.txt_add);
        txtAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
                //startActivityForResult(intent, 1);
                AlertDialog alertDialog = new AlertDialog.Builder(PhoneContactActivity.this).create(); //Read Update
                alertDialog.setTitle("Help I m in trouble");
                alertDialog.setMessage("SOS! I need help!!!!!!");
                alertDialog.setButton("Continue..", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent smsIntent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:8291561777"));
                            smsIntent.setData(Uri.parse("sms:" + ContactsContract.Contacts.CONTENT_URI));
                            smsIntent.putExtra("sms_body", "help me out" + "(100),(8369076587) please Contact these two numbers and help me out as soon as possible");
                            startActivity(smsIntent);
                        }




                });

                alertDialog.show();  //<-- See This!
            }
        });
    }
}
