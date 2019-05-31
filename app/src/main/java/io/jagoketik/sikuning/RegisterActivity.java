package io.jagoketik.sikuning;

import android.app.IntentService;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
    EditText usernameET,passwordET,konfirmET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        Button daftar = (Button) findViewById(R.id.daftarBtn);
        usernameET = findViewById(R.id.usernameET);
        passwordET = findViewById(R.id.passwordET);
        konfirmET = findViewById(R.id.konfirmET);

        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordET.getText().toString().equals(konfirmET.getText().toString())){
                    String username = usernameET.getText().toString();
                    String password = passwordET.getText().toString();
                    // Check
                    if (username.equals("") || password.equals("")) {
                        Toast.makeText(RegisterActivity.this, "Silahkan Isi Semua Kolom!", Toast.LENGTH_SHORT).show();
                    } else {
                        User user = new User(username, password);
                        Intent intent = new Intent();
                        intent.putExtra("new_user",user);
                        Toast.makeText(RegisterActivity.this, "Register Berhasil", Toast.LENGTH_SHORT).show();
                        setResult(RESULT_OK, intent);
                        finish();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "password tidak sama", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
