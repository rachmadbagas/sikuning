package io.jagoketik.sikuning.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.info_angkot;
import io.jagoketik.sikuning.fragment.main_usernameFrag;
import io.jagoketik.sikuning.order_alternate;
import io.jagoketik.sikuning.fragment.about;

public class sideNavBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    DrawerLayout drawerLayout;
    public NavigationView navigationView;
    CardView sewaangkot,krisar,keluhan;
    ImageView naikangkot,infoangkot;
    boolean doubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_side_nav_bar);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        sewaangkot = findViewById(R.id.sewaAngkot);
        krisar = findViewById(R.id.krisar);
        keluhan = findViewById(R.id.keluhan);
        naikangkot = findViewById(R.id.naikAngkot);
        infoangkot = findViewById(R.id.infoAngkot);

        naikangkot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent as = new Intent(sideNavBar.this, order_alternate.class);
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
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);
        switch (item.getItemId()){
            case R.id.about:
                getSupportFragmentManager().beginTransaction()
                        .add(R.id.menuPanel,new about())
                        .commit();

                break;
            case R.id.logout:
                Intent as = new Intent(sideNavBar.this,LoginActivity.class);
                startActivity(as);
                finish();
                Toast.makeText(this,"Berhasil Logout",Toast.LENGTH_SHORT).show();
                break;

        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
    @Override
    public void onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            finish();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Klik Back Lagi Untuk Keluar", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;

            }
        }, 2000);
    }

}
