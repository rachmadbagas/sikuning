package io.jagoketik.sikuning.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.jagoketik.sikuning.R;

public class splash_screen extends AppCompatActivity {
    private int loadTime = 4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent as = new Intent(splash_screen.this, LoginActivity.class);
              startActivity(as);
              finish();
            }
        },loadTime);
    }
}
