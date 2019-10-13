package com.example.galgelej;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class WelcomeActivity extends AppCompatActivity implements Runnable {

    static WelcomeActivity activityShownNow = null;
    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        ImageView iv = new ImageView(this);
        iv.setImageResource(R.drawable.galge);
        setContentView(iv);

        if (savedInstanceState == null){
            handler.postDelayed(this,3000);
        }
        activityShownNow = this;
    }

    public void run(){
        startActivity(new Intent(this, HomeActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

        activityShownNow.finish();
        activityShownNow = null;
    }

    @Override
    public void finish(){
        super.finish();
        handler.removeCallbacks(this);
    }
}
