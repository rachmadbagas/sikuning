package io.jagoketik.sikuning;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {
    private ArrayList<User> users;
    EditText usernameET , passwordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        users = new ArrayList<User>();
        Button regis = (Button) findViewById(R.id.btn_regis);
        Button login = (Button) findViewById(R.id.btn_login);
        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);


        regis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent as =(Intent) new Intent(LoginActivity.this, RegisterActivity.class);
                startActivityForResult(as, 999);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User auth = new User("","");
                String username = usernameET.getText().toString();
                String password = passwordET.getText().toString();
                boolean status = false;
                for (int i=0; i<users.size(); i++){
                    User user = users.get(i);
                    if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                        // Masuk ke Dashboard
                        auth = user;
                        Toast.makeText(LoginActivity.this, "Selamat datang " + auth.getUsername(), Toast.LENGTH_SHORT).show();
                        status = true;
                    }
                }
                // Cek jika tidak ditemukan
                if(status == false){
                    Toast.makeText(LoginActivity.this, "Password / username salah", Toast.LENGTH_SHORT).show();
                }else{
                    Intent a = new Intent(LoginActivity.this,MainMenuActivity.class);
                    a.putExtra("username" , auth.getUsername());
                    startActivity(a);
                }

            }
        });


    }
    protected void onActivityResult(int requestCode, int resultCode, Intent dataku) {
        if(requestCode == 999 && resultCode == RESULT_OK){
            User user = (User) dataku.getSerializableExtra("new_user");
            users.add(new User(user.getUsername().toString(),user.getPassword().toString()));
            // Opsional clear EditText
            usernameET.setText("");
//            Toast.makeText(LoginActivity.this, "nama " + user.getPassword(), Toast.LENGTH_SHORT).show();
            passwordET.setText("");
        }
    }
}
