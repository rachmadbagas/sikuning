package io.jagoketik.sikuning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.angkot_sekitar;

public class order extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.order_panel,new angkot_sekitar())
                .commit();
    }

}
