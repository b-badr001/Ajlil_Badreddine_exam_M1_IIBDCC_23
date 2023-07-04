package com.example.ajlil_badreddine_exam_m1_iibdcc_23;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;

    Button login;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        username=findViewById(R.id.usrname);
        password=findViewById(R.id.pswd);
        login=findViewById(R.id.btnLogin);
        sharedPreferences = getSharedPreferences("loginPref",
                MODE_PRIVATE);
        login.setOnClickListener(view -> {
            if(sharedPreferences==null) sharedPreferences=getSharedPreferences("loginPref",MODE_PRIVATE);
            String n = username.getText().toString();
            String e = password.getText().toString();
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("emailKey", n);
            editor.putString("pwdKey", e);
            editor.commit();
            username.setText("");
            password.setText("");
            Intent i=new Intent(LoginActivity.this,MainActivity.class);
            startActivity(i);

        });
    }
}