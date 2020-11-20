package com.myapplication.jetpacknavexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static com.myapplication.jetpacknavexample.FirstFragment.countDownTimer;

public class Login extends AppCompatActivity {
    EditText name;
    EditText password;
    Button register;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        name = findViewById(R.id.loginname);
        password = findViewById(R.id.loginpassword);
        register = findViewById(R.id.registerbtn);
        login = findViewById(R.id.loginbtn);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,Register.class);
                startActivity(intent);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = name.getText().toString();
                String userpassword = password.getText().toString();
                String usernameregister = "";
                String userpasswordregister="";
                String useremailregister ="";
                SharedPreferences preferences = getSharedPreferences("register", MODE_PRIVATE);
               /* userdetail = preferences.getString(user + userpassword + "data", "Username or password is Incorrect");
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("display", userdetail);j
                editor.commit();*/

               usernameregister = preferences.getString("username","");
               useremailregister = preferences.getString("useremail","");
               userpasswordregister = preferences.getString("userpassword","");

               if(user.equals(usernameregister) || user.equals(useremailregister) && userpassword.equals(userpasswordregister)){
                   Intent home = new Intent(Login.this, MainActivity.class);
                   startActivity(home);

                   name.setText("");
                   password.setText("");
               }
               else{
                   Toast.makeText(Login.this, "Enter Correct Username or Password", Toast.LENGTH_SHORT).show();


                }
            }
        });
    }

  /*  @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "Activity OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "Activity OnResume", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "Activity OnPause", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "Activity OnStop", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "Activity OnDestory", Toast.LENGTH_LONG).show();
    }*/
}