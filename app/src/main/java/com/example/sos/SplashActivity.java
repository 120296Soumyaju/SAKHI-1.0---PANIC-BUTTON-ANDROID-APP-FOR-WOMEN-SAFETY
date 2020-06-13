package com.example.sos;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

@SuppressWarnings("ALL")
public class
SplashActivity extends AppCompatActivity {
    private int SLEEP_TIMER=3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);
        Objects.requireNonNull(getSupportActionBar()).hide();
        LogoLauncher logoLauncher=new LogoLauncher();
        logoLauncher.start();

    }
    private class LogoLauncher extends Thread{
        public void run(){
            try{
                sleep(1000*SLEEP_TIMER);
        }catch (InterruptedException e){
                e.printStackTrace();
            }
            Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
            startActivity(intent);
            SplashActivity.this.finish();

        }
    }
}
