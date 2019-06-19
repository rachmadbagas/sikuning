package io.jagoketik.sikuning.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.info_angkot;
import io.jagoketik.sikuning.fragment.main_usernameFrag;
import io.jagoketik.sikuning.order_alternate;

public class MainMenuActivity extends AppCompatActivity {

    CardView sewaangkot,krisar,keluhan;
    ImageView naikangkot,infoangkot;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.just_for_include);
        sewaangkot = findViewById(R.id.sewaAngkot);
        krisar = findViewById(R.id.krisar);
        keluhan = findViewById(R.id.keluhan);
        naikangkot = findViewById(R.id.naikAngkot);
        infoangkot = findViewById(R.id.infoAngkot);

        naikangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent as = new Intent(MainMenuActivity.this, order_alternate.class);
                startActivity(as);
            }
        });

        sewaangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent as = new Intent(MainMenuActivity.this,)
            }
        });
        infoangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.menuPanel,new info_angkot())
                        .commit();
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.menuPanel,new main_usernameFrag())
                .commit();
    }

    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
           finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;

            }
        }, 2000);
    }

}