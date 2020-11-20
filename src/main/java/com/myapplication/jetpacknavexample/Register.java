package com.myapplication.jetpacknavexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class Register extends AppCompatActivity {
    EditText name;
    EditText email;
    EditText password;
    EditText address;
    EditText mobileno;
    EditText confirmpassword;
    Spinner gender;
    String selectedgender;
    String gndr[];
    Button registerbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        address = findViewById(R.id.address);
        mobileno = findViewById(R.id.phoneno);
        gender = findViewById(R.id.gender);
        confirmpassword = findViewById(R.id.confirmpassword);
        registerbtn = findViewById(R.id.btnregister);

        gndr = getResources().getStringArray(R.array.gender);

        ArrayAdapter genderadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,gndr);
       genderadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        gender.setAdapter(genderadapter);
       gender.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectedgender = gndr[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });



        registerbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String pass = password.getText().toString();
                String cpass = confirmpassword.getText().toString();

                if(!TextUtils.isEmpty(name.getText())){
                    if(!TextUtils.isEmpty(email.getText())){
                        if(!TextUtils.isEmpty(address.getText())){
                            if(!TextUtils.isEmpty(mobileno.getText()) && mobileno.getText().length() >= 11) {
                                if (!TextUtils.isEmpty(password.getText()) && password.getText().length() >= 8) {
                                    if (!TextUtils.isEmpty(confirmpassword.getText()) && cpass.equals(pass)) {


                                        SharedPreferences preferences = getSharedPreferences("register",MODE_PRIVATE);
                                        String newuser = name.getText().toString();
                                        String useremail = email.getText().toString();
                                        String userpassword = password.getText().toString();
                                        String useraddress = address.getText().toString();
                                        String usergender = gender.getSelectedItem().toString();
                                        String usermobileno = mobileno.getText().toString();


                                        SharedPreferences.Editor editor = preferences.edit();
                                        //editor.putString(newuser + userpassword + "data", newuser + "\n" + useremail);
                                        editor.putString("username",newuser);
                                        editor.putString("useremail",useremail);
                                        editor.putString("useraddress",useraddress);
                                        editor.putString("usergender",usergender);
                                        editor.putString("usermobileno",usermobileno);
                                        editor.putString("userpassword",userpassword);
                                        editor.commit();

                                        Intent intent = new Intent(Register.this,MainActivity.class);
                                        startActivity(intent);
                                        name.setText("");
                                        email.setText("");
                                        password.setText("");
                                        name.setText("");


                                    } else {
                                        Toast.makeText(Register.this, "Please Enter same Password", Toast.LENGTH_SHORT).show();
                                    }
                                } else{
                                    Toast.makeText(Register.this, "Please Enter password at least 8 character", Toast.LENGTH_SHORT).show();
                            }
                            }else{
                                Toast.makeText(Register.this, "Please Enter valid mobile No", Toast.LENGTH_SHORT).show();
                            }

                        }else{
                            Toast.makeText(Register.this, "Please Enter Your Address", Toast.LENGTH_SHORT).show();
                        }

                    }else{
                        Toast.makeText(Register.this, "Please Enter email", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(Register.this, "Please enter name", Toast.LENGTH_SHORT).show();
                }



            }
        });
    }
}
