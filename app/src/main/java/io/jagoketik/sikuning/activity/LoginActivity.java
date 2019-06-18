package io.jagoketik.sikuning.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.jagoketik.sikuning.R;
import io.jagoketik.sikuning.fragment.footerFrag;
import io.jagoketik.sikuning.fragment.loginFragment;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.loginContainer,new loginFragment())
                .add(R.id.loginContainer,new footerFrag())
                .commit();


    }


}
