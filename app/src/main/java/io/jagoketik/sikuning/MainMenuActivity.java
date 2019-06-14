package io.jagoketik.sikuning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    CardView sewaangkot,krisar,keluhan;
    ImageView naikangkot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        sewaangkot = findViewById(R.id.sewaAngkot);
        krisar = findViewById(R.id.krisar);
        keluhan = findViewById(R.id.keluhan);
        naikangkot = findViewById(R.id.naikAngkot);

        naikangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent as = new Intent(MainMenuActivity.this,order_alternate.class);
                startActivity(as);
            }
        });

        sewaangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent as = new Intent(MainMenuActivity.this,)
            }
        });

        getSupportFragmentManager().beginTransaction()
                .add(R.id.menuPanel,new main_usernameFrag())
                .commit();
    }
}