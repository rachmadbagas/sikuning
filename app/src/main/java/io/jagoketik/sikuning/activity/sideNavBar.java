package io.jagoketik.sikuning.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
import android.widget.TextView;
import android.widget.Toast;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.info_angkot;
import io.jagoketik.sikuning.fragment.kritik_saran;
import io.jagoketik.sikuning.fragment.main_usernameFrag;
import io.jagoketik.sikuning.fragment.minta_bantuan;
import io.jagoketik.sikuning.order_alternate;
import io.jagoketik.sikuning.fragment.about;

public class sideNavBar extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    DrawerLayout drawerLayout;
    public NavigationView navigationView;
    CardView sewaangkot,krisar,keluhan;
    ImageView naikangkot,infoangkot,minban;
    boolean doubleBackToExitPressedOnce = false;
    TextView nameTV, statusTV;

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
        minban = findViewById(R.id.minban);

        View header = navigationView.getHeaderView(0);
        nameTV = (TextView) header.findViewById(R.id.dwnameTV);
        statusTV = (TextView) header.findViewById(R.id.dwstatusTV);

        SharedPreferences sharedPref = this.getSharedPreferences("auth", Context.MODE_PRIVATE);
        String name = sharedPref.getString("NAME", "");
        int status = sharedPref.getInt("ISDRIVER", 0);

        nameTV.setText(name);
        statusTV.setText(status == 1 ? "Driver" : "Customer");

        krisar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.menuPanel,new kritik_saran())
                        .commit();
            }
        });

        minban.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.menuPanel,new minta_bantuan())
                        .commit();
            }
        });

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
                SharedPreferences sharedPref = this.getSharedPreferences("auth", Context.MODE_PRIVATE);
                SharedPreferences.Editor AUTH_USER = sharedPref.edit();
                AUTH_USER.putString("ID", null);
                AUTH_USER.putString("TOKEN", null);
                AUTH_USER.putString("NAME", null);
                AUTH_USER.putString("ALAMAT", null);
                AUTH_USER.putString("EMAIL", null);
                AUTH_USER.putString("HP", null);
                AUTH_USER.putInt("ISDRIVER", 9999);
                AUTH_USER.putString("LAST_LOGIN", null);
                AUTH_USER.putString("CREATED_AT", null);
                AUTH_USER.commit();
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
