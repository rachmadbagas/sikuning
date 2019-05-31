package io.jagoketik.sikuning;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        TextView usernameTV = findViewById(R.id.usernameTV);
        usernameTV.setText(this.getIntent().getSerializableExtra("username").toString());
    }
}
