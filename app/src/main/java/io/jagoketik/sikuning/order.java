package io.jagoketik.sikuning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
