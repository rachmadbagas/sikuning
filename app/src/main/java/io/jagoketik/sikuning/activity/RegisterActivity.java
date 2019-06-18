package io.jagoketik.sikuning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.registrationFrag;

public class RegisterActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);


        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment1,new registrationFrag())
                .commit();

    }
}
